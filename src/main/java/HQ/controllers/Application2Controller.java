package HQ.controllers;

import HQ.controllers.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import models.PersonalInformation;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Application2Controller extends AbstractApplicationController {
    private MainController mainCtrl;
    private GridPane mainPane;
    @FXML
    private Label thaiNameLabel, engNameLabel, addressLabel, telLabel, emailLabel, birthAndAgeLabel, weightHeightLabel, nationalityLabel, placeOfBirthLabel, religionLabel, idLabel, professionalLabel, militaryLabel, maritalLabel;
    @FXML
    private void initialize(){

    }
    @FXML
    public void showPicture(){

    }

    public GridPane getMainPane() {
        return mainPane;
    }

    public void setMainPane(GridPane mainPane) {
        this.mainPane = mainPane;
    }

    public void setMainCtrl(MainController mainCtrl) {
        this.mainCtrl = mainCtrl;
    }

    public void showInfo() {
        PersonalInformation personalInformation = application.getPersonalInformation();
        this.thaiNameLabel.setText(personalInformation.getfNameTH()+ " " + personalInformation.getlNameTH());
        this.engNameLabel.setText(personalInformation.getfNameEN() + " "+ personalInformation.getlNameEN());
        this.addressLabel.setText(personalInformation.getAddress());
        this.telLabel.setText(personalInformation.getPhoneNumber());
        Calendar calendar  = new GregorianCalendar();
        int age = calendar.get(Calendar.YEAR)-personalInformation.getDateOfBirth().get(Calendar.YEAR);
        this.birthAndAgeLabel.setText(personalInformation.getDateOfBirth().get(Calendar.DATE)+"/"+personalInformation.getDateOfBirth().get(Calendar.MONTH)+"/" + personalInformation.getDateOfBirth().get(Calendar.YEAR)+ " Age: "+ age);
        this.weightHeightLabel.setText("Weight: " + personalInformation.getWeight() + " ,Height: " + personalInformation.getHeigth());
        this.nationalityLabel.setText("Race: "+ personalInformation.getRace()+ " ,Nationality: " + personalInformation.getNationality());
        this.placeOfBirthLabel.setText(personalInformation.getPlaceOfBirth());
        this.religionLabel.setText(personalInformation.getReligion());
        this.idLabel.setText(personalInformation.getID());
        this.professionalLabel.setText(personalInformation.getProfNo());
        this.militaryLabel.setText(personalInformation.getMilitaryStatus());
        this.maritalLabel.setText(personalInformation.getMaritalStatus());
    }
}
