package hu.voga.space.repository;

import hu.voga.space.entity.Construction;
import hu.voga.space.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConstructionRepository extends JpaRepository<Construction, Long> {

    List<Construction> findByPlanet(Planet planet);

}
