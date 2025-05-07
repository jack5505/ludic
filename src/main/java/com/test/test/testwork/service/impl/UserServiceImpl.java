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
            userRepository.findById(user.userId())
                .ifPresentOrElse(s-> userRepository.save(Utils.getUserEntity(user,s)),
                        ()->{
                            userRepository.save(Utils.getUserEntity(user,UserEntity.builder().build()));
                        });
    }

    @Override
    public UserEntity getById(Long userId)
    {
        return userRepository.findById(userId)
                .orElseThrow(BadRequestException::dataNotFound);
    }


}
