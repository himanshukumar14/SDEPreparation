package ParkingLot;

import ParkingLot.Spot.ParkingSpot;
import ParkingLot.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String id;
    private String name;
    private Location address;
    private List<ParkingFloor> parkingFloors;

    public Parking(String id, String name) {
        this.id = id;
        this.name = name;
        this.parkingFloors = new ArrayList<>();
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
                if (spot.isEmpty() && vehicle.getVehicleType() == VehicleType.CAR &&
                        (spot.getParkingSpotType() == ParkingSpotType.LARGE || spot.getParkingSpotType() == ParkingSpotType.MEDIUM))
                    return true;
                if (spot.isEmpty() && vehicle.getVehicleType() == VehicleType.BIKE &&
                        spot.getParkingSpotType() == ParkingSpotType.SMALL)
                    return true;
                if (spot.isEmpty() && vehicle.getVehicleType() == VehicleType.CYCLE &&
                        spot.getParkingSpotType() == ParkingSpotType.SMALL)
                    return true;
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

    public ParkingSpot getFreeParkingSpot(Vehicle vehicle) {
        for (ParkingFloor floor : parkingFloors) {
            for (ParkingSpot spot : floor.getParkingSpots()) {
                if (spot.isEmpty() && vehicle.getVehicleType() == VehicleType.CAR &&
                        (spot.getParkingSpotType() == ParkingSpotType.LARGE || spot.getParkingSpotType() == ParkingSpotType.MEDIUM))
                    return spot;
                if (spot.isEmpty() && vehicle.getVehicleType() == VehicleType.BIKE &&
                        spot.getParkingSpotType() == ParkingSpotType.SMALL)
                    return spot;
                if (spot.isEmpty() && vehicle.getVehicleType() == VehicleType.CYCLE &&
                        spot.getParkingSpotType() == ParkingSpotType.SMALL)
                    return spot;
            }
        }
        return null;
    }
}
