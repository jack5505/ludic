package com.test.test.testwork.utils;

import com.test.test.testwork.controller.dto.UserDto;
import com.test.test.testwork.entity.UserEntity;

public class Utils {

    public static UserEntity getUserEntity(UserDto userDto,
                                           UserEntity userEntity)
    {
        userEntity.setAddress(userDto.address());
        userEntity.setEmail(userDto.email());
        userEntity.setPhone(userDto.phone());
        userEntity.setUsername(userDto.username());
        userEntity.setPassword(userDto.password());
        userEntity.setFio(userDto.fio());
        return userEntity;
    }

}
