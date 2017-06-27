package hu.voga.space.dto.converter;


import hu.voga.space.dto.GridDto;
import hu.voga.space.entity.Grid;
import org.springframework.stereotype.Component;

@Component
public  class GridConverter extends ModelDtoConverter<Grid, GridDto> {


    @Override
    public GridDto convertToDto(Grid entity) {
        return modelMapper.map(entity, GridDto.class);
    }

    @Override
    public Grid convertToEntity(GridDto DTO) {
        return modelMapper.map(DTO, Grid.class);
    }
}