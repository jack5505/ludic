package com.test.test.testwork.controller.dto;

import com.test.test.testwork.entity.Currency;
import com.test.test.testwork.entity.Status;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TransactionDto(String senderAccount,
                             String receiverAccount,
                             Long sendAmount,
                             Currency sendCurrency,
                             Currency receiveCurrency,
                             Long receiveAmount,
                             Long userId,
                             Status status,
                             LocalDateTime dateTime) {
}
