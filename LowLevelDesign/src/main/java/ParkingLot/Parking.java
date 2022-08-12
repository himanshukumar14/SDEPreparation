package ParkingLot;

import java.util.List;
import java.util.UUID;

public class Parking {
    private String id;
    private String name;
    private Location address;
    private List<ParkingFloor> parkingFloors;
    private static Parking parking = null;

    private Parking() {
        id = UUID.randomUUID().toString();
    }

    public static Parking getInstance() {
        if (parking == null) {
            parking = new Parking();
        }
        return parking;
    }

    public Parking setName(String name) {
        this.name = name;
        return this;
    }

    public Parking setAddress(Location address) {
        this.address = address;
        return this;
    }

    public void addParkingFloor(ParkingFloor parkingFloor) {
        parkingFloors.add(parkingFloor);
    }

    public boolean isFree(Vehicle vehicle) {
        for (ParkingFloor floor : parkingFloors) {
            for (ParkingSpot spot : floor.getParkingSpots()) {
                if (vehicle.getType() == VehicleType.CAR && spot.isEmpty() && (spot.getParkingSpotType() == ParkingSpotType.LARGE || spot.getParkingSpotType() == ParkingSpotType.MEDIUM)) {
                    return true;
                }
                if (vehicle.getType() == VehicleType.BIKE && spot.isEmpty() && spot.getParkingSpotType() == ParkingSpotType.SMALL) {
                    return true;
                }
                if (vehicle.getType() == VehicleType.CYCLE && spot.isEmpty() && spot.getParkingSpotType() == ParkingSpotType.SMALL) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFull() {
        for (ParkingFloor floor : parkingFloors) {
            for (ParkingSpot spot : floor.getParkingSpots()) {
                if (spot.isEmpty()) return false;
            }
        }
        return true;
    }

    public ParkingSpot getParkingSpot(Vehicle vehicle) {
        for (ParkingFloor floor : parkingFloors) {
            for (ParkingSpot spot : floor.getParkingSpots()) {
                if (vehicle.getType() == VehicleType.CAR && spot.isEmpty() && (spot.getParkingSpotType() == ParkingSpotType.LARGE || spot.getParkingSpotType() == ParkingSpotType.MEDIUM)) {
                    return spot;
                }
                if (vehicle.getType() == VehicleType.BIKE && spot.isEmpty() && spot.getParkingSpotType() == ParkingSpotType.SMALL) {
                    return spot;
                }
                if (vehicle.getType() == VehicleType.CYCLE && spot.isEmpty() && spot.getParkingSpotType() == ParkingSpotType.SMALL) {
                    return spot;
                }
            }
        }
        return null;
    }
}
