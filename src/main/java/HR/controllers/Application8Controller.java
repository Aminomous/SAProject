package HR.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import models.Apprenticeship;
import models.EmploymentRecord;
import models.FamilyDetail;

import java.util.ArrayList;

public class Application8Controller extends AbstractApplicationController{
    @FXML
    private GridPane mainPane;
    @FXML
    private TableView<HR.controllers.Application8Controller> familyTable;
    @FXML
    private TableColumn relationColumn, nameColumn, occupationColumn, ageColumn, addressColumn, telColumn;

    @FXML
    private void initialize() {
        relationColumn.setCellValueFactory(new PropertyValueFactory<FamilyData, String>("status"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<FamilyData, String>("name"));
        occupationColumn.setCellValueFactory(new PropertyValueFactory<FamilyData, String>("occupation"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<FamilyData, String>("age"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<FamilyData, String>("address"));
        telColumn.setCellValueFactory(new PropertyValueFactory<FamilyData, String>("phoneNumber"));
    }

    public GridPane getMainPane() {
        return mainPane;
    }

    public void setMainPane(GridPane mainPane) {
        this.mainPane = mainPane;
    }

    public void showData(){
        ObservableList temp = FXCollections.observableArrayList();
        ArrayList<FamilyDetail> familyDetails = application.getFamilyDetails();
        for (FamilyDetail familyDetail: familyDetails){
            temp.add(new FamilyData(familyDetail));

        }
        familyTable.setItems(temp);
    }

    public void showInfo() {
        showData();
    }


    public class FamilyData extends FamilyDetail{
        private String name;
        private FamilyDetail familyDetail;
        FamilyData(FamilyDetail familyDetail) {
            super(familyDetail.getStatus(), familyDetail.getFirstName(), familyDetail.getLastName(), familyDetail.getAge(), familyDetail.getAddress(),familyDetail.getOccupation(),familyDetail.getPhoneNumber());
            this.name = this.getFirstName()+ " "+ this.getLastName();
        }

        public String getName() {
            return name;
        }

        public FamilyDetail getFamilyDetail() {
            return familyDetail;
        }
    }



}
