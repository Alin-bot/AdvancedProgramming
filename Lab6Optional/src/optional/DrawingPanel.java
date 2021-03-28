package optional;

import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

public class DrawingPanel extends Pane {

    AnchorPane root;
    Color color;
    //final static int W = 800, H = 600;
    String shape = "";

    public void setShape(String shape) {
        this.shape = shape;
    }

    public AnchorPane getRoot() {
        return root;
    }

    public DrawingPanel(ConfigPanel configPanel) {
        root = new AnchorPane();
        root.setMaxHeight(600);
        root.setMaxWidth(800);
        init(configPanel);
    }

    private void init(ConfigPanel configPanel) {

        root.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            if(e.getButton().equals(MouseButton.PRIMARY)) {
                if (configPanel.getColor() == null)
                    color = Color.rgb(0, 0, 0, 0.4);
                else
                    color = configPanel.getColor();

                if (shape.equals("") || configPanel.getSides() > 0) {
                    RegularPolygon polygon = new RegularPolygon(e, configPanel, color);
                    isEventOn(root, polygon.getPolygon());
                    root.getChildren().add(polygon.getPolygon());
                } else {
                    int size = configPanel.getSize();
                    if (shape.equals("circle")) {
                        Circle form = new Circle(e.getX(), e.getY(), size, color);
                        root.getChildren().add(form);
                    } else {
                        Polygon form = new Polygon();
                        if (shape.equals("triangle")) {
                            double alpha = 2 * Math.PI / 3;
                            for (int i = 0; i < 3; i++) {
                                double x = e.getX() + size * Math.cos(alpha * i);
                                double y = e.getY() + size * Math.sin(alpha * i);
                                form.getPoints().addAll(x, y);
                                form.setFill(color);
                            }
                            root.getChildren().add(form);
                        } else if (shape.equals("square")) {
                            double alpha = 2 * Math.PI / 4;
                            for (int i = 0; i < 4; i++) {
                                double x = e.getX() + size * Math.cos(alpha * i);
                                double y = e.getY() + size * Math.sin(alpha * i);
                                form.getPoints().addAll(x, y);
                                form.setFill(color);
                            }
                            root.getChildren().add(form);
                        }
                    }
                }
            }
        });

        // just left click
        /*
        root.setOnMousePressed(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                root.getChildren().removeAll();
            } else {
                if (configPanel.getColor() == null)
                    color = Color.rgb(0, 0, 0, 0.4);
                else
                    color = configPanel.getColor();

                RegularPolygon polygon = new RegularPolygon(e, configPanel, color);
                root.getChildren().add(polygon.getPolygon());
            }
        });
        */
    }

    // for removing objects from our layout
    public void isEventOn(AnchorPane parent, Node node) {
        node.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            if(e.getButton().equals(MouseButton.SECONDARY)) {
                parent.getChildren().remove(node);
            }
        });
    }
}
