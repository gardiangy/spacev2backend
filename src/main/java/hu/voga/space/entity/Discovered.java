package hu.voga.space.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "discovered")
public class Discovered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disc_id")
    private Long discId;

    @Column(name = "disc_date")
    private Date discDate;

    @ManyToOne
    @JoinColumn(name = "ss_id")
    private SolarSystem solarSystem;

    @ManyToOne
    @JoinColumn(name = "u_uuid")
    private User user;

}
