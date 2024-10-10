package com.github.setxpro.challenge_itau.infra.controllers;

import com.github.setxpro.challenge_itau.application.usecases.CreateTransactionUseCase;
import com.github.setxpro.challenge_itau.application.usecases.DeleteAllTransactionsUseCase;
import com.github.setxpro.challenge_itau.domain.entities.Transaction;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/transaction")
@Tag(name = "Transações")
public record TransactionController(
        CreateTransactionUseCase createTransactionUseCase,
        DeleteAllTransactionsUseCase deleteAllTransactionsUseCase
) {

    @Operation(summary = "Responsável por criar uma nova transação", method = "POST")
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody Transaction transaction) throws Exception {
        return new ResponseEntity<>(createTransactionUseCase.execute(transaction), HttpStatus.CREATED);
    }

    @Operation(summary = "Responsável por deletar todas as transações", method = "DELETE")
    @DeleteMapping
    public ResponseEntity<Void> deleteAllTransactions() {
        deleteAllTransactionsUseCase.execute();
        return ResponseEntity.noContent().build();
    }
}
