package DP;

/**
 * 
 * Given an array of n size, the task is to find the longest subsequence such
 * that difference between adjacents is one.
 * 
 * Examples:
 * 
 * Input : arr[] = {10, 9, 4, 5, 4, 8, 6} Output : 3 As longest subsequences
 * with difference 1 are, "10, 9, 8", "4, 5, 4" and "4, 5, 6"
 * 
 * Input : arr[] = {1, 2, 3, 2, 3, 7, 2, 1} Output : 7 As longest consecutive
 * sequence is "1, 2, 3, 2, 3, 2, 1"
 *
 */

public class LongestSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// use LIS
	static int longestSubsequence(int N, int A[]) {
		// code here
		int[] dp = new int[N];
		for (int i = 0; i < N; ++i) {
			dp[i] = 1;
		}

		int max = 1;
		for (int i = 1; i < N; ++i) {
			for (int j = 0; j < i; ++j) {
				if (Math.abs(A[i] - A[j]) == 1)
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

}
