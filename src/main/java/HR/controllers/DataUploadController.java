package HR.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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

        fileDestination.setText(file.getPath());
    }


    @FXML
    public void confirm() throws FileNotFoundException {
        if (file != null) {

//            FileOutputStream fos = new FileOutputStream(file.getPath());
//            mainCtrl.getApplicationService().upload(application, descriptionBox.getText(), fileContent, applicantPhoto.isSelected()?"Photo":"Document");

            mainCtrl.getApplicationService().upload(application, descriptionBox.getText(), applicantPhoto.isSelected()?"Photo":"Document", file);

        } else {
            System.out.println("NO FILE HAS BEEN UPLOADED");
        }
        System.out.println("DATAUPLOAD: CONFIRM WORK");
        closeWindow();
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
