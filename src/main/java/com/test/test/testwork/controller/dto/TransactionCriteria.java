package com.test.test.testwork.controller.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionCriteria {
    private Long start;
    private Long end;
    private Long userId;
    private String senderAccount;
    private String receiverAccount;
}
