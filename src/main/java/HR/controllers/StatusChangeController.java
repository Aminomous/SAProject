package HR.controllers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import models.Application;

public class StatusChangeController {
    private MainController mainCtrl;
    private FlowPane mainPane;
    private Application application;

    @FXML
    private CheckBox status1, status2, status3, status4, status5;
    @FXML
    private GridPane container;
    @FXML
    private RadioButton acceptButton, declineButton;

    private ToggleGroup buttonGroup;

    public void initialize() {
        buttonGroup = new ToggleGroup();

        acceptButton.setToggleGroup(buttonGroup);
        declineButton.setToggleGroup(buttonGroup);
    }

    public void start() {
        CheckBox[] statuses = {status1, status2, status3, status4, status5};
        for (CheckBox status:statuses){
            status.setDisable(true);
        }

        int latestStatus = application.getLatestStatus();

        for (int i = 0; i< latestStatus; i++){
            statuses[i].setSelected(true);
            if (i == latestStatus-1){
                statuses[i].setDisable(false);
                statuses[Math.min(i+1, 4)].setDisable(false);
            }
        }

        if(application.getApplicationStatus6() == 0){
            acceptButton.setDisable(status5.isSelected());
        }else {
            if(application.getApplicationStatus6() == 1){
                acceptButton.setSelected(true);
            }else{
                declineButton.setSelected(true);
            }
            acceptButton.setDisable(true);
            declineButton.setDisable(true);
        }

    }

    @FXML
    public void confirm() {
        if (status1.isSelected()) {
            application.setApplicationStatus1(true);
        } else {
            application.setApplicationStatus1(false);
        }
        if (status2.isSelected()) {
            application.setApplicationStatus2(true);
        } else {
            application.setApplicationStatus2(false);
        }
        if (status3.isSelected()) {
            application.setApplicationStatus3(true);
        } else {
            application.setApplicationStatus3(false);
        }
        if (status4.isSelected()) {
            application.setApplicationStatus4(true);
        } else {
            application.setApplicationStatus4(false);
        }
        if (status5.isSelected()) {
            application.setApplicationStatus5(true);
        } else {
            application.setApplicationStatus5(false);
        }

        if (declineButton.isSelected()){
            application.setApplicationStatus6(2);
        }
        if (acceptButton.isSelected()){
            application.setApplicationStatus6(1);
        }


        mainCtrl.getApplicationService().update(application);
        closeWindow();

    }

    @FXML
    public void closeWindow() {
        this.status1.getScene().getWindow().hide();
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
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
