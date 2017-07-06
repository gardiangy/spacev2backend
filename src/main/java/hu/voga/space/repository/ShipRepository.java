package hu.voga.space.repository;

import hu.voga.space.entity.Ship;
import hu.voga.space.entity.SolarSystem;
import hu.voga.space.enums.ShipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    List<Ship> findBySolarSystem(SolarSystem solarSystem);

    Optional<Ship> findBySolarSystemAndShipType(SolarSystem solarSystem, ShipType shipType);
}
