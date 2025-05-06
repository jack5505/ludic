package com.test.test.testwork.entity;

import jakarta.persistence.*;
import lombok.*;

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

    private String senderUserId;

    private String receiverUserId;

    @Enumerated(EnumType.STRING)
    private Currency senderCurrency;

    @Enumerated(EnumType.STRING)
    private Currency receiverCurrency;


}
