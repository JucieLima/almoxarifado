package com.jucielima.almoxarifado.application.service;

import com.jucielima.almoxarifado.application.dto.LoginDto;
import com.jucielima.almoxarifado.application.dto.UserDto;
import com.jucielima.almoxarifado.application.usecase.LoginUseCase;
import com.jucielima.almoxarifado.domain.exception.UserNotFoundException;

public class LoginUseCaseImpl implements LoginUseCase {
    @Override
    public UserDto execute(LoginDto input) {
        throw new UserNotFoundException("executando teste");
    }
}
