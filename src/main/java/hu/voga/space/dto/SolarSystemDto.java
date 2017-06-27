package hu.voga.space.dto;

import hu.voga.space.enums.SolarSystemType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolarSystemDto {

    private Long id;
    private String name;
    private Integer positionX;
    private Integer positionY;
    private SolarSystemType type;

    public SolarSystemDto() {
    }
}
