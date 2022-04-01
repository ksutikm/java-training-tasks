import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws ParseException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Car car = new Car("Audi", "A6", dateFormat.parse("2011-10-01"));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(car);
        System.out.printf("JSON serialization: %s\n\n", json);

        Car carFromJson = mapper.readValue(json, Car.class);
        System.out.printf("JSON deserialization: %s", carFromJson);
    }
}
