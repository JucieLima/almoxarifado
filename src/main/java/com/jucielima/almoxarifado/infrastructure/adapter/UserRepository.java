package com.jucielima.almoxarifado.infrastructure.adapter;

import com.jucielima.almoxarifado.domain.exception.UserNotFoundException;
import com.jucielima.almoxarifado.domain.gateway.UserGateway;
import com.jucielima.almoxarifado.domain.gateway.UserMapper;
import com.jucielima.almoxarifado.domain.model.User;
import com.jucielima.almoxarifado.infrastructure.database.entities.UserEntity;
import com.jucielima.almoxarifado.infrastructure.database.entities.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements UserGateway {
    @Autowired
    private UserJpaRepository userJpa;
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByEmail(String email) {
        UserEntity userEntity = userJpa.findByEmail(email).orElseThrow(()->
                new UserNotFoundException("Usuário não encontrado")
        );
        return userMapper.userEntityToUser(userEntity);
    }
}
