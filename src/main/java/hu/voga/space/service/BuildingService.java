package hu.voga.space.service;

import hu.voga.space.entity.Building;
import hu.voga.space.repository.BuildingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {

    private static final Logger logger = LoggerFactory.getLogger(SolarSystemService.class);

    @Autowired
    private BuildingRepository buildingRepository;

    public Building save(Building building) {
        return buildingRepository.save(building);
    }

}
