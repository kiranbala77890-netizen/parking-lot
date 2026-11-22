import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private List<Parkingslot> slots = new ArrayList<>();
    private Map<Integer, Ticket> activeTickets = new HashMap<>();
    private double totalEarnings = 0;

    public ParkingLot(String name, int carSlots, int bikeSlots, int truckSlots) {
        int id = 1;
        for (int i = 0; i < carSlots; i++)   slots.add(new Parkingslot(id++, "Car"));
        for (int i = 0; i < bikeSlots; i++)  slots.add(new Parkingslot(id++, "Bike"));
        for (int i = 0; i < truckSlots; i++) slots.add(new Parkingslot(id++, "Truck"));
    }

    // Pehla khaali slot dhundo jiska type vehicle se match kare
    private Parkingslot findFreeSlot(Vehicle v) {
        for (Parkingslot s : slots) {
            if (s.isFree() && s.getSlotType().equals(v.getType())) {
                return s;
            }
        }
        return null;   // koi slot nahi mila
    }

    public Ticket parkVehicle(Vehicle v) throws ParkingFullException {
        Parkingslot slot = findFreeSlot(v);
        if (slot == null) {
            throw new ParkingFullException("No free slot for " + v.getType());
        }
        slot.park(v);
        Ticket ticket = new Ticket(v, slot);
        activeTickets.put(ticket.getTicketId(), ticket);
        return ticket;
    }

    public double exitVehicle(int ticketId, long hours) throws InvalidTicketException {
        Ticket t = activeTickets.get(ticketId);
        if (t == null) {
            throw new InvalidTicketException("Invalid ticket: " + ticketId);
        }
        double fee = t.getVehicle().getHourlyRate() * hours;
        t.getSlot().free();
        activeTickets.remove(ticketId);
        totalEarnings += fee;
        return fee;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }
}