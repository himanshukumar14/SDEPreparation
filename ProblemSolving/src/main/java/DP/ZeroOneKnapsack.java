package DP;

/**
 * 
 * Given two integer arrays A and B of size N each which represent values and
 * weights associated with N items respectively.
 * 
 * Also given an integer C which represents knapsack capacity.
 * 
 * Find out the maximum value subset of A such that sum of the weights of this
 * subset is smaller than or equal to C.
 * 
 * --Select items from A such that it's value is maximized and sum of the
 * weights is within given capacity--
 * 
 * NOTE:
 * 
 * You cannot break an item, either pick the complete item, or don�t pick it
 * (0-1 property).
 *
 */

public class ZeroOneKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int[] values, int[] weights, int capacity) {
		int n = values.length;
		int[][] dp = new int[n + 1][capacity + 1];
		for (int i = 1; i < n + 1; ++i) {
			for (int j = 1; j < capacity + 1; ++j) {
				if (j - weights[i - 1] >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][capacity];
	}

	// space optimized solution
	public int solve2(int[] values, int[] weights, int capacity) {
		int n = values.length;
		int[][] dp = new int[2][capacity + 1];
		int flag = 0;
		for (int i = 1; i < n + 1; ++i) {
			for (int j = 1; j < capacity + 1; ++j) {
				if (j - weights[i - 1] >= 0) {
					dp[1 - (flag % 2)][j] = Math.max(dp[(flag % 2)][j],
							values[i - 1] + dp[(flag % 2)][j - weights[i - 1]]);
				} else {
					dp[1 - (flag % 2) + 1][j] = dp[(flag % 2)][j];
				}
			}
			flag++;
		}
		return dp[(flag % 2)][capacity];
	}

	// track the items selected
}
