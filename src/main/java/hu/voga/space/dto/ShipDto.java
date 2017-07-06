package hu.voga.space.dto;

import hu.voga.space.enums.ShipType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShipDto {

    private Long id;
    private ShipType shipType;

    public ShipDto() {
    }
}
