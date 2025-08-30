package com.jucielima.almoxarifado.infrastructure.javafx.controller;

import com.jucielima.almoxarifado.infrastructure.javafx.viewmodel.OrderViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class HomeController implements Initializable {

    @FXML
    private Label availableItems;

    @FXML
    private VBox dashboardPane;

    @FXML
    private LineChart<String, Integer> lineChart;

    @FXML
    private Label minimumStock;

    @FXML
    private PieChart pieChart;

    @FXML
    private Label recentOrders;

    @FXML
    private TableColumn<OrderViewModel, Integer> tableColumnAmount;

    @FXML
    private TableColumn<OrderViewModel, String> tableColumnAuthor;

    @FXML
    private TableColumn<OrderViewModel, String> tableColumnCategory;

    @FXML
    private TableColumn<OrderViewModel, LocalDateTime> tableColumnDate;

    @FXML
    private TableColumn<OrderViewModel, String> tableColumnMaterial;

    @FXML
    private TableColumn<OrderViewModel, String> tableColumnStatus;

    @FXML
    private TableView<OrderViewModel> tableViewOrders;

    @FXML
    private Label totalItems;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initLabels();
        initLineChart();
        iniPieChart();
        initTableViewOrders();
    }

    private void initLabels() {
        totalItems.setText("57967");
        availableItems.setText("45814");
        minimumStock.setText("457");
        recentOrders.setText("45123");
    }

    private void initLineChart() {
        XYChart.Series<String, Integer> dataSeries1 = new XYChart.Series<>();
        dataSeries1.setName("2014");

        dataSeries1.getData().add(new XYChart.Data<>( "Seg", 567));
        dataSeries1.getData().add(new XYChart.Data<>( "Ter", 612));
        dataSeries1.getData().add(new XYChart.Data<>("Qua", 800));
        dataSeries1.getData().add(new XYChart.Data<>("Qui", 780));
        dataSeries1.getData().add(new XYChart.Data<>("Sex", 810));
        dataSeries1.getData().add(new XYChart.Data<>("Sab", 850));

        lineChart.getData().add(dataSeries1);
    }

    private void iniPieChart() {
        PieChart.Data slice1 = new PieChart.Data("Desktop", 213);
        PieChart.Data slice2 = new PieChart.Data("Phone"  , 67);
        PieChart.Data slice3 = new PieChart.Data("Tablet" , 36);

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);
    }

    private void initTableViewOrders() {
        setTableColumns();
        List<OrderViewModel> orderViewModels = getOrderList();
        ObservableList<OrderViewModel> observableList = FXCollections.observableList(orderViewModels);
        tableViewOrders.getItems().addAll(observableList);
    }

    private List<OrderViewModel> getOrderList() {
        List<OrderViewModel> modelList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            OrderViewModel model = new OrderViewModel();
            model.setMaterial("Folhas A4 500");
            model.setCategory("Escritório");
            model.setAuthor("Juciê Lima");
            model.setStatus("Entregue");
            model.setAmount(12);
            model.setDate(LocalDateTime.now());
            modelList.add(model);
        }
        return modelList;
    }

    private void setTableColumns() {
        tableColumnMaterial.setCellValueFactory(cell->cell.getValue().materialProperty());
        tableColumnCategory.setCellValueFactory(cell->cell.getValue().categoryProperty());
        tableColumnAuthor.setCellValueFactory(cell->cell.getValue().authorProperty());
        tableColumnStatus.setCellValueFactory(cell->cell.getValue().statusProperty());
        tableColumnAmount.setCellValueFactory(cell->cell.getValue().amountProperty().asObject());
        tableColumnDate.setCellValueFactory(cell->cell.getValue().dateProperty());
        tableColumnDate.setCellFactory(cell->formatterDate());
    }

    private TableCell<OrderViewModel, LocalDateTime> formatterDate() {
        return  new TableCell<>(){
            @Override
            protected void updateItem(LocalDateTime localDateTime, boolean empty) {
                super.updateItem(localDateTime, empty);
                if(localDateTime == null || empty){
                    setText(null);
                }else {
                    String pattern = "dd/MM/YY HH:mm";
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                    setText(localDateTime.format(formatter));
                }
            }
        };
    }
}
