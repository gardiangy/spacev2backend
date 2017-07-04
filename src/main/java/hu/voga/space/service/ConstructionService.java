package hu.voga.space.service;

import com.google.common.collect.ImmutableMap;
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
import java.util.HashMap;
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
  private ConstructionScheduler constructionScheduler;

  @Autowired
  private NotificationHandler notificationHandler;

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
    construction.setCtEnd(Date.from(start.plusSeconds(120).atZone(ZoneId.systemDefault()).toInstant()));
    construction.setPlanet(planet);
    final Construction savedConstruction = constructionRepository.save(construction);
    constructionScheduler.scheduleConstruction(savedConstruction);
    return savedConstruction;
  }

  @Transactional
  public void build(Construction construction){
    long before = new Date().getTime();
    Long constructionId = construction.getCtId();
    Building building = new Building();
    building.setBldType(construction.getCtBuildingType());
    building.setPlanet(construction.getPlanet());
    buildingService.save(building);
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
