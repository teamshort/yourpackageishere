package com.teamshort.rocks.YourPackageIsHere.model;

import org.springframework.security.core.GrantedAuthority;
import com.teamshort.rocks.YourPackageIsHere.model.audit.DateAudit;
import javax.persistence.*;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Set;

import org.hibernate.annotations.NaturalId;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;

@Entity
@Table(name = "building", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class Building extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique=true)
    @NotBlank
    @Size(max = 15)
    String username;

    @NotBlank
    @Size(max = 40)
    String name;

    @NotBlank
    @Size(max = 40)
    String streetaddress;

    @NotBlank
    @Size(max = 40)
    String city;

    @NotBlank
    @Size(max = 40)
    String state;

    @NotBlank
    @Size(max = 10)
    String zip;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    String email;

    @NotBlank
    @Size(max = 100)
    String password;

    @OneToMany(mappedBy = "building")
    Set<Tenant> tenants;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "building_roles",
            joinColumns = @JoinColumn(name = "building_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Building(){}

    public Building(String username, String name, String streetaddress, String city, String state, String zip, String email, String password){
        this.username = username;
        this.name = name;
        this.streetaddress = streetaddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
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

    public void setStreetAdress(String streetaddress) {
        this.streetaddress = streetaddress;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Tenant> getTenants() {
        return tenants;
    }

    public void setTenants(Set<Tenant> tenants) {
        this.tenants = tenants;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
