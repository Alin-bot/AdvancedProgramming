package optional;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFrame extends Application {

    DrawingPanel canvas;
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    ShapePanel shapePanel;

    @Override
    public void init() {
        System.out.println("App started!");
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Super Drawing Machine");

        configPanel = new ConfigPanel();
        canvas = new DrawingPanel(configPanel);
        controlPanel = new ControlPanel(canvas);
        shapePanel = new ShapePanel(canvas);

        BorderPane borderPane = new BorderPane(canvas.getRoot(), configPanel.getRoot(),
                null, controlPanel.getRoot(), shapePanel.getRoot());
        // null, we don't have right side

        borderPane.getCenter().setStyle("-fx-background-color: #ffffff");
        borderPane.getTop().setStyle("-fx-background-color: #4e4e4e; -fx-min-height: 50");
        borderPane.getBottom().setStyle("-fx-background-color: #4e4e4e; -fx-min-height: 50");
        borderPane.getLeft().setStyle("-fx-background-color: #8c8c8c");

        borderPane.getStylesheets().add("stylesheets/style.css");

        Scene scene = new Scene(borderPane, 900,700,  Color.web("#000000"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void stop() {
        System.out.println("App closed!");
    }
}
