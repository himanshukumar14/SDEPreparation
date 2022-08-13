package ParkingLot.Vehicle;

import ParkingLot.VehicleType;

public class Car extends Vehicle {

	public Car(String id, String model) {
		super(id, model, VehicleType.CAR);
	}

}
