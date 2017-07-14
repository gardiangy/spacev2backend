package hu.voga.space.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@AllArgsConstructor
@Getter
public enum BuildingType implements ConstructionEnum {

    SHIPYARD (360000L, "Shipyard", BuildingBaseType.MILITARY, 120, 200, 30, "This is a Shipyard", new ArrayList<>()),
    MINING_STATION (200000L, "Mining Station", BuildingBaseType.PRODUCER, 100, 150, 20, "This is a Mining Station", Arrays.asList(ModifierRule.MINE_RULE)),
    REFINERY (150000L, "Refinery", BuildingBaseType.UTILITY, 150, 100, 20, "This is a Refinery", new ArrayList<>()),
    COLONY (600000L, "Colony", BuildingBaseType.PRODUCER, 500, 400, 200, "This is a Colony", new ArrayList<>()),
    POWER_PLANT (300000L, "Power Plant", BuildingBaseType.PRODUCER, 250, 100, 30, "This is a Power Plant", new ArrayList<>()),
    ACADEMY (500000L, "Academy", BuildingBaseType.PRODUCER, 400, 200, 100, "This is a Academy", new ArrayList<>()),
    RESEARCH_LAB (500000L, "Research Lab", BuildingBaseType.RESEARCH, 300, 400, 50, "This is a Research Lab", new ArrayList<>()),
    RECRUITER (400000L, "Recruiter", BuildingBaseType.PRODUCER, 300, 300, 30, "This is a Recruiter", new ArrayList<>()),
    TRADING_STATION (500000L, "Trading Station", BuildingBaseType.UTILITY, 200, 200, 20, "This is a Trading Station", new ArrayList<>());

    @JsonProperty
    public String getValue() { return name(); }

    private Long buildingTime;
    private String name;
    private BuildingBaseType baseType;
    private Integer titaniumCost;
    private Integer energyCost;
    private Integer crewCost;
    private String  description;
    private List<ModifierRule> modifierRules;
}
