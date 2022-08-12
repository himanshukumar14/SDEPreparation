package MultiThreading;

import java.util.concurrent.Semaphore;

public class FooBar {
	private int n;
	private Object lock = new Object();
	private int len = 1;

	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			synchronized (lock) {
				while (len % 2 == 0) {
					lock.wait();
				}
				// printFoo.run() outputs "foo". Do not change or remove this line.
				printFoo.run();
				len++;
				lock.notifyAll();
			}
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			synchronized (lock) {
				while (len % 2 == 1) {
					lock.wait();
				}
				// printBar.run() outputs "bar". Do not change or remove this line.
				printBar.run();
				len++;
				lock.notifyAll();
			}
		}
	}
}

class FooBar1 {
	private int n;
	Semaphore s = new Semaphore(0);
	Semaphore s2 = new Semaphore(1);
	public FooBar1(int n) {
		this.n = n;
	}
	public void foo(Runnable printFoo) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			s2.acquire();
			printFoo.run();
			s.release();
		}
	}
	public void bar(Runnable printBar) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			s.acquire();
			printBar.run();
			s2.release();
		}
	}
}
