package ParkingLot;

import java.util.Map;
import java.util.UUID;

public class Client {
	
	public static void main(String[] args) {
		Location address = new Location("Whitefield", "Bangalore", "Karnataka", "India");
		Map<ParkingSpotType, Integer> spotTypeMap = Map.of(ParkingSpotType.LARGE, 5,
														   ParkingSpotType.MEDIUM, 5,
														   ParkingSpotType.SMALL, 5);
		ParkingService parkingService = new ParkingService("p1", "Mega Mall Parking");
		parkingService.setParkingAddress(address);
		parkingService.setParkingFloor(3, spotTypeMap);

		Vehicle vehicle1 = new Car("KA 10 xyz", "swift");
		Vehicle vehicle2 = new Car("KA 11 xyz", "baleno");
		Vehicle vehicle3 = new Car("KA 12 xyz", "alto");

	}
	
}
