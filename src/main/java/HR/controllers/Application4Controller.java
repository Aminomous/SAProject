package HR.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import models.Education;
import models.EmploymentRecord;

import java.util.ArrayList;
import java.util.Calendar;

public class Application4Controller extends AbstractApplicationController {
    private GridPane mainPane;
    @FXML
    private TableView<Application4Controller.EmploymentData> employmentTable;
    @FXML
    private TableColumn fromToColumn, companyColumn, positionColumn, salaryColumn, reasonColumn;

    @FXML
    private void initialize() {
        fromToColumn.setCellValueFactory(new PropertyValueFactory<EmploymentData, String>("fromTo"));
        companyColumn.setCellValueFactory(new PropertyValueFactory<EmploymentData, String>("company"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<EmploymentData, String>("position"));
        //workerTyrColumn.setCellValueFactory(new PropertyValueFactory<EmploymentData, String>("workerType"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<EmploymentData, Double>("salary"));
        reasonColumn.setCellValueFactory(new PropertyValueFactory<EmploymentData, String>("reasonForLeaving"));


    }
    public void showData(){
        ObservableList temp = FXCollections.observableArrayList();
        ArrayList<EmploymentRecord> employmentRecords = application.getEmploymentRecords();
        for (EmploymentRecord employmentRecord: employmentRecords){
            temp.add(new EmploymentData(employmentRecord));

        }
        employmentTable.setItems(temp);
    }

    public GridPane getMainPane() {
        return mainPane;
    }

    public void setMainPane(GridPane mainPane) {
        this.mainPane = mainPane;
    }

    public void showInfo() {
        showData();
    }


    public class EmploymentData extends EmploymentRecord{
        private String fromTo;
        private EmploymentRecord employmentRecord;
        EmploymentData(EmploymentRecord employmentRecord) {
            super(employmentRecord.getFromM(),employmentRecord.getFromY(),employmentRecord.getToM(),employmentRecord.getToY(),employmentRecord.getCompany(),employmentRecord.getPosition(),employmentRecord.getSalary(), employmentRecord.getReasonForLeaving());
            this.fromTo = this.getFromM()+"/"+ this.getFromY() + " - " +this.getToM()+"/"+ this.getToY();
        }

        public EmploymentRecord getEmploymentRecord() {
            return employmentRecord;
        }

        public String getFromTo() {
            return fromTo;
        }
    }
}
