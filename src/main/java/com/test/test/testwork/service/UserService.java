package com.test.test.testwork.service;

import com.test.test.testwork.controller.dto.UserDto;

public interface UserService {
    void createOrChangeUser(UserDto user);

    Object getById(Long userId);
}
