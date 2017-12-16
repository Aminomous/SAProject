package HR.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import models.Apprenticeship;
import models.EmploymentRecord;
import models.Q6;

import java.util.ArrayList;

public class Application10Controller extends AbstractApplicationController{
    private MainController mainCtrl;
    @FXML
    private GridPane mainPane;
    @FXML
    private TableView<Q6> otherTable;
    @FXML
    private TableColumn jobAdvertiseColumn, infoColumn;

    @FXML
    private void initialize() {
        jobAdvertiseColumn.setCellValueFactory(new PropertyValueFactory<Apprenticeship, String>("mediaType"));
        infoColumn.setCellValueFactory(new PropertyValueFactory<Apprenticeship, String>("detail"));

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
        ArrayList<Q6> q6s = application.getPersonalInformation().getQ6();
        temp.addAll(q6s);
        otherTable.setItems(temp);

    }

    public void showInfo() {
        showData();
    }


}
