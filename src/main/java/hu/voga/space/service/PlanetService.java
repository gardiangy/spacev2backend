package hu.voga.space.service;

import hu.voga.space.entity.Planet;
import hu.voga.space.repository.PlanetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lofut on 2017. 06. 29..
 */

@Service
public class PlanetService {

    private static final Logger logger = LoggerFactory.getLogger(SolarSystemService.class);

    @Autowired
    private PlanetRepository planetRepository;

    public Planet getOne(Long planetId) { return planetRepository.getOne(planetId); }

    public Planet save(Planet planet) {
        return planetRepository.save(planet);
    }

}
