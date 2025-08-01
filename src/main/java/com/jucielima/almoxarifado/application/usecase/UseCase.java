package com.jucielima.almoxarifado.application.usecase;

public interface UseCase <I, O>{
    O execute(I input);
}
