package hu.voga.space.dto;

import hu.voga.space.enums.PlanetType;
import hu.voga.space.enums.SolarSystemType;
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

    public PlanetDto() {
    }
}
