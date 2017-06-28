package hu.voga.space.dto.converter;


import hu.voga.space.dto.ResourceDto;
import hu.voga.space.entity.Resource;
import org.springframework.stereotype.Component;

@Component
public  class ResourceConverter extends ModelDtoConverter<Resource, ResourceDto> {


    @Override
    public ResourceDto convertToDto(Resource entity) {
        return modelMapper.map(entity, ResourceDto.class);
    }

    @Override
    public Resource convertToEntity(ResourceDto DTO) {
        return modelMapper.map(DTO, Resource.class);
    }
}