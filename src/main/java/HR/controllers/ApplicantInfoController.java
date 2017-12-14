package HR.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.GregorianCalendar;

public class ApplicantInfoController {
    private MainController mainCtrl;
    private FlowPane mainPane;
    @FXML
    private Button moreInfoButton, uploadInfoButton, changeStatusButton;

    public void initialize(){

    }
    public void moreInfo(){

    }
    public void uploadInfo(){

    }
    @FXML
    public void changeStatus() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HR/changeStatus.fxml"));
        stage.initModality(Modality.APPLICATION_MODAL);
        try {
            stage.setScene(new Scene((Parent) loader.load()));
            StatusChangeController statusChangeCtrl = loader.getController();
            stage.showAndWait();



        } catch (IOException e) {
            e.printStackTrace();
        }
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
