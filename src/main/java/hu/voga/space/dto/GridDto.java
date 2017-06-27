package hu.voga.space.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GridDto {

  private Long id;
  private Integer x;
  private Integer y;
  private SolarSystemDto solarSystem;

  public GridDto() {
  }
}
