package hu.voga.space.dto.converter;


import hu.voga.space.dto.BuildingDto;
import hu.voga.space.dto.PlanetDto;
import hu.voga.space.entity.Building;
import hu.voga.space.entity.Planet;
import hu.voga.space.enums.ResourceType;
import hu.voga.space.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        return dto;
    }

    @Override
    public Building convertToEntity(BuildingDto DTO) {
        return modelMapper.map(DTO, Building.class);
    }
}