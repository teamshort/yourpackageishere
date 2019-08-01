package com.teamshort.rocks.YourPackageIsHere;


import com.teamshort.rocks.YourPackageIsHere.model.Building;
import com.teamshort.rocks.YourPackageIsHere.model.Tenant;
import com.teamshort.rocks.YourPackageIsHere.repository.BuildingRepository;
import com.teamshort.rocks.YourPackageIsHere.repository.TenantRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//Resources: Jason Hiskey - https://codefellows.slack.com/files/UBJJGNL82/FKY9V3BNY/integration_testing_guide.java

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
@ContextConfiguration
public class TenantControllerTest {

    //  -----------  INTEGRATION TESTS FOR GET REQS  ----------------  //

    @Autowired
    static
    MockMvc mockMvc;

    @Autowired
    WebApplicationContext context;

    private InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix("*.html");

        return viewResolver;
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    // This will create a auth token that will be injected into a test of a page that requires auth.
    public static RequestPostProcessor testUser() throws Exception {
        return user("building1").password("foo").roles("ADMIN");
    }

    //@GetMapping("/tenant/all")
    @WithMockUser
    @Test
    public void testgetAllTenants() throws Exception {
        mockMvc.perform(
                get("/tenant/all").with(testUser())).andExpect(content().string(containsString("Tenants")));
    }

    //@GetMapping("/tenant/{id}")
    @WithMockUser
    @Test
    public void testgetTenantPage() throws Exception {
        mockMvc.perform(
            get("/tenant/4").with(testUser())).andExpect(content().string(containsString(" <div class=\"form-group\">\n" +
                "            <label for=\"lastname\">Last Name</label><input name=\"lastname\" id=\"lastname\" class=\"form-control\"/>\n" +
                "        </div>\n" +
                "        <div class=\"form-group\">\n" +
                "            <label for=\"email\">Email</label><input type=\"email\" name=\"email\" id=\"email\" class=\"form-control\"/>\n" +
                "        </div>\n" +
                "        <div class=\"form-group\">\n" +
                "            <label for=\"aptnum\">Apartment Number</label><input name=\"aptnum\" id=\"aptnum\" class=\"form-control\" />\n" +
                "        </div>")));
    }

    //@GetMapping("/tenant/add")
    @WithMockUser
    @Test
    public void testgetTenantAddPage() throws Exception {
        mockMvc.perform(
            get("/tenant/add").with(testUser())).andExpect(content().string(containsString(" ")));
    }
//
//  -----------  END-TO-END TESTS  ----------------  //
// Resources:
// https://stackoverflow.com/questions/38966718/mockmvc-status-expected200-but-was302
// https://stackoverflow.com/questions/17972428/mock-mvc-add-request-parameter-to-test
// https://memorynotfound.com/unit-test-spring-mvc-rest-service-junit-mockito/#unit-test-http-post

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    TenantRepository tenantRepository;

    //Private helper test function to initialize a Tenant instance
    private Tenant initialize(){
        return new Tenant("Bloopy","Blooperson","bloop@bloop.com","1D","111-111-1111", new Building());
    }

    @WithMockUser
    @Test
    public void testTenantCRUD() throws Exception {
        Tenant tenant = initialize();

        mockMvc.perform(
                post("/tenantcreate")
                        .with(testUser())
                        .param("firstname", "Bloopy")
                        .param("lastname", "Blooperson")
                        .param("aptnum", "1D")
                        .param("phonenum", "111-111-1111")
                        .param("email", "bloop@bloop.com"))
                .andDo(print())
                .andExpect(header().string("location", containsString("/tenant/all")));

        List<Tenant> tenantCreate = tenantRepository.findByEmail("bloop@bloop.com");

        assertEquals(tenant.getEmail(),tenantCreate.get(0).getEmail()); // check Creation and Read data

        //UPDATE instance' name
        tenantCreate.get(0).setEmail("blooperson@blooperson.com");
        tenantRepository.save(tenantCreate.get(0));

        List<Tenant> tenantResUpdate = tenantRepository.findByEmail("blooperson@blooperson.com");


        assertEquals("blooperson@blooperson.com",tenantResUpdate.get(0).getEmail()); // check Update and Read data

        //DELETE created test building instance from DB table
        mockMvc.perform(
                delete("/tenant/" + tenantResUpdate.get(0).getId() + "/delete")
                        .with(testUser()))
                .andDo(print())
                .andExpect(view().name("allTenants"));
        assertEquals(new ArrayList<>(),tenantRepository.findByEmail("blooperson@blooperson.com"));

    }

}
