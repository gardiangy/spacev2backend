package hu.voga.space.dto;

import hu.voga.space.enums.PlanetType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlanetDto {

    private Long id;
    private PlanetType planetType;
    private Integer size;
    private Integer slots;
    private List<BuildingDto> buildings;
    private List<ConstructionDto> constructions;

    public PlanetDto() {
    }
}
