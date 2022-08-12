package ParkingLot;

import java.util.Map;

public class ParkingService {
	private Parking parking;
	
	public ParkingService(String id, String name) {
		this.parking = new Parking(id, name);
	}
	
	public void bookParkingTicket(Vehicle vehicle) {
		if(parking.isFree(vehicle)) {
			ParkingSpot spot = parking.getParkingSpot(vehicle);
			spot.assignVehicle(vehicle);
		} else {
			System.out.println("Parking is Full");
		}
	}

	public void setParkingAddress(Location address) {
		parking.setAddress(address);
	}

	public void setParkingFloor(int floorCount, Map<ParkingSpotType, Integer> spotTypeCount) {
		for(int i = 1; i <= floorCount; ++i) {
			ParkingFloor floor = new ParkingFloor(String.valueOf(i));
			initializeParkingSpot(spotTypeCount, floor);
			parking.addParkingFloor(floor);
		}
	}

	public void initializeParkingSpot(Map<ParkingSpotType, Integer> spotTypeCountMap, ParkingFloor floor) {
		for(ParkingSpotType spotType : spotTypeCountMap.keySet()) {
			for(int i = 1; i <= spotTypeCountMap.get(spotType); ++i) {
				ParkingSpot spot = switch(spotType) {
										case LARGE -> new LargeParkingSpot();
										case SMALL -> new SmallParkingSpot();
										case MEDIUM -> new MediumParkingSpot();
										case HANDICAPPED -> new HandicappedParkingSpot();
									};
				floor.addParkingSpots(spot);
			}
		}
	}

}
