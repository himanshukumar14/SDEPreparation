package DP;

/**
 * 
 * Given an array arr of size N containing non-negative integers, the task is to
 * divide it into two sets S1 and S2 such that the absolute difference between
 * their sums is minimum and find the minimum difference
 * 
 * 
 * Example 1:
 * 
 * Input: N = 4, arr[] = {1, 6, 11, 5} Output: 1 Explanation: Subset1 = {1, 5,
 * 6}, sum of Subset1 = 12 Subset2 = {11}, sum of Subset2 = 11 Example 2: Input:
 * N = 2, arr[] = {1, 4} Output: 3 Explanation: Subset1 = {1}, sum of Subset1 =
 * 1 Subset2 = {4}, sum of Subset2 = 4
 * 
 * Your Task: You don't need to read input or print anything. Complete the
 * function minDifference() which takes N and array arr as input parameters and
 * returns the integer value
 * 
 * Expected Time Complexity: O(N*|sum of array elements|) Expected Auxiliary
 * Space: O(N*|sum of array elements|)
 *
 */

public class MinimumSumPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int findMin(int arr[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];
		boolean dp[][] = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++)
			dp[i][0] = true;

		for (int i = 1; i <= sum; i++)
			dp[0][i] = false;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j - arr[i - 1] >= 0)
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

	
		int diff = Integer.MAX_VALUE;

		// Find the largest j such that dp[n][j]
		// is true where j loops from sum/2 t0 0
		for (int j = sum / 2; j >= 0; j--) {
			if (dp[n][j]) {
				diff = sum - 2 * j;
				break;
			}
		}
		return diff;
	}

}
