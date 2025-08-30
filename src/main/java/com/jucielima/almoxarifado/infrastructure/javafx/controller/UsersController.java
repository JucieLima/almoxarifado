package com.jucielima.almoxarifado.infrastructure.javafx.controller;

import com.jucielima.almoxarifado.application.dto.LogDto;
import com.jucielima.almoxarifado.application.usecase.LogUseCase;
import com.jucielima.almoxarifado.domain.enums.LogLevel;
import com.jucielima.almoxarifado.domain.enums.LogType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class UsersController {

    @FXML
    private VBox dashboardPane;

    @FXML
    private ToggleGroup exibir;

    @FXML
    private RadioButton radioButtonOrder1;

    @FXML
    private RadioButton radioButtonOrder2;

    @FXML
    private TableColumn<?, ?> tableColumnActions;

    @FXML
    private TableColumn<?, ?> tableColumnCPF;

    @FXML
    private TableColumn<?, ?> tableColumnEmail;

    @FXML
    private TableColumn<?, ?> tableColumnId;

    @FXML
    private TableColumn<?, ?> tableColumnName;

    @FXML
    private TableColumn<?, ?> tableColumnRegister;

    @FXML
    private TableColumn<?, ?> tableColumnRegisterDate;

    @FXML
    private TableView<?> tableViewUsers;

    @FXML
    private TextField textFieldSearch;

    private final ConfigurableApplicationContext applicationContext;
    private final LogUseCase logUseCase;

    public UsersController(ConfigurableApplicationContext applicationContext, LogUseCase logUseCase) {
        this.applicationContext = applicationContext;
        this.logUseCase = logUseCase;
    }

    @FXML
    void handleButtonCreateUser() {
        BorderPane borderPane = (BorderPane) dashboardPane.getParent();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/jucielima/almoxarifado/users/create_user.fxml"));
        try {
            borderPane.centerProperty().setValue(fxmlLoader.load());
        } catch (IOException e) {
            logUseCase.execute(new LogDto(e.getMessage(), LogLevel.ERROR, LogType.GENERAL));
        }
    }

    @FXML
    void handlerButtonSearch() {

    }

}
