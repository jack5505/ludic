package com.test.test.testwork.service.impl;

import com.test.test.testwork.controller.dto.TransactionCriteria;
import com.test.test.testwork.controller.dto.TransactionDto;
import com.test.test.testwork.entity.Status;
import com.test.test.testwork.entity.TransactionEntity;
import com.test.test.testwork.entity.UserEntity;
import com.test.test.testwork.repository.CreateSpecification;
import com.test.test.testwork.repository.TransactionRepository;
import com.test.test.testwork.service.TransactionService;
import com.test.test.testwork.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        var user = userService.getByIdUser(transaction.userId());
        try {
            transactionEntity.setCreatedDate(LocalDateTime.now());
            transactionEntity.setSenderAmount(transaction.sendAmount());
            transactionEntity.setReceiverAmount(transaction.receiveAmount());
            transactionEntity.setSenderCurrency(transaction.sendCurrency());
            transactionEntity.setUser(user);
            transactionEntity.setReceiverCurrency(transaction.receiveCurrency());
            transactionEntity.setSenderAccount(transaction.senderAccount());
            transactionEntity.setReceiverAccount(transaction.receiverAccount());

            transactionEntity.setTransactionTime(LocalDateTime.now()
                    .toInstant(ZoneOffset.MAX)
                    .toEpochMilli()
            );

            transactionEntity.setStatus(Status.SUCCESS);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return transactionRepository.save(transactionEntity);
    }

    @Override
    public Page<TransactionDto> getReports(TransactionCriteria transaction,
                                   Integer size,
                                   Integer page)
    {
        var list = transactionRepository.findAll(CreateSpecification
                                .createSpecification(transaction),
                        PageRequest.of(page, size))
                .stream()
                .map(i -> TransactionDto
                        .builder()
                        .userId(i.getUser().getId())
                        .dateTime(i.getCreatedDate())
                        .status(i.getStatus())
                        .receiverAccount(i.getReceiverAccount())
                        .sendAmount(i.getSenderAmount())
                        .receiveAmount(i.getReceiverAmount())
                        .sendCurrency(i.getSenderCurrency())
                        .receiveCurrency(i.getReceiverCurrency())
                        .build())
                .toList();
        return new PageImpl<>(list, PageRequest.of(page, size), list.size());
    }


}
