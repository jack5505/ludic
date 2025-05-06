package com.test.test.testwork.controller;

import com.test.test.testwork.controller.dto.UserDto;
import com.test.test.testwork.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    private Object createUser(@RequestBody UserDto user) {
        return ResponseEntity.ok(userService.createUser(user));
    }
}
