package hu.voga.space.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@AllArgsConstructor
@Getter
public enum BuildingType implements ConstructionEnum {

    SHIPYARD (360000L, "Shipyard", 120, 200, 30, "This is a Shipyard"),
    MINING_STATION (200000L, "Mining Station", 100, 150, 20, "This is a Mining Station"),
    REFINERY (150000L, "Refinery", 150, 100, 20, "This is a Refinery"),
    COLONY (600000L, "Colony", 500, 400, 200, "This is a Colony"),
    POWER_PLANT (300000L, "Power Plant", 250, 100, 30, "This is a Power Plant"),
    ACADEMY (500000L, "Academy", 400, 200, 100, "This is a Academy"),
    RESEARCH_LAB (500000L, "Research Lab", 300, 400, 50, "This is a Research Lab"),
    RECRUITER (400000L, "Recruiter", 300, 300, 30, "This is a Recruiter"),
    TRADING_STATION (500000L, "Trading Station", 200, 200, 20, "This is a Trading Station");

    private Long buildingTime;
    private String name;
    private Integer titaniumCost;
    private Integer energyCost;
    private Integer crewCost;
    private String  description;
}
