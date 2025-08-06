package com.jucielima.almoxarifado.infrastructure.javafx.controller;

import com.jucielima.almoxarifado.application.dto.LoginDto;
import com.jucielima.almoxarifado.application.dto.UserDto;
import com.jucielima.almoxarifado.application.usecase.LoginUseCase;
import com.jucielima.almoxarifado.domain.exception.InvalidLoginArgumentsException;
import com.jucielima.almoxarifado.domain.exception.UserNotFoundException;
import com.jucielima.almoxarifado.domain.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;
import org.springframework.stereotype.Controller;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Controller
public class LoginController {

    @FXML
    private TextFlow loginMsg;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldPassword;

    private final LoginUseCase loginUseCase;

    public LoginController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @FXML
    void handleForgotPassword() {

    }

    @FXML
    void handleLoginButton() {
        try{
            LoginDto loginDto = new LoginDto(textFieldEmail.getText(), textFieldPassword.getText());
            UserDto user = loginUseCase.execute(loginDto);
            System.out.println(user.name());
        }catch (UserNotFoundException | InvalidLoginArgumentsException exception){
            loginMsg.setVisible(true);
            setTimeout(()->{
                loginMsg.setVisible(false);
            });
        }
    }

    private void setTimeout(Runnable runnable) {
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
        service.schedule(runnable, 5, TimeUnit.SECONDS);
    }

}