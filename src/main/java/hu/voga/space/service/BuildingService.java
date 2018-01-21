package hu.voga.space.service;

import hu.voga.space.entity.Building;
import hu.voga.space.entity.Construction;
import hu.voga.space.entity.Planet;
import hu.voga.space.enums.BuildingBaseType;
import hu.voga.space.enums.ModifierRule;
import hu.voga.space.enums.ResourceType;
import hu.voga.space.repository.BuildingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

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
        building.setBldBaseType(construction.getCtBuildingType().getBaseType());
        for (ModifierRule modifierRule : construction.getCtBuildingType().getModifierRules()) {
            modifierService.save(modifierRule,construction.getPlanet().getSolarSystem());
        }
        return buildingRepository.save(building);
    }

    public Building upgradeBuilding(Construction construction){
        final Building building = construction.getBuilding();
        building.setBldLevel(building.getBldLevel() + 1);
        return buildingRepository.save(building);
    }

    public Building getOne(Long bldId) { return buildingRepository.getOne(bldId); }

    public Map<ResourceType, Integer> calculateUpgradeCost(Building building){
        Map<ResourceType, Integer> upgradeCost = new HashMap<>();
        double titaniumCost = building.getBldType().getTitaniumCost() * Math.pow(1.2, building.getBldLevel() + 1);
        upgradeCost.put(ResourceType.TITANIUM, (int) titaniumCost);
        double energyCost = building.getBldType().getEnergyCost() * Math.pow(1.2, building.getBldLevel() + 1);
        upgradeCost.put(ResourceType.ENERGY, (int) energyCost);
        double crewCost = building.getBldType().getCrewCost() * Math.pow(1.2, building.getBldLevel() + 1);
        upgradeCost.put(ResourceType.CREW, (int) crewCost);
        return upgradeCost;
    }

    public int calculateUpgradeTime(Building building){
       return (int) (building.getBldType().getBuildingTime() * Math.pow(1.1, building.getBldLevel() + 1));
    }
}
