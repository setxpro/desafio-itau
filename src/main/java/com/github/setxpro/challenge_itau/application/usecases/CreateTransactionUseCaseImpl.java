package com.github.setxpro.challenge_itau.application.usecases;

import com.github.setxpro.challenge_itau.application.gateways.TransactionGateway;
import com.github.setxpro.challenge_itau.domain.entities.Transaction;
import com.github.setxpro.challenge_itau.domain.exceptions.FieldCannotBeEmptyException;
import com.github.setxpro.challenge_itau.domain.exceptions.InvalidDateToTransactionException;
import com.github.setxpro.challenge_itau.domain.exceptions.InvalidValueToTransactionException;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Slf4j
public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    private final TransactionGateway transactionGateway;

    public CreateTransactionUseCaseImpl(TransactionGateway transactionGateway) {
        this.transactionGateway = transactionGateway;
    }

    @Override
    public Transaction execute(Transaction transaction) {

        validateTransaction(transaction);

        return transactionGateway.createTransaction(transaction);
    }

    private static void validateTransaction(Transaction transaction) {
        if (transaction.getAmount() == null) {
            log.error("Field 'amount' cannot be empty");
            throw new FieldCannotBeEmptyException("valor");
        }
        if (transaction.getDateHour() == null) {
            log.error("Field 'dateHour' cannot be empty");
            throw new FieldCannotBeEmptyException("data");
        }

        if (transaction.getAmount().compareTo(BigDecimal.ZERO) == 0) {
            log.error("Invalid transaction amount: {}", transaction.getAmount());
            throw new InvalidValueToTransactionException(transaction.getAmount());
        }

        if (transaction.getDateHour().isAfter(OffsetDateTime.now())) {
            log.error("Transaction date is in the future: {}", transaction.getDateHour());
            throw new InvalidDateToTransactionException("Data inválida para transação.");
        }
    }
}
