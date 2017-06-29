package hu.voga.space.dto;

import hu.voga.space.enums.BuildingType;
import hu.voga.space.enums.ConstructionType;
import hu.voga.space.enums.PlanetType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ConstructionDto {

    private Long id;
    private ConstructionType constructionType;
    private BuildingType buildingType;
    private Date start;
    private Date end;

    public ConstructionDto() {
    }
}
