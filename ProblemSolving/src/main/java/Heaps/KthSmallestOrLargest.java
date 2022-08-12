package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * Given an array and a number k where k is smaller than the size of the array,
 * we need to find the k’th smallest element in the given array. It is given
 * that all array elements are distinct.
 * 
 * Examples:
 * 
 * Input: arr[] = {7, 10, 4, 3, 20, 15} k = 3 Output: 7
 * 
 * Input: arr[] = {7, 10, 4, 3, 20, 15} k = 4 Output: 10
 *
 */

public class KthSmallestOrLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 7, 10, 4, 3, 20, 15 };
		int k = 3;
		System.out.println(smallest(arr, k));
		System.out.println(largest(arr, k));
		arr = new int[] { 7, 10, 4, 3, 20, 15 };
		k = 4;
		System.out.println(smallest(arr, k));
		System.out.println(largest(arr, k));
	}

	public static int smallest(int[] arr, int k) {
		int n = arr.length;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});

		for (int i = 0; i < k; ++i) {
			maxHeap.add(arr[i]);
		}

		for (int i = k; i < n; ++i) {
			if (maxHeap.peek() > arr[i]) {
				maxHeap.remove();
				maxHeap.add(arr[i]);
			}
		}

		return maxHeap.peek();
	}
	
	public static int largest(int[] arr, int k) {
		int n = arr.length;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});

		for (int i = 0; i < k; ++i) {
			maxHeap.add(arr[i]);
		}

		for (int i = k; i < n; ++i) {
			if (maxHeap.peek() < arr[i]) {
				maxHeap.remove();
				maxHeap.add(arr[i]);
			}
		}

		return maxHeap.peek();
	}

}
