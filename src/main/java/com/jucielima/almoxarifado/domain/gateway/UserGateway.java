package com.jucielima.almoxarifado.domain.gateway;

import com.jucielima.almoxarifado.domain.model.User;

public interface UserGateway {
    User findByEmail(String email);
}
