package com.teamshort.rocks.YourPackageIsHere.payload;

import com.teamshort.rocks.YourPackageIsHere.model.Tenant;

import java.util.Set;

public class BuildingSummary {
    private long id;
    private String username;
    private String name;
    private String streetaddress;
    private String city;
    private String state;
    private String zip;
    private String email;
    private Set<Tenant> tenants;

    public BuildingSummary(Long id, String username, String name, String streetaddress, String city, String state, String zip, String email){
        this.id = id;
        this.username = username;
        this.name = name;
        this.streetaddress = streetaddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetaddress() {
        return streetaddress;
    }

    public void setStreetaddress(String streetAddress) {
        this.streetaddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
