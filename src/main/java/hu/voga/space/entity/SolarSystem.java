package hu.voga.space.entity;


import hu.voga.space.enums.SolarSystemType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "solar_system")
public class SolarSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ss_id")
    private Long ssId;

    @Enumerated(EnumType.STRING)
    @Column(name = "ss_type")
    private SolarSystemType type;

    @Column(name = "ss_posx")
    private Integer positionX;

    @Column(name = "ss_posy")
    private Integer positionY;

    @Column(name = "ss_name")
    private String name;

    @Column(name = "ss_planetcount")
    private Integer planetCount;

    public Long getSsId() {
        return ssId;
    }

    public void setSsId(Long ssId) {
        this.ssId = ssId;
    }

    public SolarSystemType getType() {
        return type;
    }

    public void setType(SolarSystemType type) {
        this.type = type;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlanetCount() {
        return planetCount;
    }

    public void setPlanetCount(Integer planetCount) {
        this.planetCount = planetCount;
    }
}
