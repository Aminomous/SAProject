package HR.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Application;

import java.io.IOException;
import java.util.GregorianCalendar;

public class ApplicantInfoController {
    private MainController mainCtrl;
    private FlowPane mainPane;
    private Application application;
    @FXML
    private Button moreInfoButton, uploadInfoButton, changeStatusButton;

    @FXML
    private void initialize(){

    }
    @FXML
    public void moreInfo(){
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
    @FXML
    public void uploadInfo(){

    }
    @FXML
    public void changeStatus() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HR/changeStatus.fxml"));
        stage.initModality(Modality.APPLICATION_MODAL);
        try {
            stage.setScene(new Scene((Parent) loader.load()));
            StatusChangeController statusChangeCtrl = loader.getController();
            statusChangeCtrl.setApplication(this.application);
            stage.showAndWait();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showData(Application app){
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
