package com.teamshort.rocks.YourPackageIsHere.model;


import com.teamshort.rocks.YourPackageIsHere.model.Building;

import javax.persistence.*;

@Entity
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String firstname;
    String lastname;
    String email;
    String aptnum;
    String phonenum;

    @ManyToOne
    Building building;

    public Tenant(){}

    public Tenant(String firstname, String lastname, String email, String aptnum, String phonenum, Building building){
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

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
