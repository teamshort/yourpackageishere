package com.teamshort.rocks.YourPackageIsHere;

import com.teamshort.rocks.YourPackageIsHere.model.Building;
import com.teamshort.rocks.YourPackageIsHere.model.Tenant;
import org.junit.Test;


import static org.junit.Assert.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


public class TenantTest {

    @Test
    public void testTenantDefaultConstructor() {
        Tenant tenant = new Tenant();
        assertNull(tenant.getFirstname());
        assertNull(tenant.getLastname());
        assertNull(tenant.getAptnum());
        assertNull(tenant.getEmail());
        assertNull(tenant.getPhonenum());
        assertNull(tenant.getBuilding());

    }

    //Private helper test function to initialize a Tenant instance
    private Tenant initialize(){
        return new Tenant("Bloopy","Blooperson","bloop@bloop.com","1D","111-111-1111", new Building());
    }

    @Test
    public void testTenantConstructor(){
//  Tenant(String firstname, String lastname, String email, String aptnum, String phonenum, Building building)
        Tenant tenant = initialize();
        assertEquals("Bloopy",tenant.getFirstname());
        assertEquals("Blooperson", tenant.getLastname());
        assertEquals("bloop@bloop.com", tenant.getEmail());
        assertEquals("1D", tenant.getAptnum());
        assertEquals("111-111-1111", tenant.getPhonenum());

    }

//  -----------  GETTER TESTS  ----------------  //
    @Test
    public void testGetFirstName(){
        Tenant tenant = initialize();
        assertEquals("Bloopy", tenant.getFirstname());

    }

    @Test
    public void testGetLastName(){
        Tenant tenant = initialize();
        assertEquals("Blooperson", tenant.getLastname());
    }

    @Test
    public void testGetEmail(){
        Tenant tenant = initialize();
        assertEquals("bloop@bloop.com", tenant.getEmail());
    }

    @Test
    public void testGetAptNum(){
        Tenant tenant = initialize();
        assertEquals("1D", tenant.getAptnum());
    }

    @Test
    public void testGetPhoneNum(){
        Tenant tenant = initialize();
        assertEquals("111-111-1111", tenant.getPhonenum());
    }

    //  -----------  SETTER TESTS  ----------------  //

    @Test
    public void testSetFirstName(){
        Tenant tenant = initialize();
        tenant.setFirstname("Blossom");
        assertEquals("Blossom", tenant.getFirstname());

    }

    @Test
    public void testSetLastName(){
        Tenant tenant = initialize();
        tenant.setLastname("Bubbles");
        assertEquals("Bubbles", tenant.getLastname());
    }

    @Test
    public void testSetEmail(){
        Tenant tenant = initialize();
        tenant.setEmail("bloopy@bloopy.com");
        assertEquals("bloopy@bloopy.com", tenant.getEmail());
    }

    @Test
    public void testSetAptNum(){
        Tenant tenant = initialize();
        tenant.setAptnum("2B");
        assertEquals("2B", tenant.getAptnum());
    }

    @Test
    public void testSetPhoneNum(){
        Tenant tenant = initialize();
        tenant.setPhonenum("222-222-2222");
        assertEquals("222-222-2222", tenant.getPhonenum());
    }


}
