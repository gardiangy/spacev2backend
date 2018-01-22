package hu.voga.space.dto;

import hu.voga.space.enums.ResearchType;
import hu.voga.space.enums.ShipType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BuildingItemDto {

    private ShipType shipType;
    private ResearchType researchType;
    private boolean available;

    public BuildingItemDto() {
    }
}
