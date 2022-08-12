package MultiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		executeRunnableTask();
		executeCallableTask();
	}

	public static void executeRunnableTask() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future future = executorService.submit(new EventLoggingTask());
		executorService.shutdown();
		System.out.println(future.get());
	}

	public static void executeCallableTask() throws InterruptedException, ExecutionException {
		FactorialTask task = new FactorialTask(5);
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Integer> future = executorService.submit(task);
		executorService.shutdown();
		System.out.println(future.get().intValue());
	}

}

class EventLoggingTask implements Runnable {
	@Override
	public void run() {
		System.out.println("Message");
	}
}

class FactorialTask implements Callable<Integer> {
	int number;

	public FactorialTask(int number) {
		this.number = number;
	}

	@Override
	public Integer call() {
		int fact = 1;
		for (int count = number; count > 1; count--) {
			fact = fact * count;
		}
		return fact;
	}
}