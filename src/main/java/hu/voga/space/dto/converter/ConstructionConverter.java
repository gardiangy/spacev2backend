package hu.voga.space.dto.converter;


import hu.voga.space.dto.ConstructionDto;
import hu.voga.space.entity.Construction;
import org.springframework.stereotype.Component;

@Component
public  class ConstructionConverter extends ModelDtoConverter<Construction, ConstructionDto> {


    @Override
    public ConstructionDto convertToDto(Construction entity) {
        return modelMapper.map(entity, ConstructionDto.class);
    }

    @Override
    public Construction convertToEntity(ConstructionDto DTO) {
        return modelMapper.map(DTO, Construction.class);
    }
}