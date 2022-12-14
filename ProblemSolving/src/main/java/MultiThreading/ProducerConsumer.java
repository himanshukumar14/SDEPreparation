package MultiThreading;

/*In computing, the producer-consumer problem (also known as the bounded-buffer problem) is a classic example of a multi-process 
 * synchronization problem. The problem describes two processes, the producer and the consumer, 
 * which share a common, fixed-size buffer used as a queue.

The producer?s job is to generate data, put it into the buffer, and start again.
At the same time, the consumer is consuming the data (i.e. removing it from the buffer), one piece at a time.
Problem
To make sure that the producer won?t try to add data into the buffer if it?s full and that the consumer 
won?t try to remove data from an empty buffer.

Solution
The producer is to either go to sleep or discard data if the buffer is full. The next time the consumer 
removes an item from the buffer, it notifies the producer, who starts to fill the buffer again. 
In the same way, the consumer can go to sleep if it finds the buffer to be empty. The next time 
the producer puts data into the buffer, it wakes up the sleeping consumer.
An inadequate solution could result in a deadlock where both processes are waiting to be awakened.*/

public class ProducerConsumer {

	public static void main(String[] args) {
		CustomQueue q = new CustomQueue();
		Thread t1 = new Thread(new Producer1(q), "Producer");
		Thread t2 = new Thread(new Consumer2(q), "Consumer");
		t1.start();
		t2.start();
	}
}

class CustomQueue {
	int num;
	boolean valueSet = false;

	public synchronized void put(int num) {
		while (valueSet) {
			try {
				wait();
			} catch (Exception e) {

			}
		}
		System.out.println("Put : " + num);
		this.num = num;
		valueSet = true;
		notify();
	}

	public synchronized void get() {
		if(!valueSet) {
			try {
				wait();
			} catch (Exception e) {

			}
		}
		System.out.println("Get : " + num);
		valueSet = false;
		notify();
	}
}

class Producer1 implements Runnable {
	CustomQueue q;

	public Producer1(CustomQueue q) {
		this.q = q;
	}

	public void run() {
		int i = 0;
		while (true) {
			q.put(i++);
			try {
				Thread.sleep(2000);
			} catch (Exception e) {

			}
		}
	}
}

class Consumer2 implements Runnable {
	CustomQueue q;

	public Consumer2(CustomQueue q) {
		this.q = q;
	}

	public void run() {
		while (true) {
			q.get();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {

			}
		}
	}
}
