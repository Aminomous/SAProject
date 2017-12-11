package HQ.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class MainController {

    @FXML
    private GridPane grid;

    public void initialize() {
        grid.setGridLinesVisible(true);

        grid.setPrefWidth(400);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(100);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(0);

        grid.getColumnConstraints().setAll(col1, col2);

        grid.getChildren().get(1).setVisible(false);
        grid.getChildren().get(3).setVisible(false);
//        grid.getChildren().get(5).setVisible(false);


//        grid.getColumnConstraints().set(1, new ColumnConstraints(50));


    }

    public void show() {
        grid.setPrefWidth(800);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(10);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(90);

        grid.getColumnConstraints().setAll(col1, col2);

        grid.getChildren().get(1).setVisible(true);
        grid.getChildren().get(3).setVisible(true);
        grid.getChildren().get(5).setVisible(true);

//        grid.getColumnConstraints().set(1, new ColumnConstraints(100));

    }

    public void hide() {
        grid.setPrefWidth(400);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(100);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(0);

        grid.getColumnConstraints().setAll(col1, col2);

        grid.getChildren().get(1).setVisible(false);
        grid.getChildren().get(3).setVisible(false);
        grid.getChildren().get(5).setVisible(false);


//        grid.getColumnConstraints().set(1, new ColumnConstraints(50));
    }

}
