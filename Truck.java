public class Truck extends Vehicle {
    public Truck(String plateNumber) {
        super(plateNumber, "Car");
    }

    @Override
    public double getHourlyRate() {
        return 80;
    }
}

