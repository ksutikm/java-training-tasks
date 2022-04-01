import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Car {
    private String brand;
    private String model;

    @JsonFormat (pattern = "dd MM yyyy")
    private Date year;

    public Car() {
        brand = "";
        model = "";
        year = new Date();
    }

    public Car(String brand, String model, Date year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Date getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
