package com.teamshort.rocks.YourPackageIsHere;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TenantRepository extends CrudRepository<Tenant, Long> {
    List<Tenant> findByFirstnameIgnoreCaseAndLastnameIgnoreCaseAndBuildingId(String firstname, String lastname, long id);
    List<Tenant> findByAptnumIgnoreCaseAndBuildingId(String aptnum, long id);
    Tenant findById(long id);
    List<Tenant> findByEmail(String email);
    List<Tenant> findByBuilding(Building building);
}
