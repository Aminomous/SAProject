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
    private TableView<ApplicantData> applicantTable;
    @FXML
    private TableColumn IDColumn, firstnameColumn, lastnameColumn, positionColumn, statusColumn;
    private ArrayList<Application> applications;
    private ObservableList tableViewData;

    @FXML
    private void initialize() {
        IDColumn.setCellValueFactory(new PropertyValueFactory<HR.controllers.ApplicantTableController.ApplicantData, String>("id"));
        firstnameColumn.setCellValueFactory(new PropertyValueFactory<HR.controllers.ApplicantTableController.ApplicantData, String>("firstName"));
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<HR.controllers.ApplicantTableController.ApplicantData, String>("lastName"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<HR.controllers.ApplicantTableController.ApplicantData, String>("position"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<HR.controllers.ApplicantTableController.ApplicantData, String>("status"));

        tableViewData = FXCollections.observableArrayList();

        applicantTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ApplicantData>() {
            public void changed(ObservableValue<? extends ApplicantData> observable, ApplicantData oldValue, ApplicantData newValue) {
                if (newValue == null) {
                    newValue = oldValue;
                }

                mainCtrl.showApplicantInfo(newValue.getRefnum());
            }
        });
    }

    public void refreshTable(boolean isFilterOn) {
        if (isFilterOn) {
            mainCtrl.getApplicantFilterCtrl().showFilteredApplication();
        } else {
            this.showData();
        }
    }

    public void showData() {
        applicantTable.getItems().removeAll();
        tableViewData.clear();
        tableViewData = FXCollections.observableArrayList();

        for (Application app : applications) {
            if (app.getApplicationStatus6() == 0) {
                PersonalInformation tempInformation = app.getPersonalInformation();
                tableViewData.add(new ApplicantData(tempInformation.getID(), tempInformation.getfNameTH(), tempInformation.getlNameTH(), app.getPosition1(), app.getLatestStatus(), app.getApplicationStatus6(), app.getRefnum()));
            }
        }
        applicantTable.setItems(tableViewData);
    }

    public void showData(ArrayList<Application> apps) {
        applicantTable.getItems().removeAll();
        tableViewData.clear();
        tableViewData = FXCollections.observableArrayList();
        for (Application app : apps) {
            PersonalInformation tempInformation = app.getPersonalInformation();
            tableViewData.add(new ApplicantData(tempInformation.getID(), tempInformation.getfNameTH(), tempInformation.getlNameTH(), app.getPosition1(), app.getLatestStatus(), app.getApplicationStatus6(), app.getRefnum()));
        }
        applicantTable.setItems(tableViewData);
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

    public void setApplications(ArrayList<Application> applications) {
        this.applications = applications;
    }


    public class ApplicantData {
        private SimpleStringProperty id;
        private SimpleStringProperty firstName;
        private SimpleStringProperty lastName;
        private SimpleStringProperty position;
        private SimpleStringProperty status;
        private int refnum;

        ApplicantData(String id, String firstName, String lastName, String position, int status, int status2, int refnum) {
            this.id = new SimpleStringProperty(id);
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
            this.position = new SimpleStringProperty(position + "");
            this.refnum = refnum;
            this.status = new SimpleStringProperty();
            if (status2 != 0) {
                setStatus(status2 + 5);
            } else {
                setStatus(status);
            }
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

        public String getStatus() {
            return status.get();
        }

        public SimpleStringProperty statusProperty() {
            return status;
        }

        public void setStatus(int status) {
            switch (status) {
                case 1:
                    this.status.set("ผ่านการทดสอบ");
                    break;
                case 2:
                    this.status.set("ผ่านการสัมภาษณ์รอบที่ 1");
                    break;
                case 3:
                    this.status.set("ผ่านการสัมภาษณ์รอบที่ 2");
                    break;
                case 4:
                    this.status.set("ยืนยันการผ่านสัมภาษณ์");
                    break;
                case 5:
                    this.status.set("ผ่านการตรวจสอบร่างกาย");
                    break;
                case 6:
                    this.status.set("ผ่านการพิจารณา");
                    break;
                case 7:
                    this.status.set("ไม่ผ่านการพิจารณา");
                    break;
                default:
                    this.status.set("รอการเปลี่ยนแปลงสถานะ");
                    break;
            }
        }

        public String getPosition() {
            return position.get();
        }

        public SimpleStringProperty positionProperty() {
            return position;
        }

        public void setPosition(String position) {
            this.position.set(position);
        }

        public int getRefnum() {
            return refnum;
        }


        @Override
        public String toString() {
            return String.format("ID: %s\nNAME:%s %s\nPOSITION: %s\nSTATUS: %s", getId(), getFirstName(), getLastName(), getPosition(), getStatus());
        }
    }
}

