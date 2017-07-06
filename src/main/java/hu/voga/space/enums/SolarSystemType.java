package hu.voga.space.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by GGyuri on 2015.11.07..
 */

@AllArgsConstructor
@Getter
public enum SolarSystemType {

    YELLOW_DWARF ("YD", 0, 75, 60),
    RED_DWARF ("RD", 76, 80, 60),
    RED_GIANT ("RG", 81, 85, 120),
    BROWN_DWARF ("BD", 86, 91, 60),
    WHITE_DWARF ("WD", 92, 96, 60),
    BLUE_GIANT ("BG", 97, 98, 120),
    NEUTRON_STAR ("NS", 99, 100, 120);

    private String code;
    private Integer probabilityFrom;
    private Integer probabilityTo;
    private Integer radius;

}
