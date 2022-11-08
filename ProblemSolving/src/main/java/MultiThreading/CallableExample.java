package MultiThreading;

import java.util.concurrent.*;

public class CallableExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
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

	public static void executeCallableTask() throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Integer> future = executorService.submit(new FactorialTask(5));
		executorService.shutdown();
		System.out.println(future.get(10, TimeUnit.MILLISECONDS).intValue());
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