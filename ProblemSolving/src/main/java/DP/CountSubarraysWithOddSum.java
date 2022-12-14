package DP;

/**
 * 
 * Given an array of integers arr, return the number of subarrays with an odd
 * sum.
 * 
 * Since the answer can be very large, return it modulo 109 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [1,3,5] Output: 4 Explanation: All subarrays are
 * [[1],[1,3],[1,3,5],[3],[3,5],[5]] All sub-arrays sum are [1,4,9,3,8,5]. Odd
 * sums are [1,9,3,5] so the answer is 4. Example 2:
 * 
 * Input: arr = [2,4,6] Output: 0 Explanation: All subarrays are
 * [[2],[2,4],[2,4,6],[4],[4,6],[6]] All sub-arrays sum are [2,6,12,4,10,6]. All
 * sub-arrays have even sum and the answer is 0. Example 3:
 * 
 * Input: arr = [1,2,3,4,5,6,7] Output: 16
 *
 */

public class CountSubarraysWithOddSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * even + odd = odd 
	 * even + even = even 
	 * odd + even = odd 
	 * odd + odd = even
	 */

	// get count of subarrays ending at index i with either even sum or odd sum
	public int numOfSubarrays(int[] arr) {
		int n = arr.length;
		int[][] countArr = new int[n + 1][2]; // 0 = even 1 = odd
		for (int i = 1; i <= n; ++i) {
			if (arr[i - 1] % 2 == 0) {
				countArr[i][0] = countArr[i - 1][0] + 1;
				countArr[i][1] = countArr[i - 1][1];
			} else if (arr[i - 1] % 2 == 1) {
				countArr[i][0] = countArr[i - 1][1];
				countArr[i][1] = countArr[i - 1][0] + 1;
			}
		}
		int sum = 0;
		for(int i = 1; i <= n; ++i) {
			sum += countArr[i][1];
		}
		return sum;
	}

}
