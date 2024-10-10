package com.github.setxpro.challenge_itau.domain.exceptions;

import java.math.BigDecimal;

public class InvalidValueToTransactionException extends RuntimeException {
    public InvalidValueToTransactionException(BigDecimal amount) {
        super("Valor inválido para a transação. R$ " + amount);
    }
}
