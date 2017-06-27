package hu.voga.space.dto.converter;


import hu.voga.space.dto.SolarSystemDto;
import hu.voga.space.entity.SolarSystem;
import org.springframework.stereotype.Component;

@Component
public  class SolarSystemConverter extends ModelDtoConverter<SolarSystem, SolarSystemDto> {


    @Override
    public SolarSystemDto convertToDto(SolarSystem entity) {
        return modelMapper.map(entity, SolarSystemDto.class);
    }

    @Override
    public SolarSystem convertToEntity(SolarSystemDto DTO) {
        return modelMapper.map(DTO, SolarSystem.class);
    }
}