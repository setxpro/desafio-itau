package com.github.setxpro.challenge_itau.infra.persistences.repositories;

import com.github.setxpro.challenge_itau.domain.entities.Transaction;
import com.github.setxpro.challenge_itau.infra.persistences.models.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
}
