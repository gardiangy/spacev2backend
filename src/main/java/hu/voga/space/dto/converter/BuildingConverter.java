package hu.voga.space.dto.converter;


import hu.voga.space.dto.BuildingDto;
import hu.voga.space.dto.BuildingItemDto;
import hu.voga.space.dto.PlanetDto;
import hu.voga.space.entity.Building;
import hu.voga.space.entity.Planet;
import hu.voga.space.enums.ResearchType;
import hu.voga.space.enums.ResourceType;
import hu.voga.space.enums.ShipType;
import hu.voga.space.service.BuildingService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public  class BuildingConverter extends ModelDtoConverter<Building, BuildingDto> {

    @Autowired
    private BuildingService buildingService;

    @Override
    public BuildingDto convertToDto(Building entity) {
        BuildingDto dto = modelMapper.map(entity, BuildingDto.class);
        Map<ResourceType, Integer> upgradeCost = buildingService.calculateUpgradeCost(entity);
        dto.setUpgradeTitaniumCost(upgradeCost.get(ResourceType.TITANIUM));
        dto.setUpgradeEnergyCost(upgradeCost.get(ResourceType.ENERGY));
        dto.setUpgradeCrewCost(upgradeCost.get(ResourceType.CREW));
        dto.setUpgradeTime(buildingService.calculateUpgradeTime(entity));
        dto.setBuildingItems(setBuildingItems(entity));
        return dto;
    }

    private List<BuildingItemDto> setBuildingItems(Building building){
        List<BuildingItemDto> buildingItems = new ArrayList<>();
        for (ShipType shipType : ShipType.values()) {
            if(shipType.getBuildingType().equals(building.getBldType())){
                buildingItems.add(BuildingItemDto.builder()
                        .shipType(shipType)
                        .available(true).build());
            }
        }
        for (ResearchType researchType : ResearchType.values()) {
            if(researchType.getBuildingType().equals(building.getBldType())){
                buildingItems.add(BuildingItemDto.builder()
                        .researchType(researchType)
                        .available(true).build());
            }
        }
        return buildingItems;
    }

    @Override
    public Building convertToEntity(BuildingDto DTO) {
        return modelMapper.map(DTO, Building.class);
    }
}