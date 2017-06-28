package hu.voga.space.service;

import hu.voga.space.entity.Discovered;
import hu.voga.space.entity.SolarSystem;
import hu.voga.space.entity.User;
import hu.voga.space.repository.DiscoveredRepository;
import hu.voga.space.repository.SolarSystemRepository;
import hu.voga.space.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the SolarSystem Service.
 */
@Service
public class SolarSystemService {

    private static final Logger logger = LoggerFactory.getLogger(SolarSystemService.class);

    @Autowired
    private DiscoveredRepository discoveredRepository;

    @Autowired
    private SolarSystemRepository solarSystemRepository;

    @Autowired
    private UserRepository userRepository;


    public SolarSystem getOne(Long ssId){
        return solarSystemRepository.getOne(ssId);
    }

    public List<SolarSystem> findDiscoveredSystemForUser(String userGuid) {
        final User user = userRepository.getOne(userGuid);
        return discoveredRepository.findByUser(user)
                .stream()
                .map(Discovered::getSolarSystem)
                .collect(Collectors.toList());
    }

}
