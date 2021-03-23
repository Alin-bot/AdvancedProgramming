package optional;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;

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
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save at:");
            fileChooser.setInitialFileName("myphoto");

            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG Files", "*.png");
            fileChooser.getExtensionFilters().add(extFilter);

            File file = fileChooser.showSaveDialog(root.getScene().getWindow());

            if (file != null) {
                save();
            }
        });
        button2.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Load from:");

            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG Files", "*.png");
            fileChooser.getExtensionFilters().add(extFilter);

            File file = fileChooser.showOpenDialog(root.getScene().getWindow());

            if (file != null) {
                load();
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

    private void save() {

    }
    private void load() {

    }
    public HBox getRoot() {
        return root;
    }
}
