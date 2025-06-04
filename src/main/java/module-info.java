module com.jucielima.almoxarifado {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jucielima.almoxarifado to javafx.fxml;
    exports com.jucielima.almoxarifado;
    exports com.jucielima.almoxarifado.infra.javafx.controller to javafx.fxml;
    opens com.jucielima.almoxarifado.infra.javafx.controller to javafx.fxml;
}