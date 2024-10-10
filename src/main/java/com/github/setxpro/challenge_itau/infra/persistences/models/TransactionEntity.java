package com.github.setxpro.challenge_itau.infra.persistences.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "tb_transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "transactionId")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "amount")
    @NotNull
    private BigDecimal amount;

    @Column(name = "date_hour")
    @NotNull
    private OffsetDateTime dateHour;
}
