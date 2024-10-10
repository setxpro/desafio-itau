package com.github.setxpro.challenge_itau.application.gateways;

import com.github.setxpro.challenge_itau.domain.entities.Transaction;

public interface TransactionGateway {
    Transaction createTransaction(Transaction transaction);
    void deleteAllTransactions();
}
