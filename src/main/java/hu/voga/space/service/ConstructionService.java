package hu.voga.space.service;

import hu.voga.space.entity.Construction;
import hu.voga.space.entity.Planet;
import hu.voga.space.entity.Resource;
import hu.voga.space.entity.SolarSystem;
import hu.voga.space.enums.BuildingType;
import hu.voga.space.enums.ConstructionType;
import hu.voga.space.enums.ErrorCode;
import hu.voga.space.enums.ResourceType;
import hu.voga.space.exception.SpaceException;
import hu.voga.space.repository.ConstructionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Implementation of the User Service.
 */
@Service
public class ConstructionService {

  private static final Logger logger = LoggerFactory.getLogger(ConstructionService.class);

  @Autowired
  private ConstructionRepository constructionRepository;

  @Autowired
  private PlanetService planetService;

  @Autowired
  private ResourceService resourceService;

  public Construction constructBuilding(BuildingType buildingType, Long planetId) throws SpaceException {
    Planet planet = planetService.getOne(planetId);
    resourceService.checkAndDeductResources(buildingType, planet.getSolarSystem());

    Construction construction = new Construction();
    construction.setCtType(ConstructionType.BUILDING);
    construction.setCtBuildingType(buildingType);
    construction.setCtStart(new Date());
    LocalDateTime start = LocalDateTime.now();
    construction.setCtEnd(Date.from(start.plusMinutes(1).atZone(ZoneId.systemDefault()).toInstant()));
    construction.setPlanet(planet);
    return constructionRepository.save(construction);
  }

  public List<Construction> getAllByPlanet(Long planetId) {
    Planet planet = planetService.getOne(planetId);
    return constructionRepository.findByPlanet(planet);
  }

}
