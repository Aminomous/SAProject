package HQ.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import models.Application;

import java.io.IOException;

public class ApplicantInfoController {
    private MainController mainCtrl;
    private FlowPane mainPane;
    @FXML
    private Button moreInfoButton, uploadInfoButton, changeStatusButton;

    private Application application;

    public void initialize() {

    }

    public void moreInfo() {

    }

    public void uploadInfo() {

    }

    public void changeStatus() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HQ/changeStatus.fxml"));
        try {
            stage.setScene(new Scene((Parent) loader.load()));
            StatusChangeController statusCtrl = loader.getController();
            statusCtrl.setApplication(application);
            statusCtrl.start();
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainCtrl.refreshTable();

    }

    public void showData(Application app){
        application = app;
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
