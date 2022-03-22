import java.awt.*;

public class EquilateralTrapezoid extends Figure {
    private  double base1;
    private  double base2;
    private  double height;

    public EquilateralTrapezoid(String name, Color color, double base1, double base2, double height) {
        super(name, color);
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("%s\nBase 1: %s\nBase 2: %s\nHeight: %s\n\n", super.toString(),
                base1, base2, height);
    }
}
