package hu.voga.space.service;

import hu.voga.space.entity.Fleet;
import hu.voga.space.entity.Ship;
import hu.voga.space.entity.SolarSystem;
import hu.voga.space.entity.TradeOffer;
import hu.voga.space.enums.ResourceType;
import hu.voga.space.repository.FleetRepository;
import hu.voga.space.repository.ShipRepository;
import hu.voga.space.repository.TradeOfferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FleetService {

    private static final Logger logger = LoggerFactory.getLogger(FleetService.class);

    @Autowired
    private FleetRepository fleetRepository;

    @Autowired
    private ShipRepository shipRepository;

    public Fleet save(SolarSystem solarSystem, String fleetName){
        Fleet fleet = new Fleet();
        fleet.setSolarSystem(solarSystem);
        fleet.setFlName(fleetName);
        return fleetRepository.save(fleet);
    }

    public Fleet addShipsToFleet(Long flId, List<Ship> ships){
        Fleet fleet = fleetRepository.getOne(flId);
        for (Ship ship : ships) {
            ship.setFleet(fleet);
        }
        shipRepository.saveAll(ships);
        return fleet;
    }

    public List<Fleet> findFleetBySolarSystem(SolarSystem solarSystem){
        return fleetRepository.findBySolarSystem(solarSystem);
    }
}
