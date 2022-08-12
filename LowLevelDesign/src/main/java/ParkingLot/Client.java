package ParkingLot;

public class Client {
	
	public static void main(String[] args) {
		Location address = new Location("Whitefield", "Bangalore", "Karnataka", "India");
		ParkingService parkingService = new ParkingService("Mega Mall Parking", address);
		Vehicle vehicle = new Car("KA 10 xyz", "swift");
	}
	
}
