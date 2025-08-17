package com.jucielima.almoxarifado.infrastructure.adapter;

import com.jucielima.almoxarifado.application.dto.LogDto;
import com.jucielima.almoxarifado.domain.enums.LogLevel;
import com.jucielima.almoxarifado.domain.enums.LogType;
import com.jucielima.almoxarifado.domain.gateway.LogGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Service
public class LogGatewayAdapter implements LogGateway {
    Logger logger;
    @Override
    public void log(LogDto input) {
        logger = Logger.getLogger(input.type().name());
        addHadler(input.type());
        logger.log(mapToLevel(input.level()), input.message());
    }

    private Level mapToLevel(LogLevel level) {
       switch (level){
           case DEBUG -> {
               return Level.FINEST;
           }
           case WARNING ->
           {
               return Level.WARNING;
           }
           case ERROR -> {
               return Level.SEVERE;
           }
           default -> {
               return Level.INFO;
           }
       }
    }

    private void addHadler(LogType type) {
        if(logger.getHandlers().length == 0){
            try {
                Files.createDirectories(Path.of("logs"));
                FileHandler fileHandler = new FileHandler("logs/" + type + ".log");
                fileHandler.setFormatter(new SimpleFormatter());
                logger.addHandler(fileHandler);
                logger.setLevel(Level.FINEST);
                logger.setUseParentHandlers(true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
