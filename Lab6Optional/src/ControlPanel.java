import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlPanel extends Pane {

    public HBox root;

    public ControlPanel(DrawingPanel canvas) {
        init(canvas);
    }
    public void init(DrawingPanel canvas) {
        this.root = new HBox();
        root.setSpacing(10);

        Button button1 = new Button("Save");
        Button button2 = new Button("Load");
        Button button3 = new Button("Reset");
        Button button4 = new Button("Exit");

        button1.setOnAction(e -> {
            //FileChooser fileChooser = new FileChooser();
            //fileChooser.setTitle("Save at:");
            //fileChooser.showOpenDialog(root.getScene().getWindow());

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save at:");
            fileChooser.setInitialFileName("myphoto");

            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG Files", "*.png");
            fileChooser.getExtensionFilters().add(extFilter);

            File file = fileChooser.showSaveDialog(root.getScene().getWindow());

            if (file != null) {
                saveTextToFile("nothing", file);
            }
        });
        button3.setOnAction(e -> {
            canvas.getRoot().getChildren().clear();
        });
        button4.setOnAction(e -> {
            Window stage = root.getScene().getWindow();
            stage.hide();
        });

        root.getChildren().addAll(button1, button2, button3, button4);
        root.setAlignment(Pos.CENTER);
    }

    private void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public HBox getRoot() {
        return root;
    }
}
