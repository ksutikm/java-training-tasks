import java.awt.*;

public class Figure {
    private String name;
    private Color color;

    public Figure(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s\nColor: %s", name, color);
    }
}
