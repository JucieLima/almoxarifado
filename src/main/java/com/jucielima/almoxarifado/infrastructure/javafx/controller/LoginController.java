package com.jucielima.almoxarifado.infrastructure.javafx.controller;

import com.jucielima.almoxarifado.StartApplication;
import com.jucielima.almoxarifado.application.dto.LoginDto;
import com.jucielima.almoxarifado.application.dto.UserDto;
import com.jucielima.almoxarifado.application.usecase.LoginUseCase;
import com.jucielima.almoxarifado.domain.exception.InvalidLoginArgumentsException;
import com.jucielima.almoxarifado.domain.exception.UserNotFoundException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.concurrent.*;

@Controller
public class LoginController {

    @FXML
    private TextFlow loginMsg;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldPassword;

    private final LoginUseCase loginUseCase;
    private final ConfigurableApplicationContext applicationContext;

    public LoginController(LoginUseCase loginUseCase, ConfigurableApplicationContext applicationContext) {
        this.loginUseCase = loginUseCase;
        this.applicationContext = applicationContext;
    }

    @FXML
    void handleForgotPassword() {

    }

    @FXML
    void handleLoginButton() {
        try{
            if(textFieldEmail.getText().isEmpty() && textFieldPassword.getText().isEmpty()){
                textFieldEmail.setText("teste@email.com");
                textFieldPassword.setText("123456");
            }
            LoginDto loginDto = new LoginDto(textFieldEmail.getText(), textFieldPassword.getText());
            UserDto user = loginUseCase.execute(loginDto);
            Stage loginStage = (Stage) loginMsg.getScene().getWindow();
            loginStage.close();
            openDashboardScreen(user);
        }catch (UserNotFoundException | InvalidLoginArgumentsException exception){
            loginMsg.setVisible(true);
            setTimeout(()-> loginMsg.setVisible(false));
        }
    }

    private void openDashboardScreen(UserDto user) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/jucielima/almoxarifado/dashboard/dashboard.fxml"));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        try {
            Parent parent = fxmlLoader.load();
            DashboardController controller = fxmlLoader.getController();
            controller.setUserDto(user);
            Scene scene = new Scene(parent, 1200,900);
            stage.setScene(scene);
            String imagePath = String.valueOf(StartApplication.class.getResource("assets/images/logo.png"));
            Image image = new Image(imagePath);
            stage.setTitle("Dashboard - Sistema de Almoxarifado");
            stage.getIcons().add(image);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setTimeout(Runnable runnable) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.schedule(runnable, 5, TimeUnit.SECONDS);
    }

}