package com.github.setxpro.challenge_itau.infra.controllers;

import com.github.setxpro.challenge_itau.domain.dtos.StatisticsDTO;
import com.github.setxpro.challenge_itau.infra.services.StatisticsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping(value = "/statistics")
public record StatisticsController(StatisticsService statisticsService) {

    @GetMapping
    public ResponseEntity<StatisticsDTO> findStatistics(
            @RequestParam(value = "type") String type,
            @RequestParam(value = "time") Integer time
    ) {
        return new ResponseEntity<>(statisticsService.statistic(type, time), HttpStatus.OK);
    }
}
