package optional;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class DrawingPanel extends Pane {

    BorderPane root;
    Color color;
    //final static int W = 800, H = 600;

    public DrawingPanel(ConfigPanel configPanel) {
        root = new BorderPane();
        init(configPanel);
    }

    private void init(ConfigPanel configPanel) {

        root.setOnMousePressed(e -> {
            if (configPanel.getColor() == null)
                color = Color.rgb(0, 0, 0, 0.4);
            else
                color = configPanel.getColor();

            RegularPolygon polygon = new RegularPolygon(e, configPanel, color);
            root.getChildren().add(polygon.getPolygon());
        });
    }

    public BorderPane getRoot() {
        return root;
    }
}
