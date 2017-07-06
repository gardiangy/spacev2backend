package hu.voga.space.dto.converter;


import hu.voga.space.dto.ShipDto;
import hu.voga.space.entity.Ship;
import org.springframework.stereotype.Component;

@Component
public  class ShipConverter extends ModelDtoConverter<Ship, ShipDto> {

    @Override
    public ShipDto convertToDto(Ship entity) {
        return modelMapper.map(entity, ShipDto.class);
    }

    @Override
    public Ship convertToEntity(ShipDto DTO) {
        return modelMapper.map(DTO, Ship.class);
    }
}