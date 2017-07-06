package hu.voga.space.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@AllArgsConstructor
@Getter
public enum ShipType implements ConstructionEnum {

    SMALL_SHIP (360000L, "Small ship", 20, 10, 30, "This is a small ship", 1,1,1),
    MEDIUM_SHIP (360000L, "Medium ship", 40, 15, 70, "This is a medium ship",2,2,2);

    private Long buildingTime;
    private String name;
    private Integer titaniumCost;
    private Integer energyCost;
    private Integer crewCost;
    private String  description;

    private Integer attack;
    private Integer defense;
    private Integer speed;

}
