public abstract class Vehicle {
    private String plateNumber;
    private String type;

    public Vehicle(String plateNumber, String type) {
        this.plateNumber = plateNumber;
        this.type = type;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getType() {
        return type;
    }

    public abstract double getHourlyRate();   // child decide karega
}