package hu.voga.space.dto;

import hu.voga.space.enums.BuildingType;
import hu.voga.space.enums.ConstructionType;
import hu.voga.space.enums.ShipType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ConstructionDto {

    private Long id;
    private ConstructionType constructionType;
    private BuildingType buildingType;
    private Integer slot;
    private ShipType shipType;
    private Date start;
    private Date end;

    public ConstructionDto() {
    }
}
