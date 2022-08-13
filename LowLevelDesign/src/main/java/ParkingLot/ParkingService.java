package ParkingLot;

import ParkingLot.Spot.*;
import ParkingLot.Vehicle.Vehicle;

import java.util.Date;
import java.util.Map;

public class ParkingService {
	private Parking parking;
	
	public ParkingService(String id, String name) {
		this.parking = new Parking(id, name);
	}
	
	public ParkingTicket bookParking(Vehicle vehicle) {
		if(parking.isFree(vehicle)) {
			ParkingSpot spot = parking.getFreeParkingSpot(vehicle);
			spot.assignVehicle(vehicle);
			return generateParkingTicket(vehicle, spot);
		} else {
			System.out.println("Parking is full");
			return null;
		}
	}

	private ParkingTicket generateParkingTicket(Vehicle vehicle, ParkingSpot spot) {
		ParkingTicket ticket = new ParkingTicket(new Date().toString(), spot);
		vehicle.setParkingTicket(ticket);
		return ticket;
	}

	public ParkingTicket releaseParking(Vehicle vehicle) {
		vehicle.getParkingTicket().getSpot().unAssignVehicle(vehicle);
		return closeParkingTicket(vehicle);
	}

	private ParkingTicket closeParkingTicket(Vehicle vehicle) {
		ParkingTicket ticket = vehicle.getParkingTicket();
		ticket.closeParkingTicket();
		return ticket;
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
										case LARGE -> new LargeParkingSpot(floor.getId() + "-" + spotType.name() + "-" + i);
										case SMALL -> new SmallParkingSpot(floor.getId() + "-" + spotType.name() + "-" + i);
										case MEDIUM -> new MediumParkingSpot(floor.getId() + "-" + spotType.name() + "-" + i);
										case HANDICAPPED -> new HandicappedParkingSpot(floor.getId() + "-" + spotType.name() + "-" + i);
									};
				floor.addParkingSpots(spot);
			}
		}
	}
}
