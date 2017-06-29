package hu.voga.space.service;

import hu.voga.space.entity.Resource;
import hu.voga.space.entity.SolarSystem;
import hu.voga.space.enums.BuildingType;
import hu.voga.space.enums.ErrorCode;
import hu.voga.space.enums.ResourceType;
import hu.voga.space.exception.SpaceException;
import hu.voga.space.repository.ResourceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation of the Resource Service.
 */
@Service
public class ResourceService {

    private static final Logger logger = LoggerFactory.getLogger(ResourceService.class);


    @Autowired
    private ResourceRepository resourceRepository;

    public List<Resource> findResourcesBySystem(SolarSystem solarSystem) {
        return updateResourcesForSystem(solarSystem);
    }

    public void checkAndDeductResources(BuildingType buildingType, SolarSystem solarSystem) throws SpaceException {
        List<Resource> resources = findResourcesBySystem(solarSystem);
        Resource titaniumRes = resources.stream().filter(resource -> resource.getRsType().equals(ResourceType.TITANIUM)).findFirst().get();
        Resource energyRes = resources.stream().filter(resource -> resource.getRsType().equals(ResourceType.ENERGY)).findFirst().get();
        Resource crewRes = resources.stream().filter(resource -> resource.getRsType().equals(ResourceType.CREW)).findFirst().get();
        if(buildingType.getTitaniumCost() > titaniumRes.getRsAmount()){
            logger.warn("Not enough zenium");
            throw new SpaceException("Not enough titanium", ErrorCode.NOT_ENOUGH_TITANIUM);
        }
        if(buildingType.getEnergyCost() > energyRes.getRsAmount()){
            logger.warn("Not enough energy");
            throw new SpaceException("Not enough energy", ErrorCode.NOT_ENOUGH_ENERGY);
        }
        if(buildingType.getCrewCost() > crewRes.getRsAmount()){
            logger.warn("Not enough crew");
            throw new SpaceException("Not enough crew", ErrorCode.NOT_ENOUGH_CREW);
        }
        titaniumRes.setRsAmount(titaniumRes.getRsAmount() - buildingType.getTitaniumCost());
        energyRes.setRsAmount(energyRes.getRsAmount() - buildingType.getEnergyCost());
        crewRes.setRsAmount(crewRes.getRsAmount() - buildingType.getCrewCost());
    }


    public List<Resource> updateResourcesForSystem(SolarSystem solarSystem) {
        LocalDateTime now = LocalDateTime.now();
        Date oneSecBefore = Date.from(now.minusSeconds(1).atZone(ZoneId.systemDefault()).toInstant());
        List<Resource> resources = resourceRepository.findBySolarSystem(solarSystem);
        resources
                .stream()
                .filter(res -> res.getRsLastUpdated().before(oneSecBefore))
                .forEach(res -> {
                    LocalDateTime lastUpdatedTime = LocalDateTime.ofInstant(res.getRsLastUpdated().toInstant(), ZoneId.systemDefault());
                    long seconds = lastUpdatedTime.until(now, ChronoUnit.SECONDS);
                    int amountDiff = (int) Math.floor(seconds * res.getRsRate());
                    if (amountDiff > 0) {
                        res.setRsAmount(res.getRsAmount() + amountDiff);
                        res.setRsLastUpdated(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()));
                    }
        });

        return resourceRepository.saveAll(resources);
    }

}
