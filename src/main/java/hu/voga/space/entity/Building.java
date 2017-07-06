package hu.voga.space.entity;

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

    @Column(name = "bld_slot")
    private Integer bldSlot;

    @ManyToOne
    @JoinColumn(name = "pl_id")
    private Planet planet;
}
