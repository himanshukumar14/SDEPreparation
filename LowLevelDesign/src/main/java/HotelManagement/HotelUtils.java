package HotelManagement;

import java.util.Random;

public class HotelUtils {

	public static int generateId() {
		return new Random().nextInt(6) + 1;
	}

}
