public class Vehicle {
    private String typeVehicle;
    private int yearIssue;

    public Vehicle(String typeVehicle, int yearIssue) {
        this.typeVehicle = typeVehicle;
        this.yearIssue = yearIssue;
    }

    public int getYearIssue() {
        return yearIssue;
    }

    @Override
    public String toString() {
        return String.format("Type vehicle: %s, year issue: %s", typeVehicle, yearIssue);
    }
}
