package ParkingLot;

import java.util.List;

public class ParkingFloor {
	private String id;
	private List<ParkingSpot> parkingSpots;
	private int emptySpots;
	
	public ParkingFloor(String id) {
		this.id = id;
	}
	
	public void addParkingSpots(ParkingSpot parkingSpot) {
		parkingSpots.add(parkingSpot);
	}
	
	public List<ParkingSpot> getParkingSpots() {
		return parkingSpots;
	}

}
