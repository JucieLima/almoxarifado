package com.jucielima.almoxarifado.application.dto;

import java.time.LocalDateTime;

public record UserDto(
        Long id,
        String name,
        String email,
        String password,
        String cpf,
        String register,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

}
