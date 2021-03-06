package HR.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import models.Application;

import java.io.IOException;
import java.util.ArrayList;

public class ApplicationController {
    private MainController mainCtrl;
    private Application application;
    private ArrayList<GridPane> panes = new ArrayList<GridPane>();
    private Application1Controller application1Ctrl ,application2Ctrl;
    private ArrayList<AbstractApplicationController> controllers = new ArrayList<AbstractApplicationController>();
    private GridPane presentPane;
    private int paneStatus = 0;
    @FXML
    private GridPane mainPane;
    @FXML
    private Label refNumLabel;
    @FXML
    private Button nextBtn, backBtn;

    @FXML
    private void initialize() throws IOException {
        for (int i = 1; i < 14; i++) {
            FXMLLoader paneLoader = new FXMLLoader(getClass().getResource("/HR/application" + i + ".fxml"));
            GridPane pane = paneLoader.load();
            AbstractApplicationController controller = paneLoader.getController();
            controllers.add(controller);
            panes.add(pane);
        }

        showPage();
        this.backBtn.setVisible(false);
    }

    public void showRef(){
        this.refNumLabel.setText("Ref. number:  " +application.getRefnum());
        for (AbstractApplicationController controller: controllers) {
            controller.setApplication(application);
            controller.setMainController(mainCtrl);
            controller.showInfo();
        }
    }


    private void showPage() {
        this.mainPane.getChildren().remove(this.presentPane);
        this.presentPane = panes.get(paneStatus);
        this.mainPane.add(this.presentPane, 0, 1);
    }

    @FXML
    public void next() {
        if (paneStatus < 12) {
            paneStatus++;
            showPage();
        }
        if (paneStatus == 12) {
            this.nextBtn.setVisible(false);
        }
        this.backBtn.setVisible(true);
    }
    @FXML
    public void back(){
        if (paneStatus > 0) {
            paneStatus--;
            showPage();
        }
        if (paneStatus == 0) {
            this.backBtn.setVisible(false);
        }
        this.nextBtn.setVisible(true);
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Application getApplication() {
        return application;
    }

    public GridPane getMainPane() {
        return mainPane;
    }

    public void setMainCtrl(MainController mainCtrl) {
        this.mainCtrl = mainCtrl;
    }
}
