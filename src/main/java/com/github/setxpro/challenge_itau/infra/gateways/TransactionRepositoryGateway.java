package com.github.setxpro.challenge_itau.infra.gateways;

import com.github.setxpro.challenge_itau.application.gateways.TransactionGateway;
import com.github.setxpro.challenge_itau.domain.entities.Transaction;
import com.github.setxpro.challenge_itau.infra.mappers.EntityMapper;
import com.github.setxpro.challenge_itau.infra.persistences.repositories.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TransactionRepositoryGateway implements TransactionGateway {

    private final TransactionRepository transactionRepository;

    public TransactionRepositoryGateway(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {

        log.info("Savind a new transaction {}", transaction.getDateHour());

        return EntityMapper.getInstance().toTransactionDomainEntity(
                transactionRepository.save(
                        EntityMapper.getInstance().toTransactionEntity(transaction)
                )
        );
    }

    @Override
    public void deleteAllTransactions() {
        transactionRepository.deleteAll();
    }
}
