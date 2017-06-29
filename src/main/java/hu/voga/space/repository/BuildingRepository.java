package hu.voga.space.repository;

import hu.voga.space.entity.Building;
import hu.voga.space.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
}
