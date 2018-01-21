package hu.voga.space.dto.converter;


import hu.voga.space.dto.PlanetDto;
import hu.voga.space.entity.Planet;
import org.springframework.stereotype.Component;

@Component
public  class PlanetConverter extends ModelDtoConverter<Planet, PlanetDto> {

    @Override
    public PlanetDto convertToDto(Planet entity) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(entity, PlanetDto.class);
    }

    @Override
    public Planet convertToEntity(PlanetDto DTO) {
        return modelMapper.map(DTO, Planet.class);
    }
}