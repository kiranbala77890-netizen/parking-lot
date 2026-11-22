public class Bike extends Vehicle {
    public Bike(String plateNumber) {
        super(plateNumber, "Car");
    }

    @Override
    public double getHourlyRate() {
        return 20;
    }
}

