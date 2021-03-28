package optional;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ShapePanel {

    VBox root;

    public ShapePanel(DrawingPanel canvas) throws IOException {

        root = new VBox();
        root.prefHeight(600);
        root.minWidth(100);
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(20, 10, 20, 10));
        root.setSpacing(20);

        Button circle = new Button("Circle");
        circle.setPadding(new Insets(10, 10, 10, 10));
        /* Button square = new Button("Square");
        square.setPadding(new Insets(10, 10, 10, 10)); */
        Button triangle = new Button("Triangle");
        triangle.setPadding(new Insets(10, 10, 10, 10));

        circle.setOnMousePressed(e -> { canvas.setShape("circle"); });
        /* square.setOnMousePressed(e -> { canvas.setShape("square"); }); */
        triangle.setOnMousePressed(e -> { canvas.setShape("triangle"); });


        root.getChildren().addAll(circle, triangle); // ,square
    }

    public Parent getRoot() {
        return root;
    }
}
