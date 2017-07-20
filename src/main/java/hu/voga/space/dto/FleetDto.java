package hu.voga.space.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FleetDto {

    private Long id;
    private String name;
    private List<ShipDto> ships;

    public FleetDto() {
    }
}
