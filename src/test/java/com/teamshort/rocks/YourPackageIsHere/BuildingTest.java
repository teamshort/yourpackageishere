package com.teamshort.rocks.YourPackageIsHere;

import com.teamshort.rocks.YourPackageIsHere.model.Building;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


public class BuildingTest {

    @Test
    public void testBuildingDefaultConstructor() {
        Building building = new Building();
        assertNull(building.getTenants());
        assertNull(building.getCity());
        assertNull(building.getEmail());
        assertNull(building.getPassword());
        assertNull(building.getState());
        assertNull(building.getStreetaddress());

    }

    @Test
    public void testBuildingConstructor(){
//  Building(String username, String name, String streetaddress, String city, String state, String zip, String email, String password)
    Building building = new Building("bloop","Bloop Building","1 Bloop Ave",
            "Bloop City", "WA", "90210","bloop@bloop.com","bloop123");
    assertEquals("bloop",building.getUsername());
    assertEquals("Bloop Building", building.getName());
    assertEquals("1 Bloop Ave", building.getStreetaddress());
    assertEquals("Bloop City",building.getCity());
    assertEquals("WA", building.getState());
    assertEquals("90210", building.getZip());
    assertEquals("bloop@bloop.com", building.getEmail());
    assertEquals("bloop123", building.getPassword());

    }

    //Private helper test function to initialize a Building instance
    private Building initialize(){
        return new Building("bloop","Bloop Building","1 Bloop Ave",
                "Bloop City", "WA", "90210","bloop@bloop.com","bloop123");

    }

    //  -----------  GETTER TESTS  ----------------  //

    @Test
    public void testGetUsername(){
        Building building = initialize();
        assertEquals("bloop", building.getUsername());
    }

    @Test
    public void testGetName(){
        Building building = initialize();
        assertEquals("Bloop Building", building.getName());
    }

    @Test
    public void testGetStreetAddress(){
        Building building = initialize();
        assertEquals("1 Bloop Ave", building.getStreetaddress());
    }

    @Test
    public void testGetCity(){
        Building building = initialize();
        assertEquals("Bloop City", building.getCity());
    }

    @Test
    public void testGetState(){
        Building building = initialize();
        assertEquals("WA", building.getState());
    }

    @Test
    public void testGetZip(){
        Building building = initialize();
        assertEquals("90210", building.getZip());
    }

    @Test
    public void testGetEmail(){
        Building building = initialize();
        assertEquals("bloop@bloop.com", building.getEmail());
    }

    @Test
    public void testGetPassword(){
        Building building = initialize();
        assertEquals("bloop123", building.getPassword());
    }

    //  -----------  SETTER TESTS  ----------------  //

    @Test
    public void testSetUsername(){
        Building building = initialize();
        building.setUsername("123");
        assertEquals("123", building.getUsername());
    }

    @Test
    public void testSetName(){
        Building building = initialize();
        building.setName("Bloopy");
        assertEquals("Bloopy", building.getName());
    }

    @Test
    public void testSetStreetAddress(){
        Building building = initialize();
        building.setStreetAdress("1 Sesame Street");
        assertEquals("1 Sesame Street", building.getStreetaddress());
    }

    @Test
    public void testSetCity(){
        Building building = initialize();
        building.setCity("Seattle");
        assertEquals("Seattle", building.getCity());
    }

    @Test
    public void testSetState(){
        Building building = initialize();
        building.setState("NY");
        assertEquals("NY", building.getState());
    }

    @Test
    public void testSetZip(){
        Building building = initialize();
        building.setZip("98109");
        assertEquals("98109", building.getZip());
    }

    @Test
    public void testSetEmail(){
        Building building = initialize();
        building.setEmail("bloopy@bloopy.com");
        assertEquals("bloopy@bloopy.com", building.getEmail());
    }

    @Test
    public void testSetPassword(){
        Building building = initialize();
        building.setPassword("1234");
        assertEquals("1234", building.getPassword());
    }

}//end of building test class
