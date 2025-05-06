package com.test.test.testwork.entity;

import com.test.test.testwork.controller.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String address;

    private String fio;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<TransactionEntity> transaction;


}
