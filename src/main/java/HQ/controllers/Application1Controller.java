package HQ.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Calendar;

public class Application1Controller extends AbstractApplicationController {
    @FXML
    private GridPane mainPane;
    @FXML
    private Label thaiNameLabel, engNameLabel, position1Label, position2Label, workerTypeLabel, shiftLabel, salaryLabel, startDateLabel, hospital1Label, hospital2Label, hospital3Label, hospital4Label, hospital5Label, hospital6Label, hospital7Label, hospital8Label, hospital9Label, hospital10Label;
    private ArrayList<Label> hospitals = new ArrayList<Label>();
    @FXML
    private void initialize(){
        hospitals.add(hospital1Label);
        hospitals.add(hospital2Label);
        hospitals.add(hospital3Label);
        hospitals.add(hospital4Label);
        hospitals.add(hospital5Label);
        hospitals.add(hospital6Label);
        hospitals.add(hospital7Label);
        hospitals.add(hospital8Label);
        hospitals.add(hospital9Label);
        hospitals.add(hospital10Label);


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
        if(application.getHospitals().size() >0){
            int count = application.getHospitals().size();
            for(int i = 0 ; i < count ;i++){
                hospitals.get(i).setText(application.getHospitals().get(i).getHospitalName());
            }
        }

    }

    public GridPane getMainPane() {
        return mainPane;
    }

    public void setMainPane(GridPane mainPane) {
        this.mainPane = mainPane;
    }

}
