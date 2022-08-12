package DP;

public class UnboundedKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int[] values, int[] weights, int capacity) {
		int n = values.length;

		int[][] dp = new int[n + 1][capacity + 1];
		for (int i = 1; i < n + 1; ++i) {
			for (int j = 1; j < capacity + 1; ++j) {
				if (j - weights[i - 1] >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i][j - weights[i - 1]]); // we take dp[i] here as we can 
																								//again re-use the same element
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][capacity];
	}
	
	// space optimized solution
//	public int solve2(int A, int[] B, int[] C) {
//		int n = B.length;
//
//		int[] dp = new int[A + 1];
//		for (int i = 1; i < n + 1; ++i) {
//			for (int j = 1; j < A + 1; ++j) {
//				if (j - C[i - 1] >= 0) {
//					dp[i][j] = Math.max(dp[i - 1][j], B[i - 1] + dp[i][j - C[i - 1]]);
//				} else {
//					dp[i][j] = dp[i - 1][j];
//				}
//			}
//		}
//		return dp[n][A];
//	}
	

}
