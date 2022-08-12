package DP;

/**
 * 
 * Given an array of n positive integers. Find the sum of the maximum sum
 * subsequence of the given array such that the integers in the subsequence are
 * sorted in increasing order i.e. increasing subsequence.
 * 
 * Example 1:
 * 
 * Input: N = 5, arr[] = {1, 101, 2, 3, 100} Output: 106 Explanation:The maximum
 * sum of a increasing sequence is obtained from {1, 2, 3, 100} Example 2:
 * 
 * Input: N = 3, arr[] = {1, 2, 3} Output: 6 Explanation:The maximum sum of a
 * increasing sequence is obtained from {1, 2, 3}
 *
 */

public class MaximumSumIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int increasingSubsequence(int[] arr, int n) {
		int[] dp = new int[n];
		for (int i = 0; i < n; ++i) {
			dp[i] = arr[i];
		}
		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (arr[i] > arr[j])
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);

			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; ++i) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}

}
