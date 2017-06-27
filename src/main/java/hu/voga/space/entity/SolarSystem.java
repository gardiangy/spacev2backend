package hu.voga.space.entity;


import hu.voga.space.enums.SolarSystemType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_guid", nullable = true)
    private User user;
}
