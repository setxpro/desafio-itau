package com.github.setxpro.challenge_itau.infra.configs;

import com.github.setxpro.challenge_itau.application.gateways.TransactionGateway;
import com.github.setxpro.challenge_itau.application.usecases.CreateTransactionUseCase;
import com.github.setxpro.challenge_itau.application.usecases.CreateTransactionUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CreateTransactionUseCase createTransactionUseCase(TransactionGateway transactionGateway) {
        return new CreateTransactionUseCaseImpl(transactionGateway);
    }

}
