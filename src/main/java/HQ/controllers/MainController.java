package HQ.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import services.DatabaseApplicationService;
import services.MySQLConnector;

import java.io.IOException;
import java.sql.SQLException;

public class MainController {

    private int mainPanelStatus;

    private Stage stage;
    private String title = "Warehouse Manager";

    private MainPaneController mainPaneCtrl;


    private DatabaseApplicationService applicationService;

    public MainController(Stage stage) throws IOException, SQLException {
        this.stage = stage;
        this.applicationService = new DatabaseApplicationService("//10.2.52.180:3306/warehousedb", new MySQLConnector());

//        this.applicationService = new DatabaseApplicationService("test_db.db", new SQLiteConnector());

        this.mainPanelStatus = 1;

    }

    public void start() {
        Pane mainPane = this.mainPaneCtrl.getMainPane();
        int w = (int) mainPane.getWidth();
        int h = (int) mainPane.getHeight();
        this.stage.setTitle(this.title);
        this.stage.setOnCloseRequest(e -> System.exit(0));
        this.stage.setScene(new Scene(mainPane));
        this.stage.show();
    }

    private void loadPane() throws IOException {
        FXMLLoader mainPaneLoader = new FXMLLoader(getClass().getResource("/fxml/warehouse/main.fxml"));
        FlowPane mainPane = mainPaneLoader.load();
        this.mainPaneCtrl = mainPaneLoader.getController();
        this.mainPaneCtrl.setMainPane(mainPane);
        this.mainPaneCtrl.setMainCtrl(this);
//
//        this.mainPaneCtrl.getLeftPane().getChildren().add(this.stockListCtrl.getMainPane());
//        this.mainPaneCtrl.getRightPane().getChildren().add(this.productDetailCtrl.getMainPane());
    }


    public DatabaseApplicationService getProductService() {
        return applicationService;
    }

    public int getMainPanelStatus() {
        return mainPanelStatus;
    }

    public void setMainPanelStatus(int mainPanelStatus) {
        this.mainPanelStatus = mainPanelStatus;
    }
}
