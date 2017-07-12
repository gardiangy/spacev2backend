package hu.voga.space.dto;

import hu.voga.space.enums.ResourceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TradeOfferDto {

    private Long id;
    private ResourceType fromType;
    private Long fromValue;
    private ResourceType toType;
    private Long toValue;
    private Long solarSystemId;

    public TradeOfferDto() {
    }
}
