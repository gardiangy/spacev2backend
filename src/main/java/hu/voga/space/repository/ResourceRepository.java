package hu.voga.space.repository;

import hu.voga.space.entity.Resource;
import hu.voga.space.entity.SolarSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    List<Resource> findBySolarSystem(SolarSystem solarSystem);
}
