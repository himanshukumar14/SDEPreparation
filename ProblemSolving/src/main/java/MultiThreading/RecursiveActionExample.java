package MultiThreading;

import java.util.concurrent.RecursiveAction;

public class RecursiveActionExample {

	protected static double parArraySum(final double[] input) {
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "4");
		assert input.length % 2 == 0;
		final double startTime = System.currentTimeMillis();
		int mid = input.length / 2;
		ArraySumTask sumTaskLeft = new ArraySumTask(0, mid, input);
		ArraySumTask sumTaskRight = new ArraySumTask(mid, input.length, input);
		sumTaskLeft.fork();
		sumTaskRight.compute();
		sumTaskLeft.join();
		double result = sumTaskLeft.getValue() + sumTaskRight.getValue();
		final double endTime = System.currentTimeMillis();
		double duration = (endTime - startTime);
		System.out.println(String.format("took: %f milliseconds, sum: %f: parArraySum ", duration, result));
		return result;
	}
}

class ArraySumTask extends RecursiveAction {
	private final int startIndex;
	private final int endIndex;
	private final double[] input;
	private double value;

	ArraySumTask(final int startIndex, final int endIndex, final double[] input) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.input = input;
	}

	public double getValue() {
		return value;
	}

	@Override
	protected void compute() {
		for (int i = startIndex; i < endIndex; ++i)
			value += input[i];
	}
}
