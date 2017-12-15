package HQ.controllers;

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
//        status1.setDisable(true);
//        status2.setDisable(true);
//        status3.setDisable(true);
//        status4.setDisable(true);
//        status5.setDisable(true);
    }

    public void start(){

    }

    @FXML
    public void confirm() {
        if (status1.isSelected()) {
            System.out.println("WORK1");
            application.setApplicationStatus1(true);
        }else{
            application.setApplicationStatus1(false);
        }
        if (status2.isSelected()) {
            System.out.println("WORK2");
            application.setApplicationStatus2(true);
        }else{
            application.setApplicationStatus2(false);
        }
        if (status3.isSelected()) {
            System.out.println("WORK3");
            application.setApplicationStatus3(true);
        }else{
            application.setApplicationStatus3(false);
        }
        if (status4.isSelected()) {
            System.out.println("WORK4");
            application.setApplicationStatus4(true);
        }else{
            application.setApplicationStatus4(false);
        }
        if (status5.isSelected()) {
            System.out.println("WORK5");
            application.setApplicationStatus5(true);
        }else{
            application.setApplicationStatus5(false);
        }
        cancel();

    }

    @FXML
    public void cancel() {
        this.status1.getScene().getWindow().hide();
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

    public Application getApplication(){
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
