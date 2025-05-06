package com.test.test.testwork.service;

import com.test.test.testwork.controller.dto.UserDto;
import com.test.test.testwork.entity.UserEntity;

public interface UserService {
    void createOrChangeUser(UserDto user);

    UserEntity getById(Long userId);
}
