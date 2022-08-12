package DP;

/**
 * 
 * Given an array arr[] of size N, check if it can be partitioned into two parts
 * such that the sum of elements in both parts is the same.
 * 
 * Example 1:
 * 
 * Input: N = 4 arr = {1, 5, 11, 5} Output: YES Explaination: The two parts are
 * {1, 5, 5} and {11}. Example 2:
 * 
 * Input: N = 3 arr = {1, 3, 5} Output: NO Explaination: This array can never be
 * partitioned into two such parts.
 *
 */

public class PartitionSubsetEqualSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//Based on subset sum
	public static int equalPartition(int N, int arr[]) {
		int sum = 0;
		for (int i = 0; i < N; ++i) {
			sum += arr[i];
		}

		if (sum % 2 == 1)
			return 0;
		sum /= 2;

		boolean[][] dp = new boolean[N + 1][sum + 1];

		for (int i = 1; i < sum + 1; ++i) {
			dp[0][i] = false;
		}
		for (int i = 0; i < N + 1; ++i) {
			dp[i][0] = true;
		}

		for (int i = 1; i < N + 1; ++i) {
			for (int j = 1; j < sum + 1; ++j) {
				if (j >= arr[i - 1]) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[N][sum] ? 1 : 0;
	}

}
