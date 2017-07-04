package hu.voga.space.entity;




import hu.voga.space.enums.PlanetType;
import hu.voga.space.enums.RankType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(generator="system-uuid")
  @GenericGenerator(name="system-uuid", strategy = "uuid")
  @Column(name = "uuid")
  private String uuid;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Enumerated(EnumType.STRING)
  @Column(name = "rank")
  private RankType rank;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  private List<SolarSystem> solarSystems;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  private List<Discovered> discovered;


}
