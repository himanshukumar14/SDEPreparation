package ParkingLot;

import java.util.List;

public class ParkingFloor {
	private String floorId;
	private String name;
	private List<ParkingSpot> parkingSpots;
	private int emptySpots;
	
	public ParkingFloor(String name) {
		this.name = name;
	}
	
	public void addParkingSpots(ParkingSpot parkingSpot) {
		parkingSpots.add(parkingSpot);
	}
	
	public List<ParkingSpot> getParkingSpots() {
		return parkingSpots;
	}

}
