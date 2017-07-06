package hu.voga.space.entity;

import hu.voga.space.enums.ModifierCalcType;
import hu.voga.space.enums.ModifierType;
import hu.voga.space.enums.ResourceType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "modifier")
public class Modifier {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "mod_id")
  private Long modId;

  @Enumerated(EnumType.STRING)
  @Column(name = "mod_type")
  private ModifierType modType;

  @Enumerated(EnumType.STRING)
  @Column(name = "mod_calc_type")
  private ModifierCalcType modCalcType;

  @Enumerated(EnumType.STRING)
  @Column(name = "mod_resource_type")
  private ResourceType resourceType;

  @Column(name = "mod_value")
  private Double modValue;

  @ManyToOne
  @JoinColumn(name = "ss_id")
  private SolarSystem solarSystem;
}
