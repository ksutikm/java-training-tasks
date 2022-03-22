import java.awt.*;

public class Rectangle extends Figure {
    private double height;
    private double width;

    public Rectangle(String name, Color color, double height, double width) {
        super(name, color);
        this.height = height;
        this.width = width;
    }

    @Override
    public String toString() {
        return String.format("%s\nHeight: %s\nWidth: %s\n\n", super.toString(), height, width);
    }
}
