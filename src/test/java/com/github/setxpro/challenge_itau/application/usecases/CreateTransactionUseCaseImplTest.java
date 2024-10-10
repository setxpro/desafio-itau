package com.github.setxpro.challenge_itau.application.usecases;

import com.github.setxpro.challenge_itau.application.gateways.TransactionGateway;
import com.github.setxpro.challenge_itau.domain.entities.Transaction;
import com.github.setxpro.challenge_itau.domain.exceptions.InvalidDateToTransactionException;
import com.github.setxpro.challenge_itau.domain.exceptions.InvalidValueToTransactionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateTransactionUseCaseImplTest {

    @Mock
    private TransactionGateway transactionGateway;

    @InjectMocks
    private CreateTransactionUseCaseImpl createTransactionUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldThrowExceptionWhenAmountIsNull() {
        Transaction transaction = new Transaction();
        transaction.setAmount(BigDecimal.ZERO);
        transaction.setDateHour(OffsetDateTime.now());

        Exception exception = assertThrows(InvalidValueToTransactionException.class, () -> {
            createTransactionUseCase.execute(transaction);
        });

        assertTrue(exception.getMessage().contains("0"));

        verify(transactionGateway, never()).createTransaction(any());

    }

    @Test
    void shouldThrowExceptionWhenDateIsNull() {
        Transaction transaction = new Transaction();
        transaction.setAmount(BigDecimal.TEN);
        transaction.setDateHour(OffsetDateTime.now().plusDays(1));

        Exception exception = assertThrows(InvalidDateToTransactionException.class, () -> {
            createTransactionUseCase.execute(transaction);
        });

        assertEquals("Data inválida para transação.", exception.getMessage());
        verify(transactionGateway, never()).createTransaction(any());
    }

    @Test
    void shouldThrowExceptionWhenAmountIsZero() {

        Transaction transaction = new Transaction();
        transaction.setAmount(BigDecimal.ZERO);
        transaction.setDateHour(OffsetDateTime.now());

        Exception exception = assertThrows(InvalidValueToTransactionException.class, () -> {
            createTransactionUseCase.execute(transaction);
        });

        assertTrue(exception.getMessage().contains("0"));
        verify(transactionGateway, never()).createTransaction(any());


    }

    @Test
    void shouldThrowExceptionWhenDateIsInTheFuture() {
        Transaction transaction = new Transaction();
        transaction.setAmount(BigDecimal.TEN);
        transaction.setDateHour(OffsetDateTime.now().plusDays(1));

        Exception exception = assertThrows(InvalidDateToTransactionException.class, () -> {
            createTransactionUseCase.execute(transaction);
        });

        assertEquals("Data inválida para transação.", exception.getMessage());
        verify(transactionGateway, never()).createTransaction(any());
    }

    @Test
    void shouldCreateTransactionSuccessfully() {
        Transaction transaction = new Transaction();
        transaction.setAmount(BigDecimal.TEN);
        transaction.setDateHour(OffsetDateTime.now());

        when(transactionGateway.createTransaction(any())).thenReturn(transaction);

        Transaction result = createTransactionUseCase.execute(transaction);

        assertNotNull(result);
        verify(transactionGateway, times(1)).createTransaction(transaction);
    }



}