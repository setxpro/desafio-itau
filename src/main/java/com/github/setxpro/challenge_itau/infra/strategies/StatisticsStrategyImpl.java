package com.github.setxpro.challenge_itau.infra.strategies;

import com.github.setxpro.challenge_itau.domain.dtos.StatisticsDTO;
import com.github.setxpro.challenge_itau.infra.persistences.repositories.TransactionRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.stream.DoubleStream;

@Component
public class StatisticsStrategyImpl implements StatisticsStrategy {

    private final TransactionRepository transactionRepository;

    public StatisticsStrategyImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public StatisticsDTO statistic(OffsetDateTime initialHour) {


            final BigDecimal[] filterValues = transactionRepository.findAll()
                    .stream()
                    .filter(t -> t.getDateHour().isAfter(initialHour) || t.getDateHour().equals(initialHour))
                    .map(x -> x.getAmount()).toArray(BigDecimal[]::new);

            DoubleStream doubleStream = Arrays.stream(filterValues).mapToDouble(BigDecimal::doubleValue);

            return new StatisticsDTO(doubleStream.summaryStatistics());

    }
}
