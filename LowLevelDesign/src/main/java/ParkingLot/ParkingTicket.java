package ParkingLot;

import ParkingLot.Spot.ParkingSpot;
import ParkingLot.Vehicle.Vehicle;

import java.util.UUID;

public class ParkingTicket {
    private String id;
    private String entryTime;
    private ParkingTicketStatus status;
    private String exitTime;
    private ParkingSpot spot;
    private Vehicle vehicle;

    public ParkingTicket(String entryTime, Vehicle vehicle, ParkingSpot spot) {
        this.id = UUID.randomUUID().toString();
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.spot = spot;
        this.status = ParkingTicketStatus.ACTIVE;
    }

    public String getId() {
        return id;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public ParkingTicketStatus getStatus() {
        return status;
    }

    public String getExitTime() {
        return exitTime;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void closeParkingTicket() {
        this.exitTime = "";
        this.status = ParkingTicketStatus.CLOSED;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }
    public void setStatus(ParkingTicketStatus status) {
        this.status = status;
    }
}
