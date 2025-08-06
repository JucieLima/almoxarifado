package com.jucielima.almoxarifado.domain.exception;

public class InvalidLoginArgumentsException extends RuntimeException {
    public InvalidLoginArgumentsException(String message) {
        super(message);
    }
}
