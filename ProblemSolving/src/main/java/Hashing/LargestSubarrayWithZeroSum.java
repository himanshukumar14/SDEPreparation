package Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of integers, find the length of the longest sub-array with a
 * sum that equals 0.
 * 
 * Examples:
 * 
 * Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23}; Output: 5 Explanation: The
 * longest sub-array with elements summing up-to 0 is {-2, 2, -8, 1, 7}
 * 
 * Input: arr[] = {1, 2, 3} Output: 0 Explanation:There is no subarray with 0
 * sum
 * 
 * Input: arr[] = {1, 0, 3} Output: 1 Explanation: The longest sub-array with
 * elements summing up-to 0 is {0}
 *
 * 
 */

public class LargestSubarrayWithZeroSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxLen(int arr[]) {
		Map<Integer, Integer> map = new HashMap<>();

		int prefixSum = 0;
		int maxLen = 0;
		map.put(0, -1);
		for (int i = 0; i < arr.length; i++) {
			prefixSum += arr[i];

			Integer prev = map.get(prefixSum);
			if (prev != null)
				maxLen = Math.max(maxLen, i - prev);
			else
				map.put(prefixSum, i);
		}

		return maxLen;
	}

}
