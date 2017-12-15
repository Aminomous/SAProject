package HQ.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import models.Application;

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
