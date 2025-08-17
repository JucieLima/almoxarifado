package com.jucielima.almoxarifado.application.dto;

import com.jucielima.almoxarifado.domain.enums.LogLevel;
import com.jucielima.almoxarifado.domain.enums.LogType;

public record LogDto(String message, LogLevel level, LogType type) {
}
