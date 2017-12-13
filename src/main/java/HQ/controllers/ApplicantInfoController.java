package HQ.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class ApplicantInfoController {
    private MainController mainCtrl;
    private FlowPane mainPane;
    @FXML
    private Button moreInfoButton, uploadInfoButton, changeStatusButton;

    public void initialize() {

    }

    public void moreInfo() {

    }

    public void uploadInfo() {

    }

    public void changeStatus() {

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
