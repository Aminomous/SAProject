package HR.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

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

    }


    class LanguageData {
        private SimpleStringProperty lang;
        private SimpleStringProperty speak;
        private SimpleStringProperty read;
        private SimpleStringProperty write;

        LanguageData(String lang, String speak, String read, String write) {
            this.lang = new SimpleStringProperty(lang);
            this.speak = new SimpleStringProperty(speak);
            this.read = new SimpleStringProperty(read);
            this.write = new SimpleStringProperty(write);
        }

        public void setLang(String lang) {
            this.lang.set(lang);
        }

        public String getLang() {
            return lang.get();
        }

        public void setSpeak(String speak) {
            this.speak.set(speak);
        }

        public String getSpeak() {
            return speak.get();
        }

        public void setRead(String read) {
            this.read.set(read);
        }

        public String getRead() {
            return read.get();
        }

        public void setWrite(String write) {
            this.write.set(write);
        }

        public String getWrite() {
            return write.get();
        }

    }
}
