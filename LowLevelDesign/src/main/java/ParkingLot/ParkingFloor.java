package ParkingLot;

import ParkingLot.Spot.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
	private String id;
	private List<ParkingSpot> parkingSpots;
	private int emptySpots;
	
	public ParkingFloor(String id) {
		this.id = id;
		this.parkingSpots = new ArrayList<>();
	}

	public String getId() {
		return id;
	}
	
	public void addParkingSpots(ParkingSpot parkingSpot) {
		parkingSpots.add(parkingSpot);
	}
	
	public List<ParkingSpot> getParkingSpots() {
		return parkingSpots;
	}

}
