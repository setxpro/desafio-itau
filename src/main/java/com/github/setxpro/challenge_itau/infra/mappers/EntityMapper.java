package com.github.setxpro.challenge_itau.infra.mappers;

import com.github.setxpro.challenge_itau.domain.entities.Transaction;
import com.github.setxpro.challenge_itau.infra.persistences.models.TransactionEntity;

public class EntityMapper {

    private static EntityMapper instance;

    private EntityMapper() {}

    public static synchronized EntityMapper getInstance() {
        if (instance == null) {
            instance = new EntityMapper();
        }
        return instance;
    }

    public TransactionEntity toTransactionEntity(Transaction transaction) {
        return new TransactionEntity(
             transaction.getTransactionId(),
             transaction.getAmount(),
             transaction.getDateHour()
        );
    }

    public Transaction toTransactionDomainEntity(TransactionEntity transaction) {
        return new Transaction(
            transaction.getTransactionId(),
            transaction.getAmount(),
            transaction.getDateHour()
        );
    }
}
