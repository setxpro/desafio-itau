package com.github.setxpro.challenge_itau.application.usecases;

import com.github.setxpro.challenge_itau.domain.entities.Transaction;

public interface CreateTransactionUseCase  {
    Transaction execute(Transaction transaction);
}
