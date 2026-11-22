public class Car extends Vehicle {
    public Car(String plateNumber) {
        super(plateNumber, "Car");
    }

    @Override
    public double getHourlyRate() {
        return 40;
    }
}
