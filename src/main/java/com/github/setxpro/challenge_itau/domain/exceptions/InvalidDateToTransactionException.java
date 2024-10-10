package com.github.setxpro.challenge_itau.domain.exceptions;

public class InvalidDateToTransactionException extends RuntimeException {
    public InvalidDateToTransactionException(String message) {
        super(message);
    }
}
