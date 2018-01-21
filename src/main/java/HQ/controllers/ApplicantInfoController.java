package HQ.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Application;
import models.PersonalInformation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    }

    @FXML
    public void moreInfo() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HQ/application.fxml"));
        stage.initOwner(mainPane.getScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        try {
            stage.setScene(new Scene((Parent) loader.load()));
            ApplicationController applicationCtrl = loader.getController();
            applicationCtrl.setApplication(this.application);
            applicationCtrl.setMainCtrl(mainCtrl);
            applicationCtrl.showRef();
            stage.showAndWait();
            if (application.getLatestStatus() < 3){
                mainCtrl.resetInfoSection();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setUp() {
        BufferedImage img;
        try {
            img = ImageIO.read(new ByteArrayInputStream(mainCtrl.getApplicationService().getApplicantPhoto(application)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image test = new Image(new ByteArrayInputStream(mainCtrl.getApplicationService().getApplicantPhoto(application)), 100, 100, false, false);
        imageButton.setGraphic(new javafx.scene.image.ImageView(test));
        imageButton.prefHeight(100);
        imageButton.prefWidth(100);
        imageButton.setMaxWidth(100);
        imageButton.setMaxHeight(100);

        PersonalInformation personalInformation = application.getPersonalInformation();
        this.idLabel.setText(personalInformation.getID());
        this.nameLabel.setText(personalInformation.getfNameTH() + " " + personalInformation.getlNameTH());
        this.telLabel.setText(personalInformation.getPhoneNumber());
        Calendar calendar = new GregorianCalendar();
        int age = calendar.get(Calendar.YEAR) - personalInformation.getDateOfBirth().get(Calendar.YEAR);
        this.ageLabel.setText(age + "");
    }

    @FXML
    public void uploadInfo() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HQ/dataUpload.fxml"));
        try {
            stage.setScene(new Scene((Parent) loader.load()));
            DataUploadController dataUploadCtrl = loader.getController();
            dataUploadCtrl.setMainCtrl(mainCtrl);
            dataUploadCtrl.setApplication(application);
//            dataUploadCtrl.start();
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void changeStatus() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HQ/changeStatus.fxml"));
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
        mainCtrl.refreshTable(mainCtrl.getApplicantFilterCtrl().isFilterOn());
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
