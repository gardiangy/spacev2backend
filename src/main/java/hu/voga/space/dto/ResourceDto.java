package hu.voga.space.dto;

import hu.voga.space.enums.ResourceType;
import hu.voga.space.enums.SolarSystemType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceDto {

    private Long id;
    private String name;
    private Long amount;
    private Double rate;
    private ResourceType type;

    public ResourceDto() {
    }
}
