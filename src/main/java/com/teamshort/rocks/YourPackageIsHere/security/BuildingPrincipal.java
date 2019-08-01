package com.teamshort.rocks.YourPackageIsHere.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamshort.rocks.YourPackageIsHere.model.Building;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BuildingPrincipal implements UserDetails {
    private Long id;
    private String username;

    private String name;
    private String streetaddress;
    private String city;
    private String state;
    private String zip;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public BuildingPrincipal(Long id, String name, String username, String streetaddress, String city, String state, String zip, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.streetaddress = streetaddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static BuildingPrincipal create(Building building) {
        List<GrantedAuthority> authorities = building.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());

        return new BuildingPrincipal(
                building.getId(),
                building.getName(),
                building.getUsername(),
                building.getStreetaddress(),
                building.getCity(),
                building.getState(),
                building.getZip(),
                building.getEmail(),
                building.getPassword(),
                authorities
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getStreetaddress(){
        return streetaddress;
    }

    public String getCity(){
        return city;
    }

    public String getState(){
        return state;
    }

    public String getZip(){
        return zip;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuildingPrincipal that = (BuildingPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
