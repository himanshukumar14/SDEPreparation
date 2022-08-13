package ParkingLot.Spot;

import ParkingLot.ParkingSpotType;
import ParkingLot.Vehicle.Vehicle;

public abstract class ParkingSpot {
	private String id;
	private Vehicle vehicle;
	private ParkingSpotType parkingSpotType;
	private boolean empty;

	public ParkingSpot(String id, ParkingSpotType parkingSpotType) {
		this.id = id;
		this.parkingSpotType = parkingSpotType;
		this.empty = true;
	}

	public String getId() {
		return id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public ParkingSpotType getParkingSpotType() {
		return parkingSpotType;
	}

	public boolean isEmpty() {
		return empty;
	}
	
	public ParkingSpot assignVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		empty = false;
		return this;
	}
	
	public ParkingSpot unAssignVehicle(Vehicle vehicle) {
		this.vehicle = null;
		empty = true;
		return this;
	}

}
