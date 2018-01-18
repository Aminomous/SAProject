package HR.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Application;
import services.DatabaseApplicationService;
import services.MySQLConnector;
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
//        this.applicationService = new DatabaseApplicationService("//10.2.60.249:3306/saapplicationmanager", new MySQLConnector());
        this.applicationService = new DatabaseApplicationService("saDB.db", new SQLiteConnector());
        this.loadPane();
        loadData();

    }


    public void start() {
        Pane mainPane = this.mainPaneCtrl.getMainPane();
        int w = (int) mainPane.getWidth();
        int h = (int) mainPane.getHeight();
        this.stage.setTitle(this.title);
        this.stage.setScene(new Scene(mainPane));
        this.stage.show();

        this.applicantTableCtrl.setApplications(applications);
        applicantTableCtrl.showData();
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
        FlowPane applicantFilterPane = applicantFilterPaneLoader.load();
        this.applicantFilterCtrl = applicantFilterPaneLoader.getController();
        this.applicantFilterCtrl.setMainPane(applicantFilterPane);
        this.applicantFilterCtrl.setMainCtrl(this);
//        this.applicantFilterCtrl.setTableCtrl(this.applicantTableCtrl);

        FXMLLoader applicantInfoPaneLoader = new FXMLLoader(getClass().getResource("/HR/applicantInfo.fxml"));
        FlowPane applicantInfoPane = applicantInfoPaneLoader.load();
        this.applicantInfoCtrl = applicantInfoPaneLoader.getController();
        this.applicantInfoCtrl.setMainPane(applicantInfoPane);
        this.applicantInfoCtrl.setMainCtrl(this);

        this.mainPaneCtrl.getLeftPane().setTop(this.applicantTableCtrl.getMainPane());
//        this.mainPaneCtrl.getLeftPane().setCenter(this.applicantTableCtrl.getMainPane());
        this.mainPaneCtrl.getRightPane().getChildren().add(this.applicantFilterCtrl.getMainPane());
        //this.mainPaneCtrl.getLeftPane().setBottom(this.applicantInfoCtrl.getMainPane());
    }

    public void showApplicantInfo(String id){
        this.mainPaneCtrl.getLeftPane().setBottom(this.applicantInfoCtrl.getMainPane());
        for (Application app: applications){
            if (app.getPersonalInformation().getID().equals(id)){
                this.applicantInfoCtrl.showData(app);
                this.applicantInfoCtrl.setApplication(app);
                this.applicantInfoCtrl.setUp();
                break;
            }
        }
    }

    public void refreshTable(boolean isFilterOn){
        applicantTableCtrl.refreshTable(isFilterOn);
    }

    public void resetInfoSection(){
        this.mainPaneCtrl.getLeftPane().setBottom(null);

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
    public ApplicantTableController getApplicantTableCtrl(){
        return this.applicantTableCtrl;
    }

    public ApplicantFilterController getApplicantFilterCtrl() {
        return applicantFilterCtrl;
    }
}
