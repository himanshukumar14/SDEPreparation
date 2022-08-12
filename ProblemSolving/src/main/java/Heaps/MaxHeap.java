package Heaps;

public class MaxHeap {

	private int[] heap;
	private int size;
	private int maxSize;

	public MaxHeap(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		heap = new int[this.maxSize + 1];
		heap[0] = Integer.MAX_VALUE; // Data in array should start from index 1
	}

	public int parent(int pos) {
		return pos / 2;
	}

	public int leftChildren(int pos) {
		return (2 * pos);
	}

	public int rightChildren(int pos) {
		return (2 * pos) + 1;
	}

	public void swap(int pos1, int pos2) {
		int temp;
		temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp;
	}

	public void insert(int element) {
		heap[++size] = element;

		int current = size;
		while (heap[current] > heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(
					" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2 * i] + " RIGHT CHILD :" + heap[2 * i + 1]);
			System.out.println();
		}
	}

	public int extractMax() {
		int popped = heap[1];
		return popped;
	}

	// Only max element can be removed from the tree
	public int deleteMax() {
		int popped = heap[1];
		heap[1] = heap[size--];

		int current = 1;
		
		while ((heap[current] < heap[leftChildren(current)]) || (heap[current] < heap[rightChildren(current)])) {
			if (heap[leftChildren(current)] > heap[rightChildren(current)]) {
				swap(current, leftChildren(current));
				if (current < size / 2) {
					current = leftChildren(current);
				}
			} else {
				swap(current, rightChildren(current));
				if (current < size / 2) {
					current = rightChildren(current);
				}
			}
		}
		return popped;
	}
}
