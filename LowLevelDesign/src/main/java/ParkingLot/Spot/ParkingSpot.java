package ParkingLot.Spot;

import ParkingLot.ParkingSpotType;
import ParkingLot.Vehicle.Vehicle;

public abstract class ParkingSpot {
	private Vehicle vehicle;
	private ParkingSpotType parkingSpotType;
	private boolean empty;

	public ParkingSpot(ParkingSpotType parkingSpotType) {
		this.parkingSpotType = parkingSpotType;
		this.empty = true;
	}
	
	public ParkingSpotType getParkingSpotType() {
		return parkingSpotType;
	}

	public boolean isEmpty() {
		return empty;
	}
	
	public void assignVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		empty = false;
	}
	
	public void unassignVehicle(Vehicle vehicle) {
		this.vehicle = null;
		empty = true;
	}

}
