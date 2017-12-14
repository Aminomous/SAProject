package HR.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class ApplicantTableController {
    private MainController mainCtrl;
    private FlowPane mainPane;
    @FXML
    private TableColumn idColumn, firstnameColumn, lastnameColumn, positionColoumn, statusColumn;
    public void initialize(){

    }

    class ApplicantData{
        private SimpleStringProperty id;
        private SimpleStringProperty firstName;
        private SimpleStringProperty lastName;
        private SimpleStringProperty position;
        private SimpleStringProperty status;

        ApplicantData(String id, String firstName, String lastName, String position, String status) {
            this.id = new SimpleStringProperty(id);
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
            this.position = new SimpleStringProperty(position);
            this.status = new SimpleStringProperty(status);
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


    public FlowPane getMainPane() {
        return mainPane;
    }

    public void setMainPane(FlowPane mainPane) {
        this.mainPane = mainPane;
    }

    public void setMainCtrl(MainController mainCtrl) {
        this.mainCtrl = mainCtrl;
    }
}
