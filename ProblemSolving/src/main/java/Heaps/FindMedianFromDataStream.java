package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

	PriorityQueue<Integer> maxHeap;
	PriorityQueue<Integer> minHeap;

	/** initialize your data structure here. */
	public FindMedianFromDataStream() {
		maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}
		});
		minHeap = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i1 - i2;
			}
		});
	}

	public void addNum(int num) {
		if (maxHeap.size() == 0 || num <= maxHeap.peek())
			maxHeap.add(num);
		 else 
			minHeap.add(num);
		
		if (maxHeap.size() - minHeap.size() != 0 && maxHeap.size() - minHeap.size() != 1) {
			if (maxHeap.size() - minHeap.size() > 1)
				minHeap.add(maxHeap.poll());
			else
				maxHeap.add(minHeap.poll());
		}
	}

	public double findMedian() {
		if ((maxHeap.size() + minHeap.size()) % 2 == 0)
			return (double) (maxHeap.peek() + minHeap.peek()) / 2;
		else
			return maxHeap.peek();
	}

}
