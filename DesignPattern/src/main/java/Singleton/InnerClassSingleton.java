package Singleton;

public class InnerClassSingleton {
	private InnerClassSingleton() {
		// private constructor
	}

	// Inner class to provide instance of class
	private static class BillPughSingleton {
		private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
	}

	public static InnerClassSingleton getInstance() {
		return BillPughSingleton.INSTANCE;
	}
}
