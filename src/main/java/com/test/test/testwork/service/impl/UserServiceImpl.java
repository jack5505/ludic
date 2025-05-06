package com.test.test.testwork.service.impl;

import com.test.test.testwork.controller.dto.UserDto;
import com.test.test.testwork.repository.UserRepository;
import com.test.test.testwork.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Object createUser(UserDto user) {
        return null;
    }
}
