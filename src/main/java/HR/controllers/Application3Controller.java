package HR.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import models.Application;
import models.Education;
import models.PersonalInformation;

import java.util.ArrayList;
import java.util.Calendar;

public class Application3Controller extends  AbstractApplicationController {
    private MainController mainCtrl;
    private GridPane mainPane;
    @FXML
    private TableView<EducationData> educationTable;
    @FXML
    private TableColumn levelColumn, schoolColumn, degreeColumn, majorColumn, fromToColumn, gpaColumn;

    @FXML
    private void initialize(){
        levelColumn.setCellValueFactory(new PropertyValueFactory<EducationData, String>("level"));
        schoolColumn.setCellValueFactory(new PropertyValueFactory<EducationData, String>("instituteName"));
        degreeColumn.setCellValueFactory(new PropertyValueFactory<EducationData, String>("degreeOrCertificate"));
        majorColumn.setCellValueFactory(new PropertyValueFactory<EducationData, String>("major"));
        fromToColumn.setCellValueFactory(new PropertyValueFactory<EducationData, String>("fromTo"));
        gpaColumn.setCellValueFactory(new PropertyValueFactory<EducationData, Double>("GPA"));

    }
    public void showData() {
        ObservableList temp = FXCollections.observableArrayList();
        ArrayList<Education> educations = application.getEducation();
        for (Education education : educations) {
            temp.add(new EducationData(education));
        }
        educationTable.setItems(temp);
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

    public void showInfo() {
        showData();
    }

    public class EducationData extends Education {
        private String fromTo;
        private Education education;
        EducationData(Education education) {
            super(education.getLevel(), education.getInstituteName(), education.getDegreeOrCertificate(), education.getMajor(), education.getStudyFrom(), education.getStudyTo(), education.getGPA());
            this.fromTo = this.getStudyFrom().get(Calendar.YEAR) + " - " + this.getStudyTo().get(Calendar.YEAR);
        }

        public Education getEducation() {
            return education;
        }

        public String getFromTo() {
            return fromTo;
        }
    }
}
