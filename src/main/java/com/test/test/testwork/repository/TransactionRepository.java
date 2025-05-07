package com.test.test.testwork.repository;

import com.test.test.testwork.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransactionRepository extends JpaRepository<TransactionEntity,Long>, JpaSpecificationExecutor<TransactionEntity> {

}
