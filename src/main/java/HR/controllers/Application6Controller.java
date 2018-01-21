package HR.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import models.PersonalInformation;

public class Application6Controller extends AbstractApplicationController {
    @FXML
    private GridPane mainPane;
    @FXML
    private Label comLabel, carLabel, carIDLabel, motorLabel, motorIDLabel, hobbyLabel;
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
        String word = "";
        String excel = "";
        String pww = "";
        if (personalInformation.getWord() == 0 || personalInformation.getExcel() == 0 || personalInformation.getPowerpoint() == 0) {
            word = "";
            excel = "";
            pww = "";
        } else if (personalInformation.getWord() > 0 || personalInformation.getExcel() > 0 || personalInformation.getPowerpoint() > 0) {
            word = "Word";
            excel = "Excel";
            pww = "Power point";
        }
        this.comLabel.setText(word + " " + excel + " " + pww);
        //car
        String isDrivecar = "";
        String isOwnCar = "";
        if (personalInformation.isDriveCar() || personalInformation.isOwnCar()){
            isDrivecar = "สามารถขับรถได้";
        isOwnCar = "มีรถส่วนตัว";
        }else{
            isDrivecar = "ไม่สามารถขับรถได้";
            isOwnCar = "ไม่มีรถส่วนตัว";
        }
        this.carLabel.setText(isDrivecar + "   " + isOwnCar);

        //carId
        this.carIDLabel.setText(personalInformation.getDriveLicenseCar());

        //motorbike
        String isRideMotor ="";
        String isOwnMotor= "";
        if (personalInformation.isRideMotocycle() || personalInformation.isOwnMotocycle()){
            isRideMotor = "สามารถขี่มอเตอร์ไซด์ได้";
            isOwnMotor = "มีมอเตอร์ไซด์ส่วนตัว";
        }else{
            isRideMotor = "ไม่สามารถขี่มอเตอร์ไซด์ได้";
            isOwnMotor = "ไม่มีรมอเตอร์ไซด์ส่วนตัว";
        }
        this.motorLabel.setText(isRideMotor + "   " + isOwnMotor);

        //motorId
        this.motorIDLabel.setText(personalInformation.getDriveLicenseMotocycle());
        //hobby
        this.hobbyLabel.setText(personalInformation.getHobby());
    }
}
