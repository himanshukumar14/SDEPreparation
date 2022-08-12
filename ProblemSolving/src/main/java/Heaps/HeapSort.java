package Heaps;

public class HeapSort {

	private int[] heap;
	private int size;

	public HeapSort(int[] heap, int size) {
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

	public void maxHeapify(int root, int n) {
		int element = root;
		int l = leftChildren(root);
		int r = rightChildren(root);
		if (l < n && heap[l] > heap[element])
			element = l;
		if (r < n && heap[r] > heap[element])
			element = r;
		if (element != root) {
			swap(root, element);
			maxHeapify(element, n);
		}
	}

	public void heapSort() {
		for (int i = size - 1; i > 0; i--)
			maxHeapify(i, size);
		for (int i = size - 1; i > 0; i--) {
			swap(1, i);
			maxHeapify(1, i);
		}
	}
}
