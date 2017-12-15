package HR.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Application6Controller extends AbstractApplicationController {
    private MainController mainCtrl;
    @FXML
    private GridPane mainPane;
    @FXML
    private Label carLabel, carIDLabel, motorLabel, motorIDLabel, hobbyLabel;
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
