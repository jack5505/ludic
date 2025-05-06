package com.test.test.testwork.service.impl;

import com.test.test.testwork.controller.dto.TransactionDto;
import com.test.test.testwork.entity.Status;
import com.test.test.testwork.entity.TransactionEntity;
import com.test.test.testwork.entity.UserEntity;
import com.test.test.testwork.repository.TransactionRepository;
import com.test.test.testwork.service.TransactionService;
import com.test.test.testwork.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserService userService;

    @Transactional
    @Override
    public Object createTransaction(TransactionDto transaction)
    {
        TransactionEntity transactionEntity = new TransactionEntity();
        var user = userService.getById(transaction.userId());
        try {
            transactionEntity.setCreatedDate(LocalDateTime.now());
            transactionEntity.setSenderAmount(transaction.sendAmount());
            transactionEntity.setReceiverAmount(transaction.receiveAmount());
            transactionEntity.setSenderCurrency(transaction.sendCurrency());
            transactionEntity.setUser(user);
            transactionEntity.setReceiverCurrency(transaction.receiveCurrency());
            transactionEntity.setSenderAccount(transaction.senderAccount());
            transactionEntity.setReceiverAccount(transaction.receiverAccount());
            transactionEntity.setStatus(Status.SUCCESS);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return transactionRepository.save(transactionEntity);
    }


}
