package hu.voga.space.dto.converter;


import hu.voga.space.dto.BuildingDto;
import hu.voga.space.dto.PlanetDto;
import hu.voga.space.entity.Building;
import hu.voga.space.entity.Planet;
import org.springframework.stereotype.Component;

@Component
public  class BuildingConverter extends ModelDtoConverter<Building, BuildingDto> {

    @Override
    public BuildingDto convertToDto(Building entity) {
        return modelMapper.map(entity, BuildingDto.class);
    }

    @Override
    public Building convertToEntity(BuildingDto DTO) {
        return modelMapper.map(DTO, Building.class);
    }
}