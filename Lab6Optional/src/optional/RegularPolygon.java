package optional;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class RegularPolygon extends Polygon {

    Polygon polygon;

    public Polygon getPolygon() {
        return polygon;
    }

    public RegularPolygon(MouseEvent e, ConfigPanel configPanel,Color color) {

        polygon = new Polygon();

        int sides = configPanel.getSides();
        int size = configPanel.getSize();
        double alpha = 2 * Math.PI / sides;
        for (int i = 0; i < sides; i++) {
            double x = e.getX() + size * Math.cos(alpha * i);
            double y = e.getY() + size * Math.sin(alpha * i);
            polygon.getPoints().addAll(x, y);
            polygon.setFill(color);
        }
    }
}
