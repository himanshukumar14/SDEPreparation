package HotelManagement;

public class Hotel {
	private String name;
	private Location location;
	private Address address;

	public Hotel(String name, Location location, Address address) {
		this.name = name;
		this.location = location;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
