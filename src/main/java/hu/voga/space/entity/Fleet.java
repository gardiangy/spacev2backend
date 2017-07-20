package hu.voga.space.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "fleet")
public class Fleet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fl_id")
    private Long flId;

    @Column(name = "fl_name")
    private String flName;

    @Column(name = "fl_speed")
    private Double flSpeed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ss_id")
    private SolarSystem solarSystem;

    @OneToMany(mappedBy = "fleet", fetch = FetchType.LAZY)
    private List<Ship> ships;
}
