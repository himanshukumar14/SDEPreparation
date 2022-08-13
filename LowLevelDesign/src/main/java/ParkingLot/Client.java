package ParkingLot;

import ParkingLot.Vehicle.Car;
import ParkingLot.Vehicle.Vehicle;

import java.util.Map;

public class Client {
	
	public static void main(String[] args) {
		Location address = new Location("Whitefield", "Bangalore", "Karnataka", "India");
		Map<ParkingSpotType, Integer> spotTypeMap = Map.of(ParkingSpotType.LARGE, 1,
														   ParkingSpotType.MEDIUM, 1,
														   ParkingSpotType.SMALL, 1);
		ParkingService parkingService = new ParkingService("p1", "Mega Mall Parking");
		parkingService.setParkingAddress(address);
		parkingService.setParkingFloor(1, spotTypeMap);

		Vehicle vehicle1 = new Car("KA 10 xyz", "swift");
		Vehicle vehicle2 = new Car("KA 11 xyz", "baleno");
		Vehicle vehicle3 = new Car("KA 12 xyz", "alto");

		ParkingTicket ticket1 = parkingService.bookParking(vehicle1);
		System.out.println(ticket1.getId() + " " + ticket1.getSpot().getId() + " " + vehicle1.getVehicleId() + " " + ticket1.getEntryTime());
		parkingService.releaseParking(vehicle1);

		ParkingTicket ticket2 = parkingService.bookParking(vehicle2);
		System.out.println(ticket2.getId() + " " + ticket2.getSpot().getId() + " " + vehicle2.getVehicleId() + " " + ticket1.getEntryTime());

		ParkingTicket ticket3 = parkingService.bookParking(vehicle3);
		if(ticket3 != null)
			System.out.println(ticket3.getId() + " " + ticket3.getSpot().getId() + " " + vehicle3.getVehicleId() + " " + ticket1.getEntryTime());
	}
	
}
