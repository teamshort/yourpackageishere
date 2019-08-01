package com.teamshort.rocks.YourPackageIsHere.payload;

public class TenantResponse {
    long id;
    String firstname;
    String lastname;
    String email;
    String aptnum;
    String phonenum;
    String building;

    public TenantResponse(){}

    public TenantResponse(long id, String firstname, String lastname, String email, String aptnum, String phonenum, String building){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.aptnum = aptnum;
        this.phonenum = phonenum;
        this.building = building;
    }

    public long getId() {
        return id;
    }

    public void setId(long id){ this.id = id; }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAptnum() {
        return aptnum;
    }

    public void setAptnum(String aptnum) {
        this.aptnum = aptnum;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }
}
