package com.github.setxpro.challenge_itau.infra.strategies;

import com.github.setxpro.challenge_itau.domain.dtos.StatisticsDTO;

import java.time.OffsetDateTime;

public interface StatisticsStrategy {
    StatisticsDTO statistic(OffsetDateTime initialHour);
}
