package HR.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import models.LanguageAbility;
import models.ReferencePerson;

import java.util.ArrayList;

public class Application12Controller extends AbstractApplicationController {
    private MainController mainCtrl;
    @FXML
    private GridPane mainPane;
    @FXML
    private TableView<ReferencePerson> notRelativeTable;
    @FXML
    private Label relativeWorkerLabel, additionalLabel;
    @FXML
    private TableColumn nameColumn, relationshipColumn;
    @FXML
    private TableColumn noColumn, name2Column;

    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<ReferencePerson, String>("name"));
        relationshipColumn.setCellValueFactory(new PropertyValueFactory<ReferencePerson, String>("relationship"));
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

    public void showData(){
        ObservableList temp = FXCollections.observableArrayList();
        ArrayList<ReferencePerson> referencePeople = application.getReferencePeople();
        temp.addAll(referencePeople);
        notRelativeTable.setItems(temp);
    }

    public void showInfo() {
        showData();
        this.relativeWorkerLabel.setText("ชื่อเพื่อนหรือญาติที่ทำงานอยู่ในเครือโรงพยาบาลเปาโล :" + application.getRelaticeWorkInHospital());
        this.additionalLabel.setText("บันทึกเพิ่มเติม : " + application.getAdditionalInformation() );
    }

    public class RelativeData {
        private SimpleStringProperty no;
        private SimpleStringProperty name2;


        RelativeData(int no, String name2) {
            this.name2 = new SimpleStringProperty(name2);
            this.no = new SimpleStringProperty(no+ "");
        }

        public void setNo(String no) {
            this.no.set(no);
        }

        public void setName2(String name2) {
            this.name2.set(name2);
        }

        public String getName2() {
            return name2.get();
        }

        public String getNo() {
            return no.get();
        }
    }
}
