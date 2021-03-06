package hu.voga.space.entity;

import hu.voga.space.enums.BuildingBaseType;
import hu.voga.space.enums.BuildingType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by lofut on 2017. 06. 29..
 */
@Entity
@Getter
@Setter
@Table(name = "building")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bld_id")
    private Long bldId;

    @Enumerated(EnumType.STRING)
    @Column(name = "bld_type")
    private BuildingType bldType;

    @Enumerated(EnumType.STRING)
    @Column(name = "bld_base_type")
    private BuildingBaseType bldBaseType;

    @Column(name = "bld_slot")
    private Integer bldSlot;

    @Column(name = "bld_level")
    private Integer bldLevel;

    @ManyToOne
    @JoinColumn(name = "pl_id")
    private Planet planet;
}
