package com.test.test.testwork.service.impl;

import com.test.test.testwork.controller.dto.Dto;
import com.test.test.testwork.controller.dto.UserDto;
import com.test.test.testwork.entity.UserEntity;
import com.test.test.testwork.exception.BadRequestException;
import com.test.test.testwork.repository.UserRepository;
import com.test.test.testwork.service.UserService;
import com.test.test.testwork.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createOrChangeUser(UserDto user)
    {
            if (Objects.isNull(user.userId()))
            {
                 userRepository.save(Utils.getUserEntity(user,UserEntity
                        .builder()
                        .build())
                );
                 return;
            }
        UserEntity userEntity = userRepository.findById(user.userId()).orElseThrow(BadRequestException::dataNotFound);
        userRepository.save(Utils.getUserEntity(user,userEntity));
    }

    @Override
    public UserDto getById(Long userId)
    {
        return userRepository.findById(userId)
                .map(i-> UserDto.builder()
                        .userId(i.getId())
                        .username(i.getUsername())
                        .password(i.getPassword())
                        .fio(i.getFio())
                        .phone(i.getPhone())
                        .email(i.getEmail())
                        .address(i.getAddress())
                        .build())
                .orElseThrow(BadRequestException::dataNotFound);
    }

    @Override
    public UserEntity getByIdUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(BadRequestException::dataNotFound);
    }


}
