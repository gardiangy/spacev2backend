package hu.voga.space.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ModifierRule {

    MINE_TITANIUM_1_PERCENT_FASTER(ModifierType.RESOURCE_RATE, ModifierCalcType.PERCENTAGE, ResourceType.TITANIUM,0.01d),
    REFINE_TITANIUM_1_PERCENT_FASTER(ModifierType.RESOURCE_RATE, ModifierCalcType.PERCENTAGE, ResourceType.TITANIUM,0.01d);

    private ModifierType modifierType;
    private ModifierCalcType modifierCalcType;
    private ResourceType resourceType;
    private Double value;
}