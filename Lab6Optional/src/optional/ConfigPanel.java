package optional;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ConfigPanel extends Pane {

    public HBox root;
    private int size = 10;
    private int sides = 3;
    private Color color;

    public ConfigPanel() {
        this.root = new HBox();
        init();
    }
    public void init() {
        root.setSpacing(10);

        // menu of colors
        MenuItem item1 = new MenuItem("Cool Blue");
        MenuItem item2 = new MenuItem("Fire Red");
        MenuItem item3 = new MenuItem("Bright Yellow");
        MenuItem item4 = new MenuItem("Relaxing Green");
        MenuItem item5 = new MenuItem("Again Black");

        MenuButton menuButton = new MenuButton("Pick color", null, item1, item2, item3, item4, item5);
        menuButton.setPrefWidth(120);

        item1.setOnAction(e -> {
            menuButton.setText(item1.getText());
            color = Color.rgb(31, 181, 181, 0.4);
        });
        item2.setOnAction(e -> {
            menuButton.setText(item2.getText());
            color = Color.rgb(181, 31, 31, 0.4);
        });
        item3.setOnAction(e -> {
            menuButton.setText(item3.getText());
            color = Color.rgb(186, 186, 30, 0.4);
        });
        item4.setOnAction(e -> {
            menuButton.setText(item4.getText());
            color = Color.rgb(37, 120, 24, 0.4);
        });
        item5.setOnAction(e -> {
            menuButton.setText(item5.getText());
            color = Color.rgb(0, 0, 0, 0.4);
        });

        // for sides
        Label sidesText = new Label("Number of sides:");
        sidesText.setStyle("-fx-text-fill: white; -fx-font-size: 20");
        TextField sidesInput = new TextField();

        // for size
        Label sizeText = new Label("The size:");
        sizeText.setStyle("-fx-text-fill: white; -fx-font-size: 20");
        TextField sizeInput = new TextField();

        // submit button
        Button button = new Button("Submit");

        button.setOnAction(e -> {
            if (!sidesInput.getText().equals(""))
                sides = Integer.parseInt(sidesInput.getText());
            else
                sides = 3;
            if (!sizeInput.getText().equals(""))
                size = Integer.parseInt(sizeInput.getText());
            else
                size = 10;
            System.out.println("Sides: " + sides + " Size: " + size);
        });

        // adding
        root.getChildren().addAll(sidesText, sidesInput, sizeText, sizeInput, button, menuButton);
        root.setAlignment(Pos.CENTER);
    }

    public HBox getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public int getSides() {
        return sides;
    }
}
