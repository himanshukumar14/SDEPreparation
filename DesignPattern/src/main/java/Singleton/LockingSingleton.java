package Singleton;

public class LockingSingleton {
	private static volatile LockingSingleton obj = null;

	private LockingSingleton() {
	}

	public static LockingSingleton getInstance() {
		if (obj == null) {
			// To make thread safe
			synchronized (LockingSingleton.class) {
				// check again as multiple threads
				// can reach above step
				if (obj == null)
					obj = new LockingSingleton();
			}
		}
		return obj;
	}
}
