package hu.voga.space.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@AllArgsConstructor
@Getter
public enum ShipType implements ConstructionEnum {

    VIPER (360000L, "Viper", 20, 10, 30, "description TBD",ShipBaseType.MILITARY,ShipSubType.BATTLECRUISER, 1,1,1),
    FALCON (360000L, "Falcon", 40, 15, 70, "description TBD",ShipBaseType.MILITARY, ShipSubType.BATTLECRUISER, 2,2,2),
    AURORA (360000L, "Aurora", 20, 10, 30, "description TBD",ShipBaseType.MILITARY,ShipSubType.BATTLECRUISER, 1,1,1),

    DESTROYER_LEADER (360000L, "Destroyer leader", 20, 10, 30, "description TBD",ShipBaseType.MILITARY,ShipSubType.DESTROYER, 1,1,1),
    DESTROYER_ESCORT (360000L, "Destroyer escort", 20, 10, 30, "description TBD",ShipBaseType.MILITARY,ShipSubType.DESTROYER, 1,1,1),
    CENTURION (360000L, "Centurion", 20, 10, 30, "description TBD",ShipBaseType.MILITARY,ShipSubType.DESTROYER, 1,1,1),

    TITAN (360000L, "Titan", 20, 10, 30, "description TBD",ShipBaseType.MILITARY,ShipSubType.CAPITAL_SHIP, 1,1,1),
    THOR (360000L, "Thor", 20, 10, 30, "description TBD",ShipBaseType.MILITARY,ShipSubType.CAPITAL_SHIP, 1,1,1),

    VIKING (360000L, "Viking", 20, 10, 30, "description TBD",ShipBaseType.MILITARY,ShipSubType.BATTLESHIP, 1,1,1),
    BEHEMOTH (360000L, "Behemoth", 20, 10, 30, "description TBD",ShipBaseType.MILITARY,ShipSubType.BATTLESHIP, 1,1,1),
    ORION (360000L, "Orion", 20, 10, 30, "description TBD",ShipBaseType.MILITARY,ShipSubType.BATTLESHIP, 1,1,1),
    RAVAGER (360000L, "Ravager", 20, 10, 30, "description TBD",ShipBaseType.MILITARY,ShipSubType.BATTLESHIP, 1,1,1),
    RAVEN (360000L, "Raven", 20, 10, 30, "description TBD",ShipBaseType.MILITARY,ShipSubType.BATTLESHIP, 1,1,1),

    HELIOS (360000L, "Helios", 20, 10, 30, "description TBD",ShipBaseType.DEFENSE,ShipSubType.GUARDSHIP, 1,1,1),
    PHALANX (360000L, "Phalanx", 20, 10, 30, "description TBD",ShipBaseType.DEFENSE,ShipSubType.GUARDSHIP, 1,1,1),

    NIGHTFALL (360000L, "Nightfall", 20, 10, 30, "description TBD",ShipBaseType.INDUSTRIAL,ShipSubType.TRANSPORTER, 1,1,1),
    TERMITE (360000L, "Termite", 20, 10, 30, "description TBD",ShipBaseType.INDUSTRIAL,ShipSubType.MINER, 1,1,1),

    ARC_ROYAL (360000L, "Arc royal", 20, 10, 30, "description TBD",ShipBaseType.SPECIAL,ShipSubType.TERRAFORMER, 1,1,1),
    VOYAGER (360000L, "Voyager", 20, 10, 30, "description TBD",ShipBaseType.SPECIAL,ShipSubType.SCOUT, 1,1,1),
    CYCLONE (360000L, "Cyclone", 20, 10, 30, "description TBD",ShipBaseType.SPECIAL,ShipSubType.SCOUT, 1,1,1);

    @JsonProperty
    public String getKind() { return name(); }

    private Long buildingTime;
    private String name;
    private Integer titaniumCost;
    private Integer energyCost;
    private Integer crewCost;
    private String  description;
    private ShipBaseType baseType;
    private ShipSubType subType;

    private Integer attack;
    private Integer defense;
    private Integer speed;

}
