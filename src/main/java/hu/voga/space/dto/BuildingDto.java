package hu.voga.space.dto;

import hu.voga.space.entity.Building;
import hu.voga.space.enums.PlanetType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BuildingDto {

    private Long id;
    private String planetType;
    private List<BuildingDto> buildings;

    public BuildingDto() {
    }
}
