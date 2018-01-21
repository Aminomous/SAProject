package HR.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import models.PersonalInformation;

public class Application9Controller extends AbstractApplicationController{
    private GridPane mainPane;
    @FXML
    private Label q1Label, q2Label, q3Label, q4Label, q5Label;
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
        PersonalInformation personalInformation = application.getPersonalInformation();
        if(personalInformation.isQ1()){
            this.q1Label.setText("เคย") ;
        }if (!personalInformation.isQ1()){
            this.q1Label.setText("ไม่เคย") ;
        }if(personalInformation.isQ2()){
            this.q2Label.setText("เคย") ;
        }if (!personalInformation.isQ2()){
            this.q2Label.setText("ไม่เคย") ;
        }if(personalInformation.isQ3()){
            this.q3Label.setText("เคย") ;
        }if (!personalInformation.isQ3()){
            this.q3Label.setText("ไม่เคย") ;
        } if(personalInformation.isQ4()){
            this.q4Label.setText("เคย") ;
        } if (!personalInformation.isQ4()){
            this.q4Label.setText("ไม่เคย") ;
        }
        this.q5Label.setText(personalInformation.getQ5());


    }
}
