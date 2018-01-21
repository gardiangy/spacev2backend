package hu.voga.space.dto;


import hu.voga.space.entity.Building;
import hu.voga.space.enums.ConstructionEnum;
import hu.voga.space.enums.ResourceType;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Map;

@AllArgsConstructor
@Builder
public class BuildingUpgradeDto implements ConstructionEnum {

    private Building building;
    private Map<ResourceType, Integer> upgradeCost;
    private long upgradeTime;


    @Override
    public Long getBuildingTime() {
        return upgradeTime;
    }

    @Override
    public String getName() {
        return building.getBldType().getName();
    }

    @Override
    public Integer getTitaniumCost() {
        return upgradeCost.get(ResourceType.TITANIUM);
    }

    @Override
    public Integer getEnergyCost() {
        return upgradeCost.get(ResourceType.ENERGY);
    }

    @Override
    public Integer getCrewCost() {
        return upgradeCost.get(ResourceType.CREW);
    }

    @Override
    public String getDescription() {
        return null;
    }
}
