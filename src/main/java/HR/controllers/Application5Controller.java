package HR.controllers;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import models.EmploymentRecord;
import models.LanguageAbility;

import java.util.ArrayList;

public class Application5Controller extends AbstractApplicationController{
    private MainController mainCtrl;
    @FXML
    private GridPane mainPane;
    @FXML
    private TableView<Application5Controller.LanguageData> langTable;
    @FXML
    private TableColumn langColumn, speakColumn, readColumn, writeColumn;

    @FXML
    private void initialize() {
        langColumn.setCellValueFactory(new PropertyValueFactory<LanguageData, String>("language"));
        speakColumn.setCellValueFactory(new PropertyValueFactory<LanguageData, String>("speak"));
        readColumn.setCellValueFactory(new PropertyValueFactory<LanguageData, String>("read"));
        writeColumn.setCellValueFactory(new PropertyValueFactory<LanguageData, String>("write"));

    }

    public GridPane getMainPane() {
        return mainPane;
    }

    public void setMainPane(GridPane mainPane) {
        this.mainPane = mainPane;
    }

    public void setMainCtrl(MainController mainCtrl) {
        this.mainCtrl = mainCtrl;
    }

    public void showInfo() {
        showData();
    }
    public void showData(){
        ObservableList temp = FXCollections.observableArrayList();
        ArrayList<LanguageAbility> languageAbilities = application.getLanguageAbilities();
       // temp.addAll(languageAbilities);
        for (LanguageAbility languageAbility: languageAbilities){
            temp.add(new Application5Controller.LanguageData(languageAbility));
        }
        langTable.setItems(temp);
    }


    public class LanguageData extends LanguageAbility{
        private String speak;
        private String read;
        private String write;
        private LanguageAbility languageAbility;
        LanguageData(LanguageAbility languageAbility) {
            super(languageAbility.getLanguage(), languageAbility.getSpeaking(), languageAbility.getReading(), languageAbility.getWriting());
            if(this.getReading() == 0 || this.getSpeaking() == 0 || this.getWriting()==0){
                this.speak = "พอใช้";
                this.read = "พอใช้";
                this.write = "พอใช้";
            }else if(this.getReading() == 1 || this.getSpeaking() == 1 || this.getWriting()==1){
                this.speak = "ดี";
                this.read = "ดี";
                this.write = "ดี";
            }else if(this.getReading() == 2 || this.getSpeaking() == 2 || this.getWriting()==2){
                this.speak = "ดีมาก";
                this.read = "ดีมาก";
                this.write = "ดีมาก";
            }
        }

        public String getSpeak() {
            return speak;
        }

        public String getRead() {
            return read;
        }

        public String getWrite() {
            return write;
        }

        public LanguageAbility getLanguageAbility() {
            return languageAbility;
        }
    }
}
