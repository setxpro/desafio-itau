package com.github.setxpro.challenge_itau.domain.entities;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Transaction {

    private BigDecimal amount;
    private OffsetDateTime dateHour;

    public Transaction(BigDecimal amount, OffsetDateTime dateHour) {
        this.amount = amount;
        this.dateHour = dateHour;
    }

    public Transaction() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OffsetDateTime getDateHour() {
        return dateHour;
    }

    public void setDateHour(OffsetDateTime dateHour) {
        this.dateHour = dateHour;
    }
}
