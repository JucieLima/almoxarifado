package com.jucielima.almoxarifado.domain.gateway;

public interface PasswordEncryptor {
    Boolean matches(String password, String hash);
}
