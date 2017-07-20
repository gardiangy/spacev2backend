package hu.voga.space.dto.converter;


import hu.voga.space.dto.FleetDto;
import hu.voga.space.dto.ShipDto;
import hu.voga.space.entity.Fleet;
import hu.voga.space.entity.Ship;
import org.springframework.stereotype.Component;

@Component
public  class FleetConverter extends ModelDtoConverter<Fleet, FleetDto> {

    @Override
    public FleetDto convertToDto(Fleet entity) {
        return modelMapper.map(entity, FleetDto.class);
    }

    @Override
    public Fleet convertToEntity(FleetDto DTO) {
        return modelMapper.map(DTO, Fleet.class);
    }
}