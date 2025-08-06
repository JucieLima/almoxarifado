package com.jucielima.almoxarifado.application.service;

import com.jucielima.almoxarifado.application.dto.LoginDto;
import com.jucielima.almoxarifado.application.dto.UserDto;
import com.jucielima.almoxarifado.application.usecase.LoginUseCase;
import com.jucielima.almoxarifado.domain.exception.InvalidLoginArgumentsException;
import com.jucielima.almoxarifado.domain.gateway.PasswordEncryptor;
import com.jucielima.almoxarifado.domain.gateway.UserGateway;
import com.jucielima.almoxarifado.domain.gateway.UserMapper;
import com.jucielima.almoxarifado.domain.model.User;

public class LoginUseCaseImpl implements LoginUseCase {
    private final UserGateway userGateway;
    private final PasswordEncryptor passwordEncryptor;
    private final UserMapper userMapper;

    public LoginUseCaseImpl(UserGateway userGateway, PasswordEncryptor passwordEncryptor, UserMapper userMapper) {
        this.userGateway = userGateway;
        this.passwordEncryptor = passwordEncryptor;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto execute(LoginDto input) {
        if(input.email() == null || input.email().isBlank())
            throw new InvalidLoginArgumentsException("Credenciais inválidas!");
        if(input.password() == null || input.password().isBlank())
            throw new InvalidLoginArgumentsException("Credenciais inválidas!");
        User user = userGateway.findByEmail(input.email());
        if(!passwordEncryptor.matches(input.password(), user.password()))
            throw new InvalidLoginArgumentsException("Credenciais inválidas!");
        return userMapper.userToUserDto(user);
    }
}
