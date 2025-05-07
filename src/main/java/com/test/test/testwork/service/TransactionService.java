package com.test.test.testwork.service;

import com.test.test.testwork.controller.dto.TransactionCriteria;
import com.test.test.testwork.controller.dto.TransactionDto;
import com.test.test.testwork.entity.TransactionEntity;
import org.springframework.data.domain.Page;

public interface TransactionService {
    Object createTransaction(TransactionDto transaction);

    Page<TransactionDto> getReports(TransactionCriteria transaction, Integer size, Integer page);
}
