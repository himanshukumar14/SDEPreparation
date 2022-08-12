package ParkingLot;

public class ParkingService {
	private Parking parking;
	
	public ParkingService(String parkingName, Location address) {
		this.parking = new Parking(parkingName, address);
	}
	
	public void bookParkingTicket(Vehicle vehicle) {
		if(parking.isFree(vehicle)) {
			ParkingSpot spot = parking.getParkingSpot(vehicle);
			spot.assignVehicle(vehicle);
		} else {
			System.out.println("Parking is Full");
		}
	}

	public void initializeParking(String name, Location address) {
		Parking.getInstance().setName(name).setAddress(address);
	}


}
