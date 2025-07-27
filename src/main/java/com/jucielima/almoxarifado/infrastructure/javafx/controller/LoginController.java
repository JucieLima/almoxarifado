package com.jucielima.almoxarifado.infrastructure.javafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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

    @FXML
    void handleForgotPassword(MouseEvent event) {

    }

    @FXML
    void handleLoginButton(ActionEvent event) {
    }

}
