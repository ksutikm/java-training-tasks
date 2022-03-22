import java.awt.*;

public class Square extends Figure {
    private double side;

    public Square(String name, Color color, double side) {
        super(name, color);
        this.side = side;
    }

    @Override
    public String toString() {
        return String.format("%s\nSide: %s\n\n", super.toString(), side);
    }
}
