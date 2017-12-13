package HQ.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MainPaneController {

    private MainController mainCtrl;
    private FlowPane mainPane;
    @FXML
    private Menu loginStatus;
    @FXML
    private FlowPane leftPane, rightPane, rootPane;
    @FXML
    private AnchorPane reportPane;
    @FXML
    private GridPane mainPaneInner;

    public void exitProgram() {
        System.exit(0);
    }

    public FlowPane getMainPane() {
        return mainPane;
    }

    public void setMainPane(FlowPane mainPane) {
        this.mainPane = mainPane;
    }

    public FlowPane getLeftPane() {
        return leftPane;
    }

    public FlowPane getRightPane() {
        return rightPane;
    }

    public Menu getLoginStatus() {
        return loginStatus;
    }

    public void setMainCtrl(MainController mainCtrl) {
        this.mainCtrl = mainCtrl;
    }

    public GridPane getMainPaneInner() {
        return mainPaneInner;
    }
}
