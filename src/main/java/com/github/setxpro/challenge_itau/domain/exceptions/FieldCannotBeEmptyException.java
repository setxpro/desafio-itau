package com.github.setxpro.challenge_itau.domain.exceptions;

public class FieldCannotBeEmptyException extends RuntimeException {
    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public FieldCannotBeEmptyException(String message) {
        super("O campo " + message + " não pode ficar vazio.");
    }
}
