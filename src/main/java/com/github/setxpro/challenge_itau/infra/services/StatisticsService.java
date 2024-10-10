package com.github.setxpro.challenge_itau.infra.services;

import com.github.setxpro.challenge_itau.domain.dtos.StatisticsDTO;
import com.github.setxpro.challenge_itau.infra.strategies.StatisticsStrategy;
import com.github.setxpro.challenge_itau.infra.strategies.StatisticsStrategyImpl;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@Slf4j
public class StatisticsService {

    private final StatisticsStrategy statistic;

    @Autowired
    private MeterRegistry meterRegistry;

    public StatisticsService(StatisticsStrategyImpl statistic) {
        this.statistic = statistic;
    }

    public StatisticsDTO statistic(String type, Integer time) {
        return Timer.builder("transaction.statistics")  // Criação do timer para medir o tempo
                .description("Tempo gasto para calcular estatísticas de transações")
                .register(meterRegistry)
                .record(() -> {
                    final var now = OffsetDateTime.now();
                    OffsetDateTime initialTime;

                    switch (type) {
                        case "seconds" -> initialTime = now.minusSeconds(time);
                        case "minutes" -> initialTime = now.minusMinutes(time);
                        case "hours" -> initialTime = now.minusHours(time);
                        default -> throw new IllegalArgumentException("Invalid time type: " + type);
                    }

                    return statistic.statistic(initialTime);
                });
    }
}
