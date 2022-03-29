public class Car extends Vehicle{
    private String brand;
    private String model;

    public Car(String typeVehicle, int yearIssue, String brand, String model) {
        super(typeVehicle, yearIssue);
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format("%s, brand: %s, model: %s", super.toString(), brand, model);
    }
}
