package ParkingLot.Vehicle;

import ParkingLot.VehicleType;

public abstract class Vehicle {

	private String vehicleId;
	private VehicleType vehicleType;
	private String model;
	
	public Vehicle(String vehicleId, String model, VehicleType vehicleType) {
		this.vehicleId = vehicleId;
		this.model = model;
		this.vehicleType = vehicleType;
	}
	
	public VehicleType getType() {
		return vehicleType;
	}
	
}
