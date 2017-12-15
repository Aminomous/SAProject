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

    public void initialize(){
    }
    @FXML
    public void confirm(){
        if(status1.isSelected()){
            application.setApplicationStatus1(true);
        }if(status2.isSelected()){
            application.setApplicationStatus2(true);
        }if(status3.isSelected()){
            application.setApplicationStatus3(true);
        }if(status4.isSelected()){
            application.setApplicationStatus4(true);
        }if(status5.isSelected()){
            application.setApplicationStatus5(true);
        }

    }
    @FXML void cancel(){
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
}
