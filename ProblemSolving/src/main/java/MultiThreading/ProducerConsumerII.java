package MultiThreading;

import java.util.LinkedList;

public class ProducerConsumerII {

	public static void main(String[] args) throws InterruptedException {
		final PC pc = new PC();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				int value = 0;
				try {
					while (true) {
						pc.produce(value++);
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						pc.consume();
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}

class PC {
	private Object lock = new Object();
	private LinkedList<Integer> list = new LinkedList<>();
	private int capacity = 2;

	public void produce(int value) throws InterruptedException {
		synchronized (lock) {
			while (list.size() == capacity)
				lock.wait();
			System.out.println("Producer produced-" + value);
			list.add(value);
			if(list.size() == 1)
				lock.notify();
		}

	}

	public void consume() throws InterruptedException {
		synchronized (lock) {
			while (list.size() == 0)
				lock.wait();
			int val = list.removeFirst();
			System.out.println("Consumer consumed-" + val);
			if(list.size() == capacity - 1)
				lock.notify();
		}

	}
}
