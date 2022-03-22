import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Figure> list = GenerateFigure.generateList(Integer.parseInt(args[0]));
        List<Figure> sortedList = list.stream().sorted((o1, o2)->o1.getName().
                compareTo(o2.getName())).collect(Collectors.toList());
        System.out.println(sortedList);
    }
}
