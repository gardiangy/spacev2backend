package hu.voga.space.dto.converter;

import hu.voga.space.dto.TradeOfferDto;
import hu.voga.space.entity.TradeOffer;
import org.springframework.stereotype.Component;

@Component
public  class TradeOfferConverter extends ModelDtoConverter<TradeOffer, TradeOfferDto> {

    @Override
    public TradeOfferDto convertToDto(TradeOffer entity) {
        return  modelMapper.map(entity, TradeOfferDto.class);
    }


    @Override
    public TradeOffer convertToEntity(TradeOfferDto DTO) {
        return modelMapper.map(DTO, TradeOffer.class);
    }
}