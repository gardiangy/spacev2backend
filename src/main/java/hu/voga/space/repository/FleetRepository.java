package hu.voga.space.repository;

import hu.voga.space.entity.Fleet;
import hu.voga.space.entity.Ship;
import hu.voga.space.entity.SolarSystem;
import hu.voga.space.enums.ShipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FleetRepository extends JpaRepository<Fleet, Long> {

    List<Fleet> findBySolarSystem(SolarSystem solarSystem);
}
