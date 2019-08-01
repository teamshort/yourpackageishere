package com.teamshort.rocks.YourPackageIsHere.controller;

import com.teamshort.rocks.YourPackageIsHere.exception.AppException;
import com.teamshort.rocks.YourPackageIsHere.model.Role;
import com.teamshort.rocks.YourPackageIsHere.model.RoleName;
import com.teamshort.rocks.YourPackageIsHere.model.Tenant;
import com.teamshort.rocks.YourPackageIsHere.payload.*;
import com.teamshort.rocks.YourPackageIsHere.repository.BuildingRepository;
import com.teamshort.rocks.YourPackageIsHere.model.Building;
import com.teamshort.rocks.YourPackageIsHere.repository.TenantRepository;
import com.teamshort.rocks.YourPackageIsHere.security.BuildingPrincipal;
import com.teamshort.rocks.YourPackageIsHere.security.CurrentBuilding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.net.URI;
import java.security.Principal;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class TenantController {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private TenantRepository tenantRepository;

    private static final Logger logger = LoggerFactory.getLogger(BuildingController.class);

    @PostMapping("/tenant/add")
    public ResponseEntity<?> addTenant(@CurrentBuilding BuildingPrincipal currentBuilding, @Valid @RequestBody NewTenantRequest newTenantRequest) {
        Optional<Building> building = buildingRepository.findByUsername(currentBuilding.getUsername());
        // Creating tenant's account
        Tenant tenant = new Tenant(newTenantRequest.getFirstname(), newTenantRequest.getLastname(), newTenantRequest.getEmail(), newTenantRequest.getAptnum(), newTenantRequest.getPhonenum(), building.get());
        // Save new tenant to the repository
        Tenant result = tenantRepository.save(tenant);

//        URI location = ServletUriComponentsBuilder
//                .fromCurrentContextPath().path("/api/users/{tenant}")
//                .buildAndExpand(result.).toUri();

        return ResponseEntity.ok(new ApiResponse(true, "Tenant registered successfully"));
    }

    @GetMapping("/tenant/all")
    public Set<?> getAllTenants(@CurrentBuilding BuildingPrincipal currentBuilding) {
        // Get the current building from the repo
        Optional<Building> building = buildingRepository.findByUsername(currentBuilding.getUsername());

        // Create payload for response
        Set<TenantResponse> tenantResponse = new HashSet<>();

        // Loop through and content Tenant models to Payload TenantResponses
        for(Tenant tenant : building.get().getTenants()){
            tenantResponse.add(new TenantResponse(tenant.getId(), tenant.getFirstname(), tenant.getLastname(), tenant.getEmail(), tenant.getAptnum(), tenant.getPhonenum(), tenant.getBuilding().getName()));
        }
        // Return the set of tenants (all tenants)
        return tenantResponse;
    }

    @GetMapping("/tenant/{id}")
    public ResponseEntity<?> getTenant(@CurrentBuilding BuildingPrincipal currentBuilding, @PathVariable(value = "id") String id) {
        // Get id
        long ID = Long.parseLong(id);
        // Find tenant by ID
        Tenant tenant = tenantRepository.findById(ID);
        if(tenant.getBuilding() != buildingRepository.findByUsername(currentBuilding.getUsername()).get()){
            return ResponseEntity.badRequest().body(new ApiResponse(false, "You don't have permissions to view this tenant"));
        }
        // Return tenant response payload
        return ResponseEntity.ok(new TenantResponse(tenant.getId(), tenant.getFirstname(), tenant.getLastname(), tenant.getEmail(), tenant.getAptnum(), tenant.getPhonenum(), tenant.getBuilding().getName()));
    }

    @PutMapping("/tenant/edit")
    public ResponseEntity<?> editTenant(@CurrentBuilding BuildingPrincipal currentBuilding, @Valid @RequestBody NewTenantRequest newTenantRequest, @PathVariable(value = "id") String id) {
        // Get id
        long ID = Long.parseLong(id);
        // Get tenant and update information
        Tenant tenant = tenantRepository.findById(ID);
        if(tenant.getBuilding() != buildingRepository.findByUsername(currentBuilding.getUsername()).get()){
            return ResponseEntity.badRequest().body(new ApiResponse(false, "You don't have permissions to delete this tenant"));
        }else{
            tenant.setFirstname(newTenantRequest.getFirstname());
            tenant.setLastname(newTenantRequest.getLastname());
            tenant.setEmail(newTenantRequest.getEmail());
            tenant.setAptnum(newTenantRequest.getAptnum());
            tenant.setPhonenum(newTenantRequest.getPhonenum());
            // Resave (update) the tenant
            tenantRepository.save(tenant);
            // Return response
            return ResponseEntity.ok(new ApiResponse(true, "User was successfully deleted"));
        }
    }

    @DeleteMapping("/tenant/{id}/delete")
    public ResponseEntity<?>  deleteTenant(@CurrentBuilding BuildingPrincipal currentBuilding, @PathVariable(value = "id") String id) {
        // Get id
        long ID = Long.parseLong(id);
        // Get building from repo
        Tenant tenant = tenantRepository.findById(ID);
        // Check to make sure that this is a valid person
        if(tenant.getBuilding() != buildingRepository.findByUsername(currentBuilding.getUsername()).get()){
            return ResponseEntity.badRequest().body(new ApiResponse(false, "You don't have permissions to delete this tenant"));
        }else{
            // Delete said tenant
            tenantRepository.delete(tenant);
            // Return response
            return ResponseEntity.ok(new ApiResponse(true, "User was successfully deleted"));
        }
    }

}
