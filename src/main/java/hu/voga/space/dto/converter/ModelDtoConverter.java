package hu.voga.space.dto.converter;


import org.modelmapper.ModelMapper;

public abstract class ModelDtoConverter<T, E> {

    protected ModelMapper modelMapper = new ModelMapper();
    abstract public E convertToDto(T entity);
    abstract public T convertToEntity(E DTO);

}