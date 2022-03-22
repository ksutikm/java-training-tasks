import java.awt.*;

public class Triangle extends Figure {
    private  double sideA;
    private  double sideB;
    private  double sideC;

    public Triangle(String name, Color color, double sideA, double sideB, double sideC) {
        super(name, color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public String toString() {
        return String.format("%s\nSide A: %s\nSide B: %s\nSide C: %s\n\n", super.toString(),
                sideA, sideB, sideC);
    }
}
