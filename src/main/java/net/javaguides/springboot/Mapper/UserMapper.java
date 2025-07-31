package net.javaguides.springboot.Mapper;

import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;

public class UserMapper {

    //User Jpa Entity into UserDto
    public static UserDto getUserDto(User user) {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail()

        );
        return userDto;
    }

    //Convert UserDto into Jpa Entity

    public static User getUser(UserDto userDto) {

        User user = new User(
                userDto.getId(),
                userDto.getFirstname(),
                userDto.getLastname(),
                userDto.getEmail()
        );
        return user;
    }

}
