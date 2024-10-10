package com.github.setxpro.challenge_itau.infra.services;

import com.github.setxpro.challenge_itau.domain.dtos.StatisticsDTO;
import com.github.setxpro.challenge_itau.infra.strategies.StatisticsStrategy;
import com.github.setxpro.challenge_itau.infra.strategies.StatisticsStrategyImpl;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class StatisticsService {

    private final StatisticsStrategy statistic;

    public StatisticsService(StatisticsStrategyImpl statistic) {
        this.statistic = statistic;
    }

    public StatisticsDTO statistic(String type, Integer time) {

        final var now = OffsetDateTime.now();
        OffsetDateTime initialTime;

        switch (type) {
            case "seconds" -> initialTime = now.minusSeconds(time);
            case "minutes" -> initialTime = now.minusMinutes(time);
            case "hours" -> initialTime = now.minusHours(time);
            default -> throw new IllegalArgumentException("Invalid time type: " + type);
        }

        return statistic.statistic(initialTime);
    }
}
