package com.teamshort.rocks.YourPackageIsHere;

import org.springframework.data.repository.CrudRepository;

public interface TenantRepository extends CrudRepository<Tenant, Long> {
}
