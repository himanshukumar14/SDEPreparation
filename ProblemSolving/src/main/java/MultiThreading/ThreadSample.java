package MultiThreading;

/*Multithreading is a Java feature that allows concurrent execution of two or more parts of a program for maximum utilization of CPU. 
Each part of such program is called a thread. So, threads are light-weight processes within a process.

Threads can be created by using two mechanisms :
1. Extending the Thread class
2. Implementing the Runnable Interface

Thread creation by extending the Thread class

We create a class that extends the java.lang.Thread class. 
This class overrides the run() method available in the Thread class. A thread begins its life inside run() method. 
We create an object of our new class and call start() method to start the execution of a thread. 
Start() invokes the run() method on the Thread object.*/

public class ThreadSample {

	public static void main(String[] args) {
		int n = 8; // Number of threads
		for (int i = 0; i < n; i++) {
			MultithreadingDemo object = new MultithreadingDemo();
			object.start();
		}
	}

}

class MultithreadingDemo extends Thread {
	@Override
	public void run() {
		try {
			// Displaying the thread that is running
			System.out.println("Thread " + Thread.currentThread().getId() + " is running");
		} catch (Exception e) {
			// Throwing an exception
			System.out.println("Exception is caught");
		}
	}
}
