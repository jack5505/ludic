package com.test.test.testwork.controller;

import com.test.test.testwork.common.ApiKey;
import com.test.test.testwork.controller.dto.TransactionCriteria;
import com.test.test.testwork.controller.dto.TransactionDto;
import com.test.test.testwork.service.TransactionService;
import com.test.test.testwork.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiKey.TRANSACTIONS)
public class TransactionController {

    private final TransactionService transactionService;


    @PostMapping
    public ResponseEntity<?> createTransaction(@RequestBody TransactionDto transaction) {
        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    }

    @GetMapping
    public ResponseEntity<?> getTransactions(@RequestParam(required = false, defaultValue = "10") Integer size,
                                             @RequestParam(required = false, defaultValue = "0") Integer page,
                                             @RequestParam(name = "from")  //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
                                                 LocalDate start,
                                             @RequestParam(name = "to") //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
                                                 LocalDate end,
                                             @RequestParam(name = "userId",required = false) Long userId,
                                             @RequestParam(name = "senderAccount",required = false) String senderAccount,
                                             @RequestParam(name = "receiverAccount",required = false) String receiverAccount
                                             ) {
        TransactionCriteria transaction = TransactionCriteria
                .builder()
                .start(start.atTime(0,0,0)
                        .toInstant(ZoneOffset.MAX)
                        .toEpochMilli()
                )
                .end(end.atTime(23, 59, 59)
                        .toInstant(ZoneOffset.MAX)
                        .toEpochMilli()
                )
                .userId(userId)
                .senderAccount(senderAccount)
                .receiverAccount(receiverAccount)
                .build();
        return ResponseEntity.ok(transactionService.getReports(transaction,size,page));

    }


}
