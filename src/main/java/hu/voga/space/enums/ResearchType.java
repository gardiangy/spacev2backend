package hu.voga.space.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@AllArgsConstructor
@Getter
public enum ResearchType implements ConstructionEnum {

    ADVANCED_MINING (360000L, "Advanced mining", BuildingType.RESEARCH_LAB, 120, 200, 30, "Mine titanium ore 1% faster",
            Collections.singletonList(ModifierRule.MINE_TITANIUM_1_PERCENT_FASTER)),
    ADVANCED_REFINING (200000L, "Advanced refining", BuildingType.RESEARCH_LAB, 100, 150, 20, "Refine titanium 1% faster",
            Collections.singletonList(ModifierRule.REFINE_TITANIUM_1_PERCENT_FASTER));

    @JsonProperty
    public String getValue() { return name(); }

    private Long buildingTime;
    private String name;
    private BuildingType buildingType;
    private Integer titaniumCost;
    private Integer energyCost;
    private Integer crewCost;
    private String  description;
    private List<ModifierRule> modifierRules;
}
