package HQ.controllers;


import HQ.controllers.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import models.Apprenticeship;

import java.util.ArrayList;

public class Application7Controller extends AbstractApplicationController {
    private MainController mainCtrl;
    @FXML
    private GridPane mainPane;
    @FXML
    private TableView<Apprenticeship> apprenticeshipTable;
    @FXML
    private TableColumn fromToColumn, courseColumn, instituteColumn, certificateColumn;

    @FXML
    private void initialize() {
        fromToColumn.setCellValueFactory(new PropertyValueFactory<Apprenticeship, String>("period"));
        courseColumn.setCellValueFactory(new PropertyValueFactory<Apprenticeship, String>("course"));
        instituteColumn.setCellValueFactory(new PropertyValueFactory<Apprenticeship, String>("instituteName"));
        certificateColumn.setCellValueFactory(new PropertyValueFactory<Apprenticeship, String>("certificate"));

    }

    public GridPane getMainPane() {
        return mainPane;
    }

    public void setMainPane(GridPane mainPane) {
        this.mainPane = mainPane;
    }

    public void setMainCtrl(MainController mainCtrl) {
        this.mainCtrl = mainCtrl;
    }
    public void showData(){
        ObservableList temp = FXCollections.observableArrayList();
        ArrayList<Apprenticeship> apprenticeships = application.getApprenticeship();
        temp.addAll(apprenticeships);
//        for (Apprenticeship apprenticeshipData: apprenticeships){
//            temp.add(new Apprenticeship(apprenticeshipData));
//
//        }
        apprenticeshipTable.setItems(temp);
    }
    public void showInfo() {
        showData();
    }








}
