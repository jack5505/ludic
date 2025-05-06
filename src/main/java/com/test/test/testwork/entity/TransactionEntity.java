package com.test.test.testwork.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long senderAmount;

    private Long receiverAmount;

    @ManyToOne
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    private Currency senderCurrency;

    @Enumerated(EnumType.STRING)
    private Currency receiverCurrency;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdDate;

    private String senderAccount;

    private String receiverAccount;

}
