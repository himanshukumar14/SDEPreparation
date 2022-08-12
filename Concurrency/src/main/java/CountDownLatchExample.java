import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class CountDownLatchExample {
	private CountDownLatch latchAfterFirst;
	private CountDownLatch latchAfterSecond;

	public CountDownLatchExample() {
		latchAfterFirst = new CountDownLatch(1);
		latchAfterSecond = new CountDownLatch(1);
	}

	public void first(Runnable printFirst) throws InterruptedException {

		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		latchAfterFirst.countDown();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		latchAfterFirst.await();
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		latchAfterSecond.countDown();
	}

	public void third(Runnable printThird) throws InterruptedException {
		latchAfterSecond.await();
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}
}

public class Worker implements Runnable {
	private List<String> outputScraper;
	private CountDownLatch countDownLatch;

	public Worker(List<String> outputScraper, CountDownLatch countDownLatch) {
		this.outputScraper = outputScraper;
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		doSomeWork();
		outputScraper.add("Counted down");
		countDownLatch.countDown();
	}

}

	@Test
	public void whenParallelProcessing_thenMainThreadWillBlockUntilCompletion() throws InterruptedException {

		List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
		CountDownLatch countDownLatch = new CountDownLatch(5);
		List<Thread> workers = Stream.generate(() -> new Thread(new Worker(outputScraper, countDownLatch))).limit(5)
				.collect(toList());

		workers.forEach(Thread::start);
		countDownLatch.await();
		outputScraper.add("Latch released");

		assertThat(outputScraper).containsExactly("Counted down", "Counted down", "Counted down", "Counted down",
				"Counted down", "Latch released");
	}

	public class WaitingWorker implements Runnable {

		private List<String> outputScraper;
		private CountDownLatch readyThreadCounter;
		private CountDownLatch callingThreadBlocker;
		private CountDownLatch completedThreadCounter;

		public WaitingWorker(List<String> outputScraper, CountDownLatch readyThreadCounter,
				CountDownLatch callingThreadBlocker, CountDownLatch completedThreadCounter) {

			this.outputScraper = outputScraper;
			this.readyThreadCounter = readyThreadCounter;
			this.callingThreadBlocker = callingThreadBlocker;
			this.completedThreadCounter = completedThreadCounter;
		}

		@Override
		public void run() {
			readyThreadCounter.countDown();
			try {
				callingThreadBlocker.await();
				doSomeWork();
				outputScraper.add("Counted down");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				completedThreadCounter.countDown();
			}
		}
	}

@Test
public void whenDoingLotsOfThreadsInParallel_thenStartThemAtTheSameTime()
 throws InterruptedException {
 
    List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
    CountDownLatch readyThreadCounter = new CountDownLatch(5);
    CountDownLatch callingThreadBlocker = new CountDownLatch(1);
    CountDownLatch completedThreadCounter = new CountDownLatch(5);
    List<Thread> workers = Stream
      .generate(() -> new Thread(new WaitingWorker(
        outputScraper, readyThreadCounter, callingThreadBlocker, completedThreadCounter)))
      .limit(5)
      .collect(toList());

    workers.forEach(Thread::start);
    readyThreadCounter.await(); 
    outputScraper.add("Workers ready");
    callingThreadBlocker.countDown(); 
    completedThreadCounter.await(); 
    outputScraper.add("Workers complete");

    assertThat(outputScraper)
      .containsExactly(
        "Workers ready",
        "Counted down",
        "Counted down",
        "Counted down",
        "Counted down",
        "Counted down",
        "Workers complete"
      );
}
