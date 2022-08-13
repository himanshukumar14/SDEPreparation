package ParkingLot.Vehicle;

import ParkingLot.ParkingTicket;
import ParkingLot.VehicleType;

public abstract class Vehicle {
	private String vehicleId;
	private VehicleType vehicleType;
	private String model;
	private ParkingTicket parkingTicket;
	
	public Vehicle(String vehicleId, String model, VehicleType vehicleType) {
		this.vehicleId = vehicleId;
		this.model = model;
		this.vehicleType = vehicleType;
	}

	public void setParkingTicket(ParkingTicket parkingTicket) {
		this.parkingTicket = parkingTicket;
	}

	public ParkingTicket getParkingTicket() {
		return parkingTicket;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public String getModel() {
		return model;
	}
}
