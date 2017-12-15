package HR.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

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

    }
}
