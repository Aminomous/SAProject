package HQ.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    @FXML
    private CheckBox filter0;
    @FXML
    private CheckBox filter1;
    @FXML
    private CheckBox filter2;
    @FXML
    private CheckBox filter3;
    @FXML
    private CheckBox filter4;
    @FXML
    private CheckBox filter5;
    @FXML
    private CheckBox filter6;
    @FXML
    private CheckBox filter7;

    private boolean isFilterOn;

    public void initialize(){
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
                if(item.getLatestStatusStr().contains(text)) {
                    tempApplications.add(item);
                }
            }
        }
        else {
            for (Application item : applications){
                tempApplications.add(item);
            }
        }
        mainCtrl.getApplicantTableCtrl().showData(tempApplications);
    }

    public void showFilteredApplication(){
        ArrayList<Application> tempApplications = mainCtrl.getApplications() ;
        ArrayList<Application> filteredApplications = new ArrayList<Application>() ;
//        if (filter0.isSelected()){
//            filteredApplications = checkFilterN(filteredApplications,tempApplications,0);
//        }
//        if (filter1.isSelected()){
//            filteredApplications = checkFilterN(filteredApplications,tempApplications,1);
//        }
//        if (filter2.isSelected()){
//            filteredApplications = checkFilterN(filteredApplications,tempApplications,2);
//        }
        if (filter3.isSelected()){
            filteredApplications = checkFilterN(filteredApplications,tempApplications,3);
        }
        if (filter4.isSelected()){
            filteredApplications = checkFilterN(filteredApplications,tempApplications,4);
        }
        if (filter5.isSelected()){
            filteredApplications = checkFilterN(filteredApplications,tempApplications,5);
        }
        if (filter6.isSelected()) {
            filteredApplications = checkFilterN(filteredApplications, tempApplications, 6);
        }
        if (filter7.isSelected()) {
            filteredApplications = checkFilterN(filteredApplications, tempApplications, 7);
        }
        if(!(filter3.isSelected() || filter4.isSelected() || filter5.isSelected() || filter6.isSelected() || filter7.isSelected())) {
            isFilterOn = false;
            for (int i=0 ;i<=5;i++){
                filteredApplications = checkFilterN(filteredApplications, tempApplications, i);
            }
        }
        mainCtrl.getApplicantTableCtrl().showData(filteredApplications);
    }


    private ArrayList<Application> checkFilterN(ArrayList<Application> filtered,ArrayList<Application> apps,int n) {
        for (Application app : apps) {
            if (!(filtered.contains(app))) {
                if (n <= 5) {
                    if ((app.getLatestStatus() == n) && (app.getApplicationStatus6()==0)) { filtered.add(app); }
                } else {
                    if ((n==6) && (app.getApplicationStatus6()== 1)){ filtered.add(app); }
                    else if ((n==7) && (app.getApplicationStatus6()== 2)){ filtered.add(app); }
                }
            }
        }
        return filtered;
    }
    @FXML
    private void handleApplyBtn(){
        isFilterOn = true;
        showFilteredApplication();
        mainCtrl.resetInfoSection();
    }

    @FXML
    private void handleClearFilterBtn(){
//        filter0.setSelected(false);
//        filter1.setSelected(false);
//        filter2.setSelected(false);
        filter3.setSelected(false);
        filter4.setSelected(false);
        filter5.setSelected(false);
        filter6.setSelected(false);
        filter7.setSelected(false);
        showFilteredApplication();
        mainCtrl.resetInfoSection();
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

    public boolean isFilterOn() {
        return isFilterOn;
    }
}
