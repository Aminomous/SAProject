package HR.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.Calendar;

public class Application1Controller extends AbstractApplicationController {
    @FXML
    private GridPane mainPane;
    @FXML
    private Label thaiNameLabel, engNameLabel, position1Label, position2Label, workerTypeLabel, shiftLabel, salaryLabel, startDateLabel, hospital1Label, hospital2Label, hospital3Label;
    @FXML
    private void initialize(){

    }

    @Override
    public void showInfo() {
        this.thaiNameLabel.setText(application.getPersonalInformation().getfNameTH()+ " " + application.getPersonalInformation().getlNameTH());
        this.engNameLabel.setText(application.getPersonalInformation().getfNameEN() + " "+ application.getPersonalInformation().getlNameEN());
        this.position1Label.setText(application.getPosition1());
        this.position2Label.setText(application.getPosition2());
        this.workerTypeLabel.setText(application.getWorkerType());
        if(application.isWorkInShift()){
            this.shiftLabel.setText("ทำงานเป็นกะได้");
        }else{
            this.shiftLabel.setText("ทำงานเป็นกะไม่ได้");
        }
        this.salaryLabel.setText(String.valueOf(application.getSalary()));
        this.startDateLabel.setText(application.getDate().get(Calendar.DATE)+ "/" + application.getDate().get(Calendar.MONTH) + "/" + application.getDate().get(Calendar.YEAR));
        System.out.println(application.getHospitals().size());
        //this.hospital1Label.setText(application.getHospitals().get(0).getHospitalName());
//        this.hospital2Label.setText(application.getHospitals().get(1).getHospitalName());
//        this.hospital3Label.setText(application.getHospitals().get(2).getHospitalName());

    }

    public GridPane getMainPane() {
        return mainPane;
    }

    public void setMainPane(GridPane mainPane) {
        this.mainPane = mainPane;
    }

}
