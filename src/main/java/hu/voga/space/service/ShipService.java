package hu.voga.space.service;

import hu.voga.space.entity.Construction;
import hu.voga.space.entity.Ship;
import hu.voga.space.entity.SolarSystem;
import hu.voga.space.enums.ShipType;
import hu.voga.space.repository.ResourceRepository;
import hu.voga.space.repository.ShipRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipService {

    private static final Logger logger = LoggerFactory.getLogger(ShipService.class);

    @Autowired
    private ShipRepository shipRepository;

    public Ship save(Construction construction) {
        final ShipType shipType = construction.getCtShipType();
        final SolarSystem solarSystem = construction.getPlanet().getSolarSystem();
        Ship ship;

        //ha már létezik ilyen típusú hajó a rendszerben növeljük az értéket 1 -el
        final Optional<Ship> shipTypeOptional = shipRepository.findBySolarSystemAndShipType(solarSystem, shipType);
        if(shipTypeOptional.isPresent()){
            ship = shipTypeOptional.get();
            ship.setShipCount(ship.getShipCount() + 1);
        } else {
            ship = new Ship();
            ship.setShipCount(1L);
            ship.setShipRank(1);
            ship.setShipType(shipType);
            ship.setSolarSystem(solarSystem);
            ship.setShipAttack(shipType.getAttack());
            ship.setShipDefense(shipType.getDefense());
            ship.setShipSpeed(shipType.getSpeed());
        }

        return shipRepository.save(ship);
    }

    public List<Ship> findShipBySystem(SolarSystem solarSystem) {
        return shipRepository.findBySolarSystem(solarSystem);
    }

    public Ship getOne(Long shipId){
        return shipRepository.getOne(shipId);
    }

}
