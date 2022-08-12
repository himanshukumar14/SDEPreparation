package DP;

/**
 * 
 * Given a NxN matrix of positive integers. There are only three possible moves
 * from a cell Matrix[r][c].
 * 
 * Matrix [r+1] [c] Matrix [r+1] [c-1] Matrix [r+1] [c+1] Starting from any
 * column in row 0 return the largest sum of any of the paths up to row N-1.
 * 
 * Example 1:
 * 
 * Input: N = 2 Matrix = {{348, 391}, {618, 193}} Output: 1009 Explaination: The
 * best path is 391 -> 618. It gives the sum = 1009.
 * 
 * Example 2:
 * 
 * Input: N = 2 Matrix = {{2, 2}, {2, 2}} Output: 4 Explaination: No matter
 * which path is chosen, the output is 4.
 *
 */

public class MaximumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maximumPath(int n, int matrix[][]) {
		int[][] dp = new int[n][n];

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (i == 0) {
					dp[i][j] = matrix[i][j];
					max = Math.max(max, dp[i][j]);
					continue;
				}
				int val1 = Integer.MIN_VALUE;
				int val2 = Integer.MIN_VALUE;
				int val3 = Integer.MIN_VALUE;
				if (i - 1 >= 0)
					val1 = dp[i - 1][j];
				if (i - 1 >= 0 && j - 1 >= 0)
					val2 = dp[i - 1][j - 1];
				if (i - 1 >= 0 && j + 1 < n)
					val3 = dp[i - 1][j + 1];
				dp[i][j] = Math.max(val1, Math.max(val2, val3)) + matrix[i][j];
				if (i == n - 1)
					max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}

}
