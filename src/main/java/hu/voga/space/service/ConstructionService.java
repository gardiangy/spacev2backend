package hu.voga.space.service;

import com.google.common.collect.ImmutableMap;
import hu.voga.space.dto.BuildingUpgradeDto;
import hu.voga.space.entity.*;
import hu.voga.space.enums.*;
import hu.voga.space.exception.SpaceException;
import hu.voga.space.handler.NotificationHandler;
import hu.voga.space.repository.ConstructionRepository;
import hu.voga.space.util.ConstructionScheduler;
import hu.voga.space.util.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
  private BuildingService buildingService;

  @Autowired
  private ShipService shipService;

  @Autowired
  private ConstructionScheduler constructionScheduler;

  @Autowired
  private NotificationHandler notificationHandler;

  @Autowired
  private ResourceService resourceService;

  @Transactional
  public Construction constructBuilding(BuildingType buildingType, Integer buildingSlot, Long planetId) throws SpaceException {
    Planet planet = planetService.getOne(planetId);
    return createConstruction(ConstructionType.BUILDING, buildingSlot, buildingType, planet);
  }

  @Transactional
  public Construction constructShip(ShipType shipType, Long planetId) throws SpaceException {
    Planet planet = planetService.getOne(planetId);
    return createConstruction(ConstructionType.SHIP, null, shipType, planet);
  }

  @Transactional
  public Construction upgradeBuilding(Building building) throws SpaceException {
    final BuildingUpgradeDto buildingUpgrade = BuildingUpgradeDto.builder()
            .building(building)
            .upgradeCost(buildingService.calculateUpgradeCost(building))
            .upgradeTime(buildingService.calculateUpgradeTime(building))
            .build();
    return createConstruction(ConstructionType.UPGRADE, building.getBldSlot(), buildingUpgrade, building.getPlanet());
  }

  private Construction createConstruction(ConstructionType constructionType, Integer buildingSlot, ConstructionEnum constructionEnum, Planet planet) throws SpaceException {
    resourceService.checkAndDeductResources(constructionEnum, planet.getSolarSystem());

    Construction construction = new Construction();
    construction.setCtType(constructionType);
    if(constructionEnum instanceof BuildingType){
      construction.setCtBuildingType((BuildingType) constructionEnum);
      construction.setCtBuildingSlot(buildingSlot);
    }
    if(constructionEnum instanceof ShipType){
      construction.setCtShipType((ShipType) constructionEnum);
    }
    construction.setCtStart(new Date());
    LocalDateTime start = LocalDateTime.now();
    construction.setCtEnd(Date.from(start.plusSeconds(60).atZone(ZoneId.systemDefault()).toInstant()));
    construction.setPlanet(planet);
    final Construction savedConstruction = constructionRepository.save(construction);
    constructionScheduler.scheduleConstruction(savedConstruction);
    return savedConstruction;
  }

  @Transactional
  public void build(Construction construction){
    long before = new Date().getTime();
    Long constructionId = construction.getCtId();
    switch (construction.getCtType()){
      case  BUILDING:
        buildingService.save(construction);
        break;
      case SHIP:
        shipService.save(construction);
        break;
      case  UPGRADE:
        buildingService.upgradeBuilding(construction);
        break;
    }

    constructionRepository.delete(construction);
    long elapsed = new Date().getTime() - before;
    logger.info("Construction finished in " + elapsed + " ms");

    Notification notification = Notification.builder()
            .notificationType(NotificationType.CONSTRUCTION_COMPLETE)
            .data(ImmutableMap.of("constructionId", constructionId.toString()))
            .build();
    notificationHandler.sendNotification(notification);
  }



  public List<Construction> getAllByPlanet(Long planetId) {
    Planet planet = planetService.getOne(planetId);
    return constructionRepository.findByPlanet(planet);
  }

}
