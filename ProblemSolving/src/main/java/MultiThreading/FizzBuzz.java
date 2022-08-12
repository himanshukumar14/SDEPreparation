package MultiThreading;

import java.util.function.IntConsumer;

public class FizzBuzz {
	private int n;
	private int len = 1;
	private Object lock = new Object();

	public FizzBuzz(int n) {
		this.n = n;
	}

	// printFizz.run() outputs "fizz".
	public void fizz(Runnable printFizz) throws InterruptedException {
		while (len <= n) {
			synchronized (lock) {
				if (len % 3 != 0 || len % 5 == 0) {
					lock.wait();
					continue;
				}
				printFizz.run();
				len++;
				lock.notifyAll();
			}
		}
	}

	// printBuzz.run() outputs "buzz".
	public void buzz(Runnable printBuzz) throws InterruptedException {
		while (len <= n) {
			synchronized (lock) {
				if (len % 5 != 0 || len % 3 == 0) {
					lock.wait();
					continue;
				}
				printBuzz.run();
				len++;
				lock.notifyAll();
			}
		}
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		while (len <= n) {
			synchronized (lock) {
				if (len % 15 != 0) {
					lock.wait();
					continue;
				}
				printFizzBuzz.run();
				len++;
				lock.notifyAll();
			}
		}
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void number(IntConsumer printNumber) throws InterruptedException {
		while (len <= n) {
			synchronized (lock) {
				if (len % 3 == 0 || len % 5 == 0) {
					lock.wait();
					continue;
				}
				printNumber.accept(len);
				len++;
				lock.notifyAll();
			}
		}
	}
}