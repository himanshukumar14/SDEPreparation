package Heaps;

//O(n)
public class MaxHeapify {
	private int[] heap;
	private int size;

	public MaxHeapify(int[] heap, int size) {
		this.size = size;
		this.heap = heap;
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

	public void heapify(int root) {
		int element = root;
		int l = leftChildren(root);
		int r = rightChildren(root);
		if (l < size && heap[l] > heap[element])
			element = l;
		if (r < size && heap[r] > heap[element])
			element = r;
		if (element != root) {
			swap(root, element);
			heapify(element);
		}
	}
}
