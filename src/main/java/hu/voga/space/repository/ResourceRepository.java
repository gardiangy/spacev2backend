package hu.voga.space.repository;

import hu.voga.space.entity.Resource;
import hu.voga.space.entity.SolarSystem;
import hu.voga.space.enums.ResourceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    List<Resource> findBySolarSystem(SolarSystem solarSystem);

    Resource findBySolarSystemAndRsType(SolarSystem  solarSystem, ResourceType resourceType);
}
