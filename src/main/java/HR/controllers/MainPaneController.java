package HR.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class MainPaneController {

    private MainController mainCtrl;
    private GridPane mainPane;
    @FXML
    private BorderPane leftPanel;
    @FXML
    private FlowPane rightPanel;

    public GridPane getMainPane() { return mainPane; }
    public BorderPane getLeftPane() {
        return leftPanel;
    }
    public FlowPane getRightPane() {
        return rightPanel;
    }
    public void setMainPane(GridPane mainPane) {
        this.mainPane = mainPane;
    }

    public void setMainCtrl(MainController mainCtrl) {
        this.mainCtrl = mainCtrl;
    }

}
