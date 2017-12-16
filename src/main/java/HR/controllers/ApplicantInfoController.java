package HR.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Application;
import models.PersonalInformation;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ApplicantInfoController {
    private MainController mainCtrl;
    @FXML
    private FlowPane mainPane;
    private Application application;
    @FXML
    private Button moreInfoButton, uploadInfoButton, changeStatusButton;
    @FXML
    private Label idLabel, nameLabel, telLabel, ageLabel;
    @FXML
    private Button imageButton;
    @FXML
    private void initialize() {
        Image test = new Image(getClass().getResourceAsStream("/asset/kiiroitori2.png"));
        imageButton.setGraphic(new javafx.scene.image.ImageView(test));

    }

    @FXML
    public void moreInfo() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HR/application.fxml"));
        stage.initOwner(mainPane.getScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        try {
            stage.setScene(new Scene((Parent) loader.load()));
            ApplicationController applicationCtrl = loader.getController();
            applicationCtrl.setApplication(this.application);
            applicationCtrl.showRef();
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void setUp(){
        PersonalInformation personalInformation = application.getPersonalInformation();
        this.idLabel.setText(personalInformation.getID());
        this.nameLabel.setText(personalInformation.getfNameTH()+  " "+ personalInformation.getlNameTH());
        this.telLabel.setText(personalInformation.getPhoneNumber());
        Calendar calendar  = new GregorianCalendar();
        int age = calendar.get(Calendar.YEAR)-personalInformation.getDateOfBirth().get(Calendar.YEAR);
        this.ageLabel.setText(age+"");
    }

    @FXML
    public void uploadInfo() {

    }

    @FXML
    public void changeStatus() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HR/changeStatus.fxml"));
        try {
            stage.setScene(new Scene((Parent) loader.load()));
            StatusChangeController statusCtrl = loader.getController();
            statusCtrl.setMainCtrl(mainCtrl);
            statusCtrl.setApplication(application);
            statusCtrl.start();
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainCtrl.refreshTable();
    }

    public void showData(Application app) {
        application = app;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Application getApplication() {
        return application;
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
