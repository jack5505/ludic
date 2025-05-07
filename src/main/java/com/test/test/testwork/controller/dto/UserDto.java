package com.test.test.testwork.controller.dto;

import lombok.Builder;

@Builder
public record UserDto(String fio,
                      String username,
                      String password,
                      String email,
                      String phone,
                      String address,
                      Long userId
                      )  {

}
