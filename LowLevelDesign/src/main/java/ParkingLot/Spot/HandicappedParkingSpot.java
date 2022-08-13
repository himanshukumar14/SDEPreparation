package ParkingLot.Spot;

import ParkingLot.ParkingSpotType;

public class HandicappedParkingSpot extends ParkingSpot {

    public HandicappedParkingSpot(String id) {
        super(id, ParkingSpotType.HANDICAPPED);
    }
}
