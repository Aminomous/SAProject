package HQ.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import models.Application;

import java.util.ArrayList;

public class ApplicantFilterController {
    private MainController mainCtrl;

    private FlowPane mainPane;

    @FXML
    private ComboBox<String> filterBox;
    @FXML
    private TextField filterField;


    public void initialize(){
        System.out.println(filterBox);
        filterBox.getItems().addAll(" ", "id", "first name", "last name", "position", "status");
    }

    @FXML
    private void handleSearchBtn(){
        String text = filterField.getText();
        String filter = filterBox.getSelectionModel().getSelectedItem().toString();
        ArrayList<Application> applications= mainCtrl.getApplications();
        ArrayList<Application> tempApplications = new ArrayList<Application>();
        if (" ".equals(filter)){
            for (Application item : applications){
                tempApplications.add(item);
            }
        }
        else if ("id".equals(filter)){
            for (Application item : applications){
                if(item.getPersonalInformation().getID().contains(text)) {
                    tempApplications.add(item);
                }
            }
        }

        else if ("first name".equals(filter)){
            for (Application item : applications){
                if(item.getPersonalInformation().getfNameTH().contains(text)) {
                    tempApplications.add(item);
                }
            }
        }

        else if ("last name".equals(filter)){
            for (Application item : applications){
                if(item.getPersonalInformation().getlNameTH().contains(text)) {
                    tempApplications.add(item);
                }
            }
        }
        else if ("position".equals(filter)){
            for (Application item : applications){
                if(item.getPosition1().contains(text)) {
                    tempApplications.add(item);
                }
            }

        }

        else if ("status".equals(filter)){
            for (Application item : applications){
                if(item.getLastestStatusStr().contains(text)) {
                    tempApplications.add(item);
                }
            }
        }
        mainCtrl.getApplicantTableCtrl().showData(tempApplications);
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
