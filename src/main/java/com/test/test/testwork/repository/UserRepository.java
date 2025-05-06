package com.test.test.testwork.repository;

import com.test.test.testwork.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<UserEntity,Long> {
}
