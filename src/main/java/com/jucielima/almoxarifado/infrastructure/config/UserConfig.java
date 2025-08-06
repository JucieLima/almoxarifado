package com.jucielima.almoxarifado.infrastructure.config;

import com.jucielima.almoxarifado.application.service.LoginUseCaseImpl;
import com.jucielima.almoxarifado.application.usecase.LoginUseCase;
import com.jucielima.almoxarifado.domain.gateway.PasswordEncryptor;
import com.jucielima.almoxarifado.domain.gateway.UserGateway;
import com.jucielima.almoxarifado.domain.gateway.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public LoginUseCase loginUseCase(UserGateway userGateway, PasswordEncryptor passwordEncryptor, UserMapper userMapper){
        return new LoginUseCaseImpl(userGateway, passwordEncryptor, userMapper);
    }
}
