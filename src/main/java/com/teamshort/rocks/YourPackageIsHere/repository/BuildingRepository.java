package com.teamshort.rocks.YourPackageIsHere.repository;

import com.teamshort.rocks.YourPackageIsHere.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

public interface BuildingRepository extends JpaRepository<Building, Long> {
    Optional<Building> findByEmail(String email);

    Optional<Building> findByUsernameOrEmail(String username, String email);

    List<Building> findByIdIn(List<Long> userIds);

    Optional<Building> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
