package hu.voga.space.entity;

import hu.voga.space.enums.BuildingType;
import hu.voga.space.enums.ShipType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "ship")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ship_id")
    private Long shipId;

    @Enumerated(EnumType.STRING)
    @Column(name = "ship_type")
    private ShipType shipType;

    @Column(name = "ship_attack")
    private Integer shipAttack;

    @Column(name = "ship_defense")
    private Integer shipDefense;

    @Column(name = "ship_speed")
    private Integer shipSpeed;

    @Column(name = "ship_rank")
    private Integer shipRank;

    @Column(name = "ship_count")
    private Long shipCount;

    @ManyToOne
    @JoinColumn(name = "ss_id")
    private SolarSystem solarSystem;
}
