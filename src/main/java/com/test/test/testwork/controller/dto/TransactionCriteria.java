package com.test.test.testwork.controller.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionCriteria {
    private LocalDateTime start;
    private LocalDateTime end;
    private Long userId;
    private String senderAccount;
    private String receiverAccount;
}
