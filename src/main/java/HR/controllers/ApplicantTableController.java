package HR.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class ApplicantTableController {
    private MainController mainCtrl;
    private FlowPane mainPane;
    @FXML
    private TableColumn idColumn, firstnameColumn, lastnameColumn, positionColoumn, statusColumn;
    public void initialize(){


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
