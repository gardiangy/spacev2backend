package hu.voga.space.entity;

import hu.voga.space.enums.ResourceType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "trade_offer")
public class TradeOffer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "tro_id")
  private Long troId;

  @Enumerated(EnumType.STRING)
  @Column(name = "tro_from_type")
  private ResourceType troFromType;

  @Column(name = "tro_from_value")
  private Long troFromValue;

  @Enumerated(EnumType.STRING)
  @Column(name = "tro_to_type")
  private ResourceType troToType;

  @Column(name = "tro_to_value")
  private Long troToValue;

  @ManyToOne
  @JoinColumn(name = "ss_id")
  private SolarSystem solarSystem;
}
