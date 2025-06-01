module com.jucielima.almoxarifado {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jucielima.almoxarifado to javafx.fxml;
    exports com.jucielima.almoxarifado;
}