package HR.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Application11Controller extends  AbstractApplicationController{
    private MainController mainCtrl;
    private GridPane mainPane;
    @FXML
    private Label q1Label, q2Label, q3Label;
    @FXML
    private void initialize(){

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
