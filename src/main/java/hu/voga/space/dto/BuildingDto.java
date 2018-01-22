package hu.voga.space.dto;

import hu.voga.space.enums.BuildingBaseType;
import hu.voga.space.enums.BuildingType;
import hu.voga.space.enums.ResearchType;
import hu.voga.space.enums.ShipType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BuildingDto {

    private Long id;
    private BuildingType type;
    private Integer slot;
    private Integer level;
    private Integer upgradeTitaniumCost;
    private Integer upgradeCrewCost;
    private Integer upgradeEnergyCost;
    private Integer upgradeTime;
    private BuildingBaseType baseType;
    private List<BuildingItemDto> buildingItems;

    public BuildingDto() {
    }
}
