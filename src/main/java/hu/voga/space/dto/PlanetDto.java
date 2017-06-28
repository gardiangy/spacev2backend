package hu.voga.space.dto;

import hu.voga.space.enums.PlanetType;
import hu.voga.space.enums.SolarSystemType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanetDto {

    private Long id;
    private PlanetType planetType;
    private Integer size;

    public PlanetDto() {
    }
}
