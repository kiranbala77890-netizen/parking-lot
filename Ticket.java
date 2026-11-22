import java.time.LocalDateTime;

public class Ticket {
    private static int counter = 1000;

    private int ticketId;
    private Vehicle vehicle;
    private Parkingslot slot;
    private LocalDateTime entryTime;

    public Ticket(Vehicle vehicle, Parkingslot slot) {
        this.ticketId = ++counter;
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryTime = LocalDateTime.now();
    }

    public int getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Parkingslot getSlot() {
        return slot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    @Override
    public String toString() {
        return "Ticket #" + ticketId + " | " + vehicle.getType() + " ["
                + vehicle.getPlateNumber() + "] | Slot " + slot.getSlotId();
    }
}
