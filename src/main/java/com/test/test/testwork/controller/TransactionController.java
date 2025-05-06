package com.test.test.testwork.controller;

import com.test.test.testwork.common.ApiKey;
import com.test.test.testwork.controller.dto.TransactionDto;
import com.test.test.testwork.service.TransactionService;
import com.test.test.testwork.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(ApiKey.TRANSACTIONS)
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;


    @PostMapping
    public ResponseEntity<?> createTransaction(@RequestBody TransactionDto transaction) {
        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    }

}
