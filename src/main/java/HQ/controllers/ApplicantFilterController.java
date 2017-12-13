package HQ.controllers;

import javafx.scene.layout.FlowPane;

public class ApplicantFilterController {
    private MainController mainCtrl;
    private FlowPane mainPane;

    public void initialize() {


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
