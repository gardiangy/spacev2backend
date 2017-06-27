package hu.voga.space.entity;

import hu.voga.space.enums.ResourceType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "resource")
public class Resource {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "rs_id")
  private Long rsId;

  @Enumerated(EnumType.STRING)
  @Column(name = "rs_type")
  private ResourceType rsType;

  @Column(name = "rs_rate")
  private Double rsRate;

  @Column(name = "rs_amount")
  private Long rsAmount;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "rs_last_updated")
  private Date rsLastUpdated;

  @ManyToOne
  @JoinColumn(name = "ss_id")
  private SolarSystem solarSystem;
}
