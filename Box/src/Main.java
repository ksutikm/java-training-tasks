import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws Exception {
        Box<Car> cars = new Box<>(2);
        cars.put(new Car("Car", 2011, "Audi", "A6"));
        cars.put(new Car("Car", 2012, "Honda", "Civic"));

        Predicate<Vehicle> vehiclePredicate = x -> x.getYearIssue() == 2011;

        cars.getAll(vehiclePredicate).forEach(System.out::println);


        Box<Vehicle> vehicles = new Box<>(2);
        List<Car> carStore = new ArrayList<>();
        carStore.add(new Car("Car", 2011, "Audi", "A6"));
        carStore.add(new Car("Car", 2012, "Honda", "Civic"));

        vehicles.putAll(carStore);
    }
}
