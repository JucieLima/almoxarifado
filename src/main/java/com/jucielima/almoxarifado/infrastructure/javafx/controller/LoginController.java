package com.jucielima.almoxarifado.infrastructure.javafx.controller;

import com.jucielima.almoxarifado.application.dto.LoginDto;
import com.jucielima.almoxarifado.application.usecase.LoginUseCase;
import com.jucielima.almoxarifado.domain.exception.UserNotFoundException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;
import org.springframework.stereotype.Controller;

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
        System.out.println("Iniciando login");
        try{
            LoginDto loginDto = new LoginDto(textFieldEmail.getText(), textFieldPassword.getText());
            loginUseCase.execute(loginDto);
        }catch (UserNotFoundException exception){
            System.out.println("Usuário não localizado");
            System.out.println(exception.getMessage());
        }
    }

}