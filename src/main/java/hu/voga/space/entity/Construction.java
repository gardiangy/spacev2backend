package hu.voga.space.entity;

import hu.voga.space.enums.BuildingType;
import hu.voga.space.enums.ConstructionType;
import hu.voga.space.enums.ShipType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lofut on 2017. 06. 29..
 */
@Entity
@Getter
@Setter
@Table(name = "construction")
public class Construction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ct_id")
    private Long ctId;

    @Enumerated(EnumType.STRING)
    @Column(name = "ct_type")
    private ConstructionType ctType;

    @Enumerated(EnumType.STRING)
    @Column(name = "ct_building_type")
    private BuildingType ctBuildingType;

    @Column(name = "ct_building_slot")
    private Integer ctBuildingSlot;

    @Enumerated(EnumType.STRING)
    @Column(name = "ct_ship_type")
    private ShipType ctShipType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ct_start")
    private Date ctStart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ct_end")
    private Date ctEnd;

    @ManyToOne
    @JoinColumn(name = "pl_id")
    private Planet planet;

    @ManyToOne
    @JoinColumn(name = "bld_id")
    private Building building;
}
