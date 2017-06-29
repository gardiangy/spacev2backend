package hu.voga.space.dto.converter;


import hu.voga.space.dto.BuildingDto;
import hu.voga.space.dto.PlanetDto;
import hu.voga.space.entity.Building;
import hu.voga.space.entity.Planet;
import org.modelmapper.Converter;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public  class PlanetConverter extends ModelDtoConverter<Planet, PlanetDto> {

    @Override
    public PlanetDto convertToDto(Planet entity) {
        return modelMapper.map(entity, PlanetDto.class);
    }

    @Override
    public Planet convertToEntity(PlanetDto DTO) {
        return modelMapper.map(DTO, Planet.class);
    }
}