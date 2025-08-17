package com.jucielima.almoxarifado.domain.gateway;

import com.jucielima.almoxarifado.application.dto.LogDto;

public interface LogGateway {
    void log(LogDto input);
}
