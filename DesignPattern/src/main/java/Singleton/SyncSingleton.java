package Singleton;

public class SyncSingleton {
	private static SyncSingleton obj;

	private SyncSingleton() {
	}

	// Only one thread can execute this at a time
	public static synchronized SyncSingleton getInstance() {
		if (obj == null)
			obj = new SyncSingleton();
		return obj;
	}
}
