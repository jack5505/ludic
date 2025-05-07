package com.test.test.testwork.controller;

import com.test.test.testwork.common.ApiKey;
import com.test.test.testwork.controller.dto.UserDto;
import com.test.test.testwork.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiKey.USERS)
public class UserController {

    private final UserService userService;

    @PostMapping
    private Object createUser(@RequestBody UserDto user) {
        userService.createOrChangeUser(user);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}")
    private Object getUser(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getById(userId));
    }

    @PutMapping
    private Object updateUser(@RequestBody UserDto user) {
        userService.createOrChangeUser(user);
        return ResponseEntity.noContent().build();
    }
}
