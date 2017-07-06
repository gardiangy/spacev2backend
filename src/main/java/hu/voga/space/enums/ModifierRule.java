package hu.voga.space.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ModifierRule {

    MINE_RULE(ModifierType.RESOURCE_RATE, ModifierCalcType.PERCENTAGE, ResourceType.TITANIUM,1d);

    private ModifierType modifierType;
    private ModifierCalcType modifierCalcType;
    private ResourceType resourceType;
    private Double value;
}