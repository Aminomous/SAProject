package HR.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.FlowPane;
import models.Application;

public class StatusChangeController {
    private MainController mainCtrl;
    private FlowPane mainPane;
    private Application application;

    @FXML
    private CheckBox status1, status2, status3, status4, status5;

    public void initialize() {

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
        cancel();

    }

    @FXML
    public void cancel() {
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
