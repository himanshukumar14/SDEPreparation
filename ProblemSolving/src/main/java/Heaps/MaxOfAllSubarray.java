package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * Given an array and an integer K, find the maximum for each and every
 * contiguous subarray of size k.
 * 
 * Examples :
 * 
 * Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3 Output: 3 3 4 5 5 5 6
 * Explanation: Maximum of 1, 2, 3 is 3 Maximum of 2, 3, 1 is 3 Maximum of 3, 1,
 * 4 is 4 Maximum of 1, 4, 5 is 5 Maximum of 4, 5, 2 is 5 Maximum of 5, 2, 3 is
 * 5 Maximum of 2, 3, 6 is 6
 * 
 * Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4 Output: 10 10 10 15
 * 15 90 90 Explanation: Maximum of first 4 elements is 10, similarly for next 4
 * elements (i.e from index 1 to 4) is 10, So the sequence generated is 10 10 10
 * 15 15 90 90
 *
 */

public class MaxOfAllSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
		int k = 3;
		maxOfSubarray(arr, k);
	}

	public static int[] maxOfSubarray(int[] arr, int k) {
		int n = arr.length;
		int[] ans = new int[n - k + 1];
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});

		for (int i = 0; i < k; ++i) {
			pq.add(arr[i]);
		}

		int i = k;
		int j = 0;
		while (i < n) {
			ans[j] = pq.peek();
			pq.add(arr[i++]);
			pq.remove(arr[j++]);
		}
		ans[j] = pq.peek();
		return ans;
	}

}
