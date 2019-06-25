package com.teamshort.rocks.YourPackageIsHere;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TenantRepository extends CrudRepository<Tenant, Long> {
    List<Tenant> findByFirstnameIgnoreCaseContainingAndLastnameIgnoreCaseContaining(String firstname, String lastname);
    List<Tenant> findByAptnumIgnoreCaseContaining(String aptnum);
    Tenant findById(long id);
    Tenant findByEmail(String email);
}
