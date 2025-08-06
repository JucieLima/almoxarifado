package com.jucielima.almoxarifado.infrastructure.adapter;

import com.jucielima.almoxarifado.domain.gateway.PasswordEncryptor;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncryptorImpl implements PasswordEncryptor {
    @Override
    public Boolean matches(String password, String hash) {
        return password.equals(hash);
    }
}
