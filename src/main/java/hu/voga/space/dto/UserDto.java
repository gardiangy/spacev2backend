package hu.voga.space.dto;

import hu.voga.space.enums.RankType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private String uuid;
    private String name;
    private String email;
    private RankType rank;

    public UserDto() {
    }
}
