package HR.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class Application10Controller extends AbstractApplicationController{
    private MainController mainCtrl;
    @FXML
    private GridPane mainPane;
    @FXML
    private TableView<HR.controllers.Application10Controller.OtherData> otherTable;
    @FXML
    private TableColumn jobAdvertiseColumn, infoColumn;

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


    public class OtherData {
        private SimpleStringProperty jobAdvertise;
        private SimpleStringProperty info;


        OtherData(String jobAdvertise, String info) {
            this.jobAdvertise = new SimpleStringProperty(jobAdvertise);
            this.info = new SimpleStringProperty(info);
        }

        public void setJobAdvertise(String jobAdvertise) {
            this.jobAdvertise.set(jobAdvertise);
        }

        public String getJobAdvertise() {
            return jobAdvertise.get();
        }

        public void setInfo(String info) {
            this.info.set(info);
        }

        public String getInfo() {
            return info.get();
        }
    }
}
