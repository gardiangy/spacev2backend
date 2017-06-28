package hu.voga.space.service;

import hu.voga.space.entity.Resource;
import hu.voga.space.entity.SolarSystem;
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
