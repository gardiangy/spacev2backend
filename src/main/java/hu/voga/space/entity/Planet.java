package hu.voga.space.entity;

import hu.voga.space.enums.PlanetType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "planet")
public class Planet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pl_id")
  private Long plId;

  @Enumerated(EnumType.STRING)
  @Column(name = "pl_type")
  private PlanetType plType;

  @Column(name = "pl_size")
  private Integer plSize;

  @Column(name = "pl_slots")
  private Integer plSlots;

  @ManyToOne
  @JoinColumn(name = "ss_id")
  private SolarSystem solarSystem;

  @OneToMany(mappedBy = "planet", fetch = FetchType.LAZY)
  private List<Building> buildings;
}
