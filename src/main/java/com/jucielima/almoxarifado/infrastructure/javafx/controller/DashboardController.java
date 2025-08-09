package com.jucielima.almoxarifado.infrastructure.javafx.controller;

import com.jucielima.almoxarifado.application.dto.UserDto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class DashboardController implements Initializable {

    @FXML
    public BorderPane mainPane;
    @Setter
    private UserDto userDto;

    @FXML
    void handleMenuCategories() {
        replaceMainContent("/com/jucielima/almoxarifado/categories/categories.fxml");
    }

    @FXML
    void handleMenuChangePassword() {
        //todo
    }

    @FXML
    void handleMenuDashboard() {
        replaceMainContent("/com/jucielima/almoxarifado/dashboard/home.fxml");
    }

    @FXML
    void handleMenuExit() {
        //todo
    }

    @FXML
    void handleMenuMaterials() {
        replaceMainContent("/com/jucielima/almoxarifado/materiais/materiais.fxml");
    }

    @FXML
    void handleMenuOrders() {
       //todo
    }

    @FXML
    void handleMenuProfile() {
        //todo
    }

    @FXML
    void handleMenuReports() {
        replaceMainContent("/com/jucielima/almoxarifado/reports/reports_index.fxml");
    }

    @FXML
    void handleMenuUsers() {
        replaceMainContent("/com/jucielima/almoxarifado/users/users.fxml");
    }

    private void replaceMainContent(String address) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(address));
        try {
            mainPane.centerProperty().setValue(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        handleMenuDashboard();
    }
}
