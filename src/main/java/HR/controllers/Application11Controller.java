package HR.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Application11Controller extends  AbstractApplicationController{
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

    public void showInfo() {
        //Qh1
        if(application.getQh1().size() >0){
            this.q1Label.setText(application.getQh1().get(0).getType() + " " + application.getQh1().get(0).getDetail());
        }

        this.q2Label.setText(application.getQH2());
        this.q3Label.setText(application.getQH3());

    }
}
