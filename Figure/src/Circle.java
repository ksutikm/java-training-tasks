import java.awt.*;

public class Circle extends Figure {
    private double radius;

    public Circle(String name, Color color, double radius) {
        super(name, color);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return String.format("%s\nRadius: %s\n\n", super.toString(), radius);
    }

}
