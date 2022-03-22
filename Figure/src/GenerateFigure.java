import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class GenerateFigure {
    private static Random ran = new Random();

    public static List<Figure> generateList(int count) {
        List<Figure> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int numFigure = random.nextInt(5);
            switch (numFigure) {
                case 0:
                    list.add(generateCircle());
                    break;
                case 1:
                    list.add(generateTriangle());
                    break;
                case 2:
                    list.add(generateSquare());
                    break;
                case 3:
                    list.add(generateRectangle());
                    break;
                case 4:
                    list.add(generateEquilateralTrapezoid());
                    break;
                default:
                    break;
            }
        }
        return list;
    }

    public static Circle generateCircle() {
        Color color = randomColor();
        double radius = ran.nextInt(50) + 1;
        return new Circle("Circle", color, radius);
    }

    public static Triangle generateTriangle() {
        Color color = randomColor();
        double sideA = ran.nextInt(50) + 1;
        double sideB = ran.nextInt(50) + 1;
        int A = (int) (sideA + sideB);
        int B = (int) (Math.abs(sideA - sideB) + 1);
        double sideC = ran.nextInt((A - B)) + B;
        return new Triangle("Triangle", color, sideA, sideB, sideC);
    }

    public static Square generateSquare() {
        Color color = randomColor();
        double side = ran.nextInt(50) + 1;
        return new Square("Square", color, side);
    }

    public static Rectangle generateRectangle() {
        Color color = randomColor();
        double height = ran.nextInt(50) + 1;
        double width = ran.nextInt(50) + 1;
        return new Rectangle("Rectangle", color, height, width);
    }

    public static EquilateralTrapezoid generateEquilateralTrapezoid() {
        Color color = randomColor();
        double base1 = ran.nextInt(50) + 1;
        double base2 = ran.nextInt(50) + 1;
        double height = ran.nextInt(50) + 1;
        return new EquilateralTrapezoid("Equilateral trapezoid",
                color, base1, base2, height);

    }

    private static Color randomColor() {
        int r = ran.nextInt(256);
        int g = ran.nextInt(256);
        int b = ran.nextInt(256);
        return new Color(r, g, b);
    }
}
