package optional;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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

        // save button
        button1.setOnAction(e -> {
            // file opener
            final DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Save at:");

            // getting the directory that we'll give
            final File file = directoryChooser.showDialog(root.getScene().getWindow());
            if (file != null) {
                file.getAbsolutePath();
            }

            // get snapshot of our canvas
            WritableImage image = canvas.getRoot().snapshot(new SnapshotParameters(), null);

            try {
                // write the image to given path
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "PNG", new File(file + "\\Art.png"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        // load button
        button2.setOnAction(e -> {
            canvas.getRoot().getChildren().clear(); // resetting the canvas

            // file opener
            final FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Load from:");

            // getting the file that we'll give
            final File file = fileChooser.showOpenDialog(root.getScene().getWindow());
            if (file != null) {
                file.getAbsolutePath();
            }

            Image image = null;
            try {
                // getting the image
                image = new Image(new FileInputStream(file));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }

            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(canvas.getRoot().getHeight());
            imageView.setFitWidth(canvas.getRoot().getWidth());
            imageView.setX(0);
            imageView.setY(0);

            BorderPane newBorder = new BorderPane(imageView);
            canvas.getRoot().getChildren().add(newBorder);
            //canvas.setRoot(newBorder);
        });
        // reset button
        button3.setOnAction(e -> {
            canvas.getRoot().getChildren().clear();
        });
        // exit button
        button4.setOnAction(e -> {
            Window stage = root.getScene().getWindow();
            stage.hide();
        });

        root.getChildren().addAll(button1, button2, button3, button4);
        root.setAlignment(Pos.CENTER);
    }

    public HBox getRoot() {
        return root;
    }
}
