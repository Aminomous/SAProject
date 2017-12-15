package HR.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import models.Application;
import models.PersonalInformation;

import java.util.ArrayList;

public class ApplicantTableController {
    private MainController mainCtrl;
    private FlowPane mainPane;
    @FXML
    private TableView<HR.controllers.ApplicantTableController.ApplicantData> applicantTable;
    @FXML
    private TableColumn IDColumn, firstnameColumn, lastnameColumn, positionColumn, statusColumn;
    private ArrayList<Application> applications;

    @FXML
    private void initialize() {
        IDColumn.setCellValueFactory(new PropertyValueFactory<HR.controllers.ApplicantTableController.ApplicantData, String>("id"));
        firstnameColumn.setCellValueFactory(new PropertyValueFactory<HR.controllers.ApplicantTableController.ApplicantData, String>("firstName"));
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<HR.controllers.ApplicantTableController.ApplicantData, String>("lastName"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<HR.controllers.ApplicantTableController.ApplicantData, String>("position"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<HR.controllers.ApplicantTableController.ApplicantData, String>("status"));

        applicantTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<HR.controllers.ApplicantTableController.ApplicantData>() {
            public void changed(ObservableValue<? extends HR.controllers.ApplicantTableController.ApplicantData> observable, HR.controllers.ApplicantTableController.ApplicantData oldValue, HR.controllers.ApplicantTableController.ApplicantData newValue) {
               // System.out.println(observable.getValue());
                mainCtrl.showApplicantInfo(observable.getValue().getId());
            }
        });
    }

    public void showData(){
        applications = mainCtrl.getApplications();
        ObservableList temp = FXCollections.observableArrayList();
        for (Application app:applications){
            PersonalInformation tempInformation = app.getPersonalInformation();
            temp.add(new HR.controllers.ApplicantTableController.ApplicantData(tempInformation.getID(), tempInformation.getfNameTH(), tempInformation.getlNameTH(), app.getPosition1(), app.getLatestStatus()));
        }
        applicantTable.setItems(temp);
    }


    public FlowPane getMainPane() {
        return mainPane;
    }

    public void setMainPane(FlowPane mainPane) {
        this.mainPane = mainPane;
    }

    public void setMainCtrl(MainController mainCtrl) {
        this.mainCtrl = mainCtrl;
    }


    public class ApplicantData{
        private SimpleStringProperty id;
        private SimpleStringProperty firstName;
        private SimpleStringProperty lastName;
        private SimpleStringProperty position;
        private SimpleStringProperty status;

        ApplicantData(String id, String firstName, String lastName, String position, int status) {
            this.id = new SimpleStringProperty(id);
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
            this.position = new SimpleStringProperty(position);
            this.status = new SimpleStringProperty("pass" + status);
        }

        public String getId() {
            return id.get();
        }

        public SimpleStringProperty idProperty() {
            return id;
        }

        public String getFirstName() {
            return firstName.get();
        }

        public SimpleStringProperty firstNameProperty() {
            return firstName;
        }

        public String getLastName() {
            return lastName.get();
        }

        public SimpleStringProperty lastNameProperty() {
            return lastName;
        }

        public String getPosition() {
            return position.get();
        }

        public SimpleStringProperty positionProperty() {
            return position;
        }

        public String getStatus() {
            return status.get();
        }

        public SimpleStringProperty statusProperty() {
            return status;
        }

        public void setStatus(String status) {
            this.status.set(status);
        }
    }
}
