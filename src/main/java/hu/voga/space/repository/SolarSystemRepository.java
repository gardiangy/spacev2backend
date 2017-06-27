package hu.voga.space.repository;

import hu.voga.space.entity.SolarSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolarSystemRepository extends JpaRepository<SolarSystem, Long> {

}
