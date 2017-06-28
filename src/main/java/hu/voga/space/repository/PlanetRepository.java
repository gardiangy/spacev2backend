package hu.voga.space.repository;

import hu.voga.space.entity.Planet;
import hu.voga.space.entity.SolarSystem;
import hu.voga.space.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {
}
