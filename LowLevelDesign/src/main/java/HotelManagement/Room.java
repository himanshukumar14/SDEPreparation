package HotelManagement;

import java.util.List;

public class Room {
	private String id;
	private RoomType roomType;
	private RoomStatus roomStatus;
	private double roomPrice;

	public Room(RoomType roomType, RoomStatus roomStatus, double roomPrice) {
		this.id = HotelUtils.generateId();
		this.roomType = roomType;
		this.roomStatus = roomStatus;
		this.roomPrice = roomPrice;
	}

	public String getId() {
		return id;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public RoomStatus getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(RoomStatus roomStatus) {
		this.roomStatus = roomStatus;
	}

	public double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public boolean isAvailable() {
		return roomStatus == RoomStatus.AVAILABLE;
	}

}
