package com.test.test.testwork.repository;

import com.test.test.testwork.controller.dto.TransactionCriteria;
import com.test.test.testwork.entity.TransactionEntity;
import com.test.test.testwork.entity.UserEntity;
import jakarta.persistence.criteria.Join;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.Objects;

public class CreateSpecification {

    public static Specification<TransactionEntity> createSpecification(TransactionCriteria criteria){
            return greaterThan(criteria.getStart())
                    .and(equalTo(criteria.getReceiverAccount(),"receiverAccount"))
                    .and(equalTo(criteria.getSenderAccount(),"senderAccount"))
                    .and(equalToUser(criteria.getUserId()))
                    .and(lessThan(criteria.getEnd()));
    }

    public static Specification<TransactionEntity> equalTo(String value,String key){
        return ((root, query, criteriaBuilder) -> Objects.nonNull(value) && StringUtils.isNoneEmpty(value) ? criteriaBuilder.equal(root.get(key), value) : null);
    }

    public static Specification<TransactionEntity> greaterThan(Long time){
        return ((root, query, criteriaBuilder) -> Objects.nonNull(time) ? criteriaBuilder.greaterThanOrEqualTo(root.get("transactionTime"),time) : null);
    }
    public static Specification<TransactionEntity> lessThan(Long time){
        return (root, query, criteriaBuilder) -> Objects.nonNull(time) ? criteriaBuilder.lessThanOrEqualTo(root.get("transactionTime"), time)  : null;
    }
    public static Specification<TransactionEntity> equalToUser(Long value){
        return (root, query, criteriaBuilder) -> {
          if(Objects.isNull(value) || StringUtils.isEmpty(value + "")){
              return null;
          }
            Join<TransactionEntity, UserEntity> userJoin = root.join("user");
            return criteriaBuilder.equal(userJoin.get("id"), value);
        };
    }

}
