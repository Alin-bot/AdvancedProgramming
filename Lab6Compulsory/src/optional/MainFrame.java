package optional;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainFrame extends Application {

    DrawingPanel canvas;
    ConfigPanel configPanel;
    ControlPanel controlPanel;

    @Override
    public void init() throws Exception {
        System.out.println("App started!");
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Super Drawing Machine");

        configPanel = new ConfigPanel();
        canvas = new DrawingPanel(configPanel);
        controlPanel = new ControlPanel(canvas);

        // getting the layouts from our classes
        HBox boxTop = configPanel.getRoot();
        HBox boxBottom = controlPanel.getRoot();
        BorderPane boxCenter = canvas.getRoot();

        BorderPane border_pane = new BorderPane(boxCenter, boxTop, null, boxBottom, null);
        // null, we don't have right and left sides

        border_pane.getCenter().setStyle("-fx-background-color: #ffffff");
        border_pane.getTop().setStyle("-fx-background-color: #4e4e4e; -fx-min-height: 50");
        border_pane.getBottom().setStyle("-fx-background-color: #4e4e4e; -fx-min-height: 50");

        border_pane.getStylesheets().add("stylesheets/style.css");

        Scene scene = new Scene(border_pane, 800,700,  Color.web("#000000"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("App closed!");
    }
}
