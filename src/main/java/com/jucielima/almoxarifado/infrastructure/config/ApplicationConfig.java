package com.jucielima.almoxarifado.infrastructure.config;

import com.jucielima.almoxarifado.application.service.LogUseCaseImpl;
import com.jucielima.almoxarifado.application.usecase.LogUseCase;
import com.jucielima.almoxarifado.domain.gateway.LogGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public LogUseCase logUseCase(LogGateway logGateway){
        return new LogUseCaseImpl(logGateway);
    }
}
