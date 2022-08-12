package MultiThreading;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroOddEven {

}

class ZeroEvenOdd {
	private int n;
	private int len = 1;
	private Object lock = new Object();

	public ZeroEvenOdd(int n) {
		this.n = n;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		for (int i = 0; i < n; ++i) {
			synchronized (lock) {
				while (len % 2 == 0) {
					lock.wait();
				}
				printNumber.accept(0);
				len++;
				lock.notifyAll();
			}
		}
	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		int numTimes = this.n / 2;
		int seqEven = 2;
		for (int i = 0; i < numTimes; ++i) {
			synchronized (lock) {
				while (len % 2 == 1 || (len % 2 == 0 && len % 4 != 0)) {
					lock.wait();
				}
				printNumber.accept(seqEven);
				seqEven += 2;
				len++;
				lock.notifyAll();
			}
		}
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		int numTimes = (int) Math.ceil((double) this.n / 2);
		int seqOdd = 1;
		for (int i = 0; i < numTimes; ++i) {
			synchronized (lock) {
				while (len % 2 == 1 || (len % 4 == 0)) {
					lock.wait();
				}
				printNumber.accept(seqOdd);
				seqOdd += 2;
				len++;
				lock.notifyAll();
			}
		}
	}
}

// Using Semaphores
class ZeroEvenOdd1 {
	private int n;
	Semaphore s1, s2, s3;

	public ZeroEvenOdd1(int n) {
        this.n = n;
        s1 = new Semaphore(1);
        s2 = new Semaphore(0);
        s3 = new Semaphore(0);
    }

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			s1.acquire();
			printNumber.accept(0);
			if (i % 2 == 0) {
				s3.release();
			} else {
				s2.release();
			}
		}
	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		for (int i = 2; i <= n; i += 2) {
			s2.acquire();
			printNumber.accept(i);
			s1.release();
		}
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i += 2) {
			s3.acquire();
			printNumber.accept(i);
			s1.release();
		}
	}
}
