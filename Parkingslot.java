public class Parkingslot {
    private int slotId;
    private String slotType;        // "Car", "Bike", "Truck"
    private Vehicle parkedVehicle;  // null matlab slot khaali

    public Parkingslot(int slotId, String slotType) {
        this.slotId = slotId;
        this.slotType = slotType;
    }

    public boolean isFree() {
        return parkedVehicle == null;
    }

    public void park(Vehicle v) {
        this.parkedVehicle = v;
    }

    public void free() {
        this.parkedVehicle = null;
    }

    public int getSlotId() {
        return slotId;
    }

    public String getSlotType() {
        return slotType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}