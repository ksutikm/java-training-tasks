import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("Audi", "A6", dateFormat.parse("2011-10-01")));
        cars.add(new Car("Honda", "Civic", dateFormat.parse("2012-01-20")));

        ObjectMapper mapper = new ObjectMapper();
        String jsonList = mapper.writeValueAsString(cars);
        System.out.printf("JSON serialization: %s\n\n", jsonList);

        List<Car> carsFromJsonList = mapper.readValue(jsonList, new TypeReference<List<Car>>() { });
        System.out.printf("JSON deserialization: %s", carsFromJsonList);
    }
}
