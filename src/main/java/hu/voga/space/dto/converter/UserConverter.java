package hu.voga.space.dto.converter;

import hu.voga.space.dto.UserDto;
import hu.voga.space.entity.User;
import org.springframework.stereotype.Component;

@Component
public  class UserConverter extends ModelDtoConverter<User, UserDto> {

    @Override
    public UserDto convertToDto(User entity) {
        return  modelMapper.map(entity, UserDto.class);
    }


    @Override
    public User convertToEntity(UserDto DTO) {
        return modelMapper.map(DTO, User.class);
    }
}