package hu.voga.space.dto;

import hu.voga.space.enums.BuildingBaseType;
import hu.voga.space.enums.BuildingType;
import lombok.Getter;
import lombok.Setter;

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
    private BuildingBaseType baseType;

    public BuildingDto() {
    }
}
