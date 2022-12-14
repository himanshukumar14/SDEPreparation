package MultiThreading;

import java.util.concurrent.Semaphore;

public class H2OProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class H2O {

	private Object lock = new Object();
	private int counter = 0;

	public H2O() {

	}

	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

		synchronized (lock) {
			while (counter == 2) {
				lock.wait();
			}
			releaseHydrogen.run();
			counter++;
			lock.notifyAll();
		}
	}

	public void oxygen(Runnable releaseOxygen) throws InterruptedException {
		synchronized (lock) {
			while (counter != 2) {
				lock.wait();
			}
			releaseOxygen.run();
			counter = 0;
			lock.notifyAll();
		}

	}
}

// Using Semaphores
class H2O1 {

	Semaphore h, o;

	public H2O1() {
		h = new Semaphore(2, true);
		o = new Semaphore(0, true);
	}

	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		h.acquire();
		releaseHydrogen.run();
		o.release();

	}

	public void oxygen(Runnable releaseOxygen) throws InterruptedException {
		o.acquire(2);
		releaseOxygen.run();
		h.release(2);
	}
}