package com.jucielima.almoxarifado.application.service;

import com.jucielima.almoxarifado.application.dto.LogDto;
import com.jucielima.almoxarifado.application.usecase.LogUseCase;
import com.jucielima.almoxarifado.domain.gateway.LogGateway;

public class LogUseCaseImpl implements LogUseCase {
    private final LogGateway logGateway;

    public LogUseCaseImpl(LogGateway logGateway) {
        this.logGateway = logGateway;
    }

    @Override
    public Void execute(LogDto input) {
        logGateway.log(input);
        return null;
    }
}
