package ParkingLot;

import ParkingLot.Spot.ParkingSpot;

import java.util.Date;
import java.util.UUID;

public class ParkingTicket {
    private String id;
    private String entryTime;
    private ParkingTicketStatus status;
    private String exitTime;
    private ParkingSpot spot;

    public ParkingTicket(String entryTime, ParkingSpot spot) {
        this.id = UUID.randomUUID().toString();
        this.entryTime = entryTime;
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

    public void closeParkingTicket() {
        this.exitTime = new Date().toString();
        this.status = ParkingTicketStatus.CLOSED;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }
    public void setStatus(ParkingTicketStatus status) {
        this.status = status;
    }
}
