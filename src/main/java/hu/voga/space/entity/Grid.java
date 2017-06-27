package hu.voga.space.entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "grid")
public class Grid {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "grid_id")
  private Long gridId;

  @Column(name = "grid_x")
  private Integer gridX;

  @Column(name = "grid_y")
  private Integer gridY;

  @OneToOne(cascade = CascadeType.ALL)
  @Fetch(FetchMode.JOIN)
  @JoinColumn(name = "ss_id")
  private SolarSystem solarSystem;
}
