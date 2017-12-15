package HR.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class Application8Controller extends AbstractApplicationController{
    private MainController mainCtrl;
    @FXML
    private GridPane mainPane;
    @FXML
    private TableView<HR.controllers.Application8Controller> familyTable;
    @FXML
    private TableColumn relationColumn, nameColumn, occupationColumn, ageColumn, addressColumn, telColumn;

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


    public class ApprenticeshipData {
        private SimpleStringProperty relation;
        private SimpleStringProperty name;
        private SimpleStringProperty age;
        private SimpleStringProperty occupation;
        private SimpleStringProperty address;
        private SimpleStringProperty tel;

        ApprenticeshipData(String relation, String name, String age, String occupation, String address, String tel) {
            this.relation = new SimpleStringProperty(relation);
            this.name = new SimpleStringProperty(name);
            this.age = new SimpleStringProperty(age);
            this.occupation = new SimpleStringProperty(occupation);
            this.address = new SimpleStringProperty(address);
            this.tel = new SimpleStringProperty(tel);
        }

        public void setRelation(String relation) {
            this.relation.set(relation);
        }

        public String getRelation() {
            return relation.get();
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public String getName() {
            return name.get();
        }

        public void setAge(String age) {
            this.age.set(age);
        }

        public String getAge() {
            return age.get();
        }

        public void setAddress(String address) {
            this.address.set(address);
        }

        public String getAddress() {
            return address.get();
        }

        public String getTel() {
            return tel.get();
        }

        public void setTel(String tel) {
            this.tel.set(tel);
        }

        public void setOccupation(String occupation) {
            this.occupation.set(occupation);
        }

        public String getOccupation() {
            return occupation.get();
        }
    }

}
