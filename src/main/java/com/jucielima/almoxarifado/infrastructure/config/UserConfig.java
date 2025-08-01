package com.jucielima.almoxarifado.infrastructure.config;

import com.jucielima.almoxarifado.application.service.LoginUseCaseImpl;
import com.jucielima.almoxarifado.application.usecase.LoginUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public LoginUseCase loginUseCase(){
        return new LoginUseCaseImpl();
    }
}
