package HR.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class Application7Controller extends  AbstractApplicationController {
    private MainController mainCtrl;
    @FXML
    private GridPane mainPane;
    @FXML
    private TableView<HR.controllers.Application7Controller.ApprenticeshipData> apprenticeshipTable;
    @FXML
    private TableColumn fromToColumn, courseColumn, instituteColumn, certificateColumn;

    @FXML
    private void initialize() {

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

    }


    public class ApprenticeshipData {
        private SimpleStringProperty fromTo;
        private SimpleStringProperty course;
        private SimpleStringProperty institute;
        private SimpleStringProperty certificate;

        ApprenticeshipData(String fromTo, String course, String institute, String certificate) {
            this.fromTo = new SimpleStringProperty(fromTo);
            this.course = new SimpleStringProperty(course);
            this.institute = new SimpleStringProperty(institute);
            this.certificate = new SimpleStringProperty(certificate);
        }

        public void setFromTo(String fromTo) {
            this.fromTo.set(fromTo);
        }

        public String getFromTo() {
            return fromTo.get();
        }

        public void setCourse(String course) {
            this.course.set(course);
        }

        public String getCourse() {
            return course.get();
        }

        public void setInstitute(String institute) {
            this.institute.set(institute);
        }

        public String getInstitute() {
            return institute.get();
        }

        public void setCertificate(String certificate) {
            this.certificate.set(certificate);
        }

        public String getCertificate() {
            return certificate.get();
        }
    }

}
