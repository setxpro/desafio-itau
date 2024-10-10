package com.github.setxpro.challenge_itau.application.usecases;

import com.github.setxpro.challenge_itau.application.gateways.TransactionGateway;

public class DeleteAllTransactionsUseCaseImpl implements DeleteAllTransactionsUseCase {

    private final TransactionGateway transactionGateway;

    public DeleteAllTransactionsUseCaseImpl(TransactionGateway transactionGateway) {
        this.transactionGateway = transactionGateway;
    }

    @Override
    public void execute() {
        transactionGateway.deleteAllTransactions();
    }
}
