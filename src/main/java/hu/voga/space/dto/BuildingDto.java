package hu.voga.space.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildingDto {

    private Long id;
    private String planetType;

    public BuildingDto() {
    }
}
