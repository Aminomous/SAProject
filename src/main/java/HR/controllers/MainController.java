package HR.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Application;
import services.DatabaseApplicationService;
import services.SQLiteConnector;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainController {

    private Stage stage;
    private String title = "HR";
    private MainPaneController mainPaneCtrl;
    private ApplicantTableController applicantTableCtrl;
    private ApplicantFilterController applicantFilterCtrl;
    private ApplicantInfoController applicantInfoCtrl;

    private DatabaseApplicationService applicationService;
    private ArrayList<Application> applications;

    public MainController(Stage stage) throws IOException, SQLException {
        this.stage = stage;
        //this.applicationService = new DatabaseApplicationService("//127.0.0.1:3306/saapplicationmanager", new MySQLConnector());
        this.applicationService = new DatabaseApplicationService("saDB.db", new SQLiteConnector());
        this.loadPane();
        loadData();
        applicantTableCtrl.showData();

    }


    public void start() {
        Pane mainPane = this.mainPaneCtrl.getMainPane();
        int w = (int) mainPane.getWidth();
        int h = (int) mainPane.getHeight();
        this.stage.setTitle(this.title);
        this.stage.setScene(new Scene(mainPane));
        this.stage.show();
    }


    private void loadPane() throws IOException {
        FXMLLoader mainPaneLoader = new FXMLLoader(getClass().getResource("/HR/mainProgram.fxml"));
        GridPane mainPane = mainPaneLoader.load();
        this.mainPaneCtrl = mainPaneLoader.getController();
        this.mainPaneCtrl.setMainPane(mainPane);
        this.mainPaneCtrl.setMainCtrl(this);

        FXMLLoader applicantTablePaneLoader = new FXMLLoader(getClass().getResource("/HR/applicantTable.fxml"));
        FlowPane applicantTablePane = applicantTablePaneLoader.load();
        this.applicantTableCtrl = applicantTablePaneLoader.getController();
        this.applicantTableCtrl.setMainPane(applicantTablePane);
        this.applicantTableCtrl.setMainCtrl(this);

        FXMLLoader applicantFilterPaneLoader = new FXMLLoader(getClass().getResource("/HR/applicantFilter.fxml"));
        FlowPane appicantFliterPane = applicantFilterPaneLoader.load();
        this.applicantFilterCtrl = applicantFilterPaneLoader.getController();
        this.applicantFilterCtrl.setMainPane(appicantFliterPane);
        this.applicantFilterCtrl.setMainCtrl(this);

        FXMLLoader applicantInfoPaneLoader = new FXMLLoader(getClass().getResource("/HR/applicantInfo.fxml"));
        FlowPane appicantInfoPane = applicantInfoPaneLoader.load();
        this.applicantInfoCtrl = applicantInfoPaneLoader.getController();
        this.applicantInfoCtrl.setMainPane(appicantInfoPane);
        this.applicantInfoCtrl.setMainCtrl(this);


        this.mainPaneCtrl.getLeftPane().setCenter(this.applicantTableCtrl.getMainPane());
        this.mainPaneCtrl.getRightPane().getChildren().add(this.applicantFilterCtrl.getMainPane());
        //this.mainPaneCtrl.getLeftPane().setBottom(this.applicantInfoCtrl.getMainPane());
    }

    public void showApplicantInfo(String id){
        this.mainPaneCtrl.getLeftPane().setBottom(this.applicantInfoCtrl.getMainPane());
        for (Application app: applications){
            if (app.getPersonalInformation().getID().equals(id)){
                this.applicantInfoCtrl.showData(app);
                this.applicantInfoCtrl.setApplication(app);
                break;
            }
        }
    }

    private void loadData() {
        applications = applicationService.getAll();
    }
    public ArrayList<Application> getApplications() {
        return applications;
    }
    public DatabaseApplicationService getApplicationService() {
        return applicationService;
    }


}
