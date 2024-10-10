package com.github.setxpro.challenge_itau.infra.controllers;

import com.github.setxpro.challenge_itau.domain.dtos.StatisticsDTO;
import com.github.setxpro.challenge_itau.infra.services.StatisticsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/statistics")
@Tag(name = "Transações")
public record StatisticsController(StatisticsService statisticsService) {

    @Operation(summary = "Responsável por retornar estatísticas das transações", method = "GET")
    @GetMapping
    public ResponseEntity<StatisticsDTO> findStatistics(
            @RequestParam(value = "type") String type,
            @RequestParam(value = "time") Integer time
    ) {
        return new ResponseEntity<>(statisticsService.statistic(type, time), HttpStatus.OK);
    }
}
