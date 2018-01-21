package HQ.controllers;

import HQ.controllers.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Application;

import java.io.File;
import java.io.FileNotFoundException;

public class DataUploadController {
    private MainController mainCtrl;
    private Application application;
    private File file;

    @FXML
    private Button selectFileButton;
    @FXML
    private TextArea descriptionBox;
    @FXML
    private RadioButton applicantPhoto, applicantDocument;
    @FXML
    private Label fileDestination;


    @FXML
    public void initialize() {
        descriptionBox.setPromptText("insert file description here");

        ToggleGroup buttonGroup = new ToggleGroup();
        applicantPhoto.setToggleGroup(buttonGroup);
        applicantDocument.setToggleGroup(buttonGroup);

    }

    @FXML
    private void selectFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select file to upload.");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All File", "*.*"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpeg", "*.jpg"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"));
        file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            fileDestination.setText(file.getPath());
        } else {
            fileDestination.setText("...");
        }
    }


    @FXML
    public void confirm() throws FileNotFoundException {
        Alert alert = new Alert(Alert.AlertType.NONE);
        if (applicantDocument.isSelected() || applicantPhoto.isSelected()) {
            if (file != null) {

//            FileOutputStream fos = new FileOutputStream(file.getPath());
//            mainCtrl.getApplicationService().upload(application, descriptionBox.getText(), fileContent, applicantPhoto.isSelected()?"Photo":"Document");

                mainCtrl.getApplicationService().upload(application, descriptionBox.getText(), applicantPhoto.isSelected() ? "Photo" : "Document", file);

            } else {
                alert.setAlertType(Alert.AlertType.WARNING);
                alert.setHeaderText("Warning");
                alert.setContentText("NO FILE HAS BEEN UPLOADED");
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.showAndWait();
            }
            closeWindow();
        }else{
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please specify document type");
            alert.setHeaderText("ERROR");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.show();
        }
    }

    @FXML
    public void closeWindow() {
        selectFileButton.getScene().getWindow().hide();
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public void setMainCtrl(MainController mainCtrl) {
        this.mainCtrl = mainCtrl;
    }
}
