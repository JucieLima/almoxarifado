package com.jucielima.almoxarifado.domain.model;

import com.jucielima.almoxarifado.domain.exception.InvalidUserArgumentsException;

import java.time.LocalDateTime;

public record User(
        Long id,
        String name,
        String email,
        String password,
        String cpf,
        String register,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public User(Long id, String name, String email, String password, String cpf, String register, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.register = register;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        validate();
    }

    private void validate() {
        if(name == null || name.isBlank()) throw new InvalidUserArgumentsException("Nome é obrigatório");
        if(email == null || email.isBlank()) throw new InvalidUserArgumentsException("Email é obrigatório");
        if(password == null || password.isBlank()) throw new InvalidUserArgumentsException("Password é obrigatório");
    }
}
