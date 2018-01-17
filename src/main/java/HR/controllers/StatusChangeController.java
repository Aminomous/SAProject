package HR.controllers;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
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

        acceptButtonDisabling();
    }

    public void start() {
        status1.setDisable(true);
        status2.setDisable(true);
        status3.setDisable(true);
        status4.setDisable(true);
        status5.setDisable(true);

        int latestStatus = application.getLatestStatus();
        if (latestStatus == 0) {
            status1.setDisable(false);
        } else if (latestStatus == 1) {
            status1.setSelected(true);
            status1.setDisable(false);
            status2.setDisable(false);
        } else if (latestStatus == 2) {
            status1.setSelected(true);
            status2.setSelected(true);
            status2.setDisable(false);
            status3.setDisable(false);
        } else if (latestStatus == 3) {
            status1.setSelected(true);
            status2.setSelected(true);
            status3.setSelected(true);
            status3.setDisable(false);
            status4.setDisable(false);
        } else if (latestStatus == 4) {
            status1.setSelected(true);
            status2.setSelected(true);
            status3.setSelected(true);
            status4.setSelected(true);
            status4.setDisable(false);
            status5.setDisable(false);
        } else if (latestStatus == 5) {
            status1.setSelected(true);
            status2.setSelected(true);
            status3.setSelected(true);
            status4.setSelected(true);
            status5.setSelected(true);
            status5.setDisable(false);
        }

    }

    private void acceptButtonDisabling(){
        acceptButton.setDisable(status5.isSelected());
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
