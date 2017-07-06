package hu.voga.space.service;

import hu.voga.space.entity.Building;
import hu.voga.space.entity.Construction;
import hu.voga.space.enums.ModifierRule;
import hu.voga.space.repository.BuildingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BuildingService {

    private static final Logger logger = LoggerFactory.getLogger(BuildingService.class);

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private ModifierService modifierService;

    @Transactional
    public Building save(Construction construction) {
        Building building = new Building();
        building.setBldType(construction.getCtBuildingType());
        building.setPlanet(construction.getPlanet());
        building.setBldSlot(construction.getCtBuildingSlot());
        for (ModifierRule modifierRule : construction.getCtBuildingType().getModifierRules()) {
            modifierService.save(modifierRule,construction.getPlanet().getSolarSystem());
        }
        return buildingRepository.save(building);
    }

}
