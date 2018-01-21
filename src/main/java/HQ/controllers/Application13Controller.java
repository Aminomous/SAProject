package HQ.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.ApplicantDocument;
import models.Application;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application13Controller extends AbstractApplicationController {

    @FXML
    private TableView documentsTable;

    @FXML
    private TableColumn noColumn, descriptionColumn;

    @FXML
    public void initialize() {
        noColumn.setCellValueFactory(new PropertyValueFactory<ApplicantDocument, String>("no"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<ApplicantDocument, String>("description"));

        documentsTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Application13Controller.DocumentInfo>() {
            @Override
            public void changed(ObservableValue<? extends DocumentInfo> observable, DocumentInfo oldValue, DocumentInfo newValue) {
                if (newValue == null) {
                    newValue = oldValue;
                }

            }

            public void changed(ObservableValue<? extends ApplicantTableController.ApplicantData> observable, ApplicantTableController.ApplicantData oldValue, ApplicantTableController.ApplicantData newValue) {
                if (newValue == null) {
                    newValue = oldValue;
                }

                mainCtrl.showApplicantInfo(newValue.getId());
            }
        });
    }

    public void setMainCtrl(MainController mainCtrl) {
        this.mainCtrl = mainCtrl;
    }


    private void showData() {
        ObservableList tableViewData = FXCollections.observableArrayList();

        for (int i = 0; i < application.getDocuments().size(); i++) {
            ApplicantDocument doc = application.getDocuments().get(i);
            tableViewData.add(new DocumentInfo(doc.getId(), i, doc.getDescription()));
        }

        documentsTable.setItems(tableViewData);
    }

    @Override
    public void showInfo() {
        application.setDocuments(mainCtrl.getApplicationService().getDocuments(application));
        showData();
    }

    public void openFile() throws IOException {
        for (ApplicantDocument doc : application.getDocuments()) {
            if (doc.getId() == ((DocumentInfo) documentsTable.getSelectionModel().getSelectedItem()).getId()) {
                if (null == doc.getDocument()) {
//                    doc.setDocument(mainCtrl.getApplicationService().getFileFromDocument(doc));
//                    InputStream in = mainCtrl.getApplicationService().getFileFromDocument(doc);
                    byte[] buffer = mainCtrl.getApplicationService().getFileFromDocument(doc);
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Save file");
                    fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All File", "*.*"),
                            new FileChooser.ExtensionFilter("PNG", "*.png"),
                            new FileChooser.ExtensionFilter("JPG", "*.jpeg", "*.jpg"),
                            new FileChooser.ExtensionFilter("PDF", "*.pdf"));
                    File file = fileChooser.showSaveDialog(new Stage());

                    if (file != null) {
                        doc.setDocument(buffer);
                        FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());
                        fos.write(buffer);
                        fos.close();
//                        try {
//                            FileOutputStream out = new FileOutputStream(buffer);
//                            int b = 0;
//                            while ((b = in.read()) != -1) {
//                                out.write(b);
//                            }
//                            System.out.println("FINISH WRITING");
//                            in.close();
//                            out.close();
//                        } catch (FileNotFoundException e) {
//                            e.printStackTrace();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
                    }

                    Desktop desktop = Desktop.getDesktop();

                    try {
                        desktop.open(file);
                    } catch (IOException ex) {
                        Logger.getLogger(
                                ApplicantInfoController.class.getName()).log(
                                Level.SEVERE, null, ex
                        );
                    }
                }
            }
        }
    }

    public void setApplication(Application app) {
        application = app;
    }

    public class DocumentInfo {
        private SimpleStringProperty no;
        private SimpleStringProperty description;
        private int id;

        DocumentInfo(int id, int no, String desc) {
            this.id = id;
            this.description = new SimpleStringProperty(desc);
            this.no = new SimpleStringProperty(no + "");
        }

        public void setNo(String no) {
            this.no.set(no);
        }

        public void setDescription(String name2) {
            this.description.set(name2);
        }

        public String getDescription() {
            return description.get();
        }

        public String getNo() {
            return no.get();
        }

        public int getId() {
            return id;
        }
    }
}
