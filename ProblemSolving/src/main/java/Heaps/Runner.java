package Heaps;

public class Runner {

	public static void main(String[] args) {
//		MaxHeap maxHeap = new MaxHeap(15);
//		MinHeap minHeap = new MinHeap(15);
//		maxHeap.insert(5);
//		maxHeap.insert(3);
//		maxHeap.insert(17);
//		maxHeap.insert(10);
//		maxHeap.insert(84);
//		maxHeap.insert(19);
//		maxHeap.insert(6);
//		maxHeap.insert(22);
//		maxHeap.insert(9);
//		maxHeap.insert(7);
//
//		minHeap.insert(5);
//		minHeap.insert(3);
//		minHeap.insert(17);
//		minHeap.insert(10);
//		minHeap.insert(84);
//		minHeap.insert(19);
//		minHeap.insert(6);
//		minHeap.insert(22);
//		minHeap.insert(9);
//		minHeap.insert(7);

		// maxHeap.print();
		//minHeap.print();
		// System.out.println("Max element in heap: " + maxHeap.extractMax());
		// System.out.println("Min element in heap: " + minHeap.extractMin());
		// System.out.println(maxHeap.deleteMax());
		// maxHeap.print();

//		System.out.println(minHeap.deleteMin());
//		minHeap.print();
		int[] arr = new int[] {Integer.MAX_VALUE,5,3,17,10,9,7,22,19};
//		MinHeapify m = new MinHeapify(arr, arr.length);
//		
//		for(int i=arr.length-1;i>0;i--)
//			m.heapify(i);
//		for(int k:arr)
//			System.out.println(k);
		HeapSort h = new HeapSort(arr, arr.length);
		h.heapSort();
		for(int k:arr)
		System.out.println(k);
		

	}
}
