package HR.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class Application12Controller extends AbstractApplicationController {
    private MainController mainCtrl;
    @FXML
    private GridPane mainPane;
    @FXML
    private TableView<Application12Controller.NotRelativeData> notRelativeTable;
    @FXML
    private TableView<Application12Controller.RelativeData> relativeTable;
    @FXML
    private TableColumn nameColumn, relationshipColumn;
    @FXML
    private TableColumn noColumn, name2Column;

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


    public class NotRelativeData {
        private SimpleStringProperty name;
        private SimpleStringProperty relationship;


        NotRelativeData(String name, String relationship) {
            this.name = new SimpleStringProperty(name);
            this.relationship = new SimpleStringProperty(relationship);
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public void setRelationship(String relationship) {
            this.relationship.set(relationship);
        }

        public String getName() {
            return name.get();
        }

        public String getRelationship() {
            return relationship.get();
        }
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
