package ParkingLot;

import java.util.List;

public class Parking {
    private String id;
    private String name;
    private Location address;
    private List<ParkingFloor> parkingFloors;
    private static Parking parking = null;

    public Parking(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setAddress(Location address) {
        this.address = address;
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
