package com.github.setxpro.challenge_itau.domain.dtos;

import lombok.Getter;

import java.util.DoubleSummaryStatistics;

@Getter
public class StatisticsDTO {

    private final long count;
    private final Double sum;
    private final Double avg;
    private final Double min;
    private final Double max;

    public StatisticsDTO() {
        this(new DoubleSummaryStatistics());
    }

    public StatisticsDTO(final DoubleSummaryStatistics statistics) {
        this.count = statistics.getCount();
        this.sum = statistics.getSum();
        this.avg = statistics.getAverage();
        this.min = Math.min(0, statistics.getMin());
        this.max = Math.max(0, statistics.getMax());
    }
}
