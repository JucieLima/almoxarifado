package com.jucielima.almoxarifado;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class StartApplication extends Application {

    ConfigurableApplicationContext applicationContext;

    @Override
    public void start(Stage stage) throws IOException {
        applicationContext = SpringApplication.run(StartApplication.class);
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("auth/login.fxml"));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}