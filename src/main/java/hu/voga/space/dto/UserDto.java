package hu.voga.space.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private String uuid;
    private String name;
    private String email;

    public UserDto() {
    }
}
