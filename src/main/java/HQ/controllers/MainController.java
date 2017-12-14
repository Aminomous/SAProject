package HQ.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import services.DatabaseApplicationService;
import services.MySQLConnector;

import java.io.IOException;
import java.sql.SQLException;

public class MainController {

    private Stage stage;
    private String title = "SA";

    private MainPaneController mainPaneCtrl;
    private ApplicantFilterController applicantFilterCtrl;
    private ApplicantInfoController applicantInfoCtrl;
    private ApplicantTableController applicantTableCtrl;


    private DatabaseApplicationService applicationService;

    public MainController(Stage stage) throws IOException, SQLException {
        this.stage = stage;
        this.applicationService = new DatabaseApplicationService("//127.0.0.1:3306/saapplicationmanager", new MySQLConnector());

//        this.applicationService = new DatabaseApplicationService("test_db.db", new SQLiteConnector());

        loadPane();
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
        FXMLLoader mainPaneLoader = new FXMLLoader(getClass().getResource("/HQ/mainProgram.fxml"));
        GridPane mainPane = mainPaneLoader.load();
        this.mainPaneCtrl = mainPaneLoader.getController();
        this.mainPaneCtrl.setMainPane(mainPane);
        this.mainPaneCtrl.setMainCtrl(this);

        FXMLLoader applicantTablePaneLoader = new FXMLLoader(getClass().getResource("/HQ/applicantTable.fxml"));
        FlowPane applicantTablePane = applicantTablePaneLoader.load();
        this.applicantTableCtrl = applicantTablePaneLoader.getController();
        this.applicantTableCtrl.setMainPane(applicantTablePane);
        this.applicantTableCtrl.setMainCtrl(this);

        FXMLLoader applicantFilterPaneLoader = new FXMLLoader(getClass().getResource("/HQ/applicantFilter.fxml"));
        FlowPane applicantFilterPane = applicantFilterPaneLoader.load();
        this.applicantFilterCtrl = applicantFilterPaneLoader.getController();
        this.applicantFilterCtrl.setMainPane(applicantFilterPane);
        this.applicantFilterCtrl.setMainCtrl(this);

        FXMLLoader applicantInfoPaneLoader = new FXMLLoader(getClass().getResource("/HQ/applicantInfo.fxml"));
        FlowPane applicantInfoPane = applicantInfoPaneLoader.load();
        this.applicantInfoCtrl = applicantInfoPaneLoader.getController();
        this.applicantInfoCtrl.setMainPane(applicantInfoPane);
        this.applicantInfoCtrl.setMainCtrl(this);

        this.mainPaneCtrl.getLeftPane().setCenter(this.applicantTableCtrl.getMainPane());
        this.mainPaneCtrl.getRightPane().getChildren().add(this.applicantFilterCtrl.getMainPane());
        this.mainPaneCtrl.getLeftPane().setBottom(this.applicantInfoCtrl.getMainPane());
    }


    public DatabaseApplicationService getProductService() {
        return applicationService;
    }

}
