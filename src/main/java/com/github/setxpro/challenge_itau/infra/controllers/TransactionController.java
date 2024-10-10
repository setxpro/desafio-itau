package com.github.setxpro.challenge_itau.infra.controllers;

import com.github.setxpro.challenge_itau.application.usecases.CreateTransactionUseCase;
import com.github.setxpro.challenge_itau.domain.entities.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transaction", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public record TransactionController(CreateTransactionUseCase createTransactionUseCase) {

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) throws Exception {
        return new ResponseEntity<>(createTransactionUseCase.execute(transaction), HttpStatus.CREATED);
    }
}
