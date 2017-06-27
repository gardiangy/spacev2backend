package hu.voga.space.entity;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
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

  public Long getGridId() {
    return gridId;
  }

  public void setGridId(Long gridId) {
    this.gridId = gridId;
  }

  public Integer getGridX() {
    return gridX;
  }

  public void setGridX(Integer gridX) {
    this.gridX = gridX;
  }

  public Integer getGridY() {
    return gridY;
  }

  public void setGridY(Integer gridY) {
    this.gridY = gridY;
  }

  public SolarSystem getSolarSystem() {
    return solarSystem;
  }

  public void setSolarSystem(SolarSystem solarSystem) {
    this.solarSystem = solarSystem;
  }
}
