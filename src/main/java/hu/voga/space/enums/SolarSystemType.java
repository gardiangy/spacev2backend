package hu.voga.space.enums;

/**
 * Created by GGyuri on 2015.11.07..
 */
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

    SolarSystemType(String code, Integer probabilityFrom, Integer probabilityTo, Integer radius) {
        this.code = code;
        this.probabilityFrom = probabilityFrom;
        this.probabilityTo = probabilityTo;
        this.radius = radius;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getProbabilityFrom() {
        return probabilityFrom;
    }

    public void setProbabilityFrom(Integer probabilityFrom) {
        this.probabilityFrom = probabilityFrom;
    }

    public Integer getProbabilityTo() {
        return probabilityTo;
    }

    public void setProbabilityTo(Integer probabilityTo) {
        this.probabilityTo = probabilityTo;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }
}
