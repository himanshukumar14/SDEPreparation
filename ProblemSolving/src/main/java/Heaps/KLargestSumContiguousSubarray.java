package Heaps;

import java.util.PriorityQueue;

/**
 * 
 * Given an array of integers. Write a program to find the K-th largest sum of
 * contiguous subarray within the array of numbers which has negative and
 * positive numbers.
 * 
 * Examples:
 * 
 * Input: a[] = {20, -5, -1} k = 3 Output: 14 Explanation: All sum of contiguous
 * subarrays are (20, 15, 14, -5, -6, -1) so the 3rd largest sum is 14.
 * 
 * Input: a[] = {10, -10, 20, -40} k = 6 Output: -10 Explanation: The 6th
 * largest sum among sum of all contiguous subarrays is -10.
 *
 */

public class KLargestSumContiguousSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[] { 10, -10, 20, -40 };
		int k = 6;

		System.out.println(kthLargestSum(a, k));
	}

	public static int kthLargestSum(int arr[], int k) {
		int n = arr.length;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				if (pq.size() < k)
					pq.add(sum);
				else {
					if (pq.peek() < sum) {
						pq.poll();
						pq.add(sum);
					}
				}
			}
		}
		return pq.poll();
	}

}
