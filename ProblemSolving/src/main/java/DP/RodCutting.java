package DP;

/**
 * 
 * Given a rod of length n inches and an array of prices that includes prices of
 * all pieces of size smaller than n. Determine the maximum value obtainable by
 * cutting up the rod and selling the pieces. For example, if the length of the
 * rod is 8 and the values of different pieces are given as the following, then
 * the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and
 * 6)
 * 
 * length | 1 2 3 4 5 6 7 8 -------------------------------------------- price |
 * 1 5 8 9 10 17 17 20 And if the prices are as following, then the maximum
 * obtainable value is 24 (by cutting in eight pieces of length 1)
 * 
 * length | 1 2 3 4 5 6 7 8 -------------------------------------------- price |
 * 3 5 8 9 10 17 17 20
 *
 */

public class RodCutting {

	// Unbounded knapsack
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int price[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		int n = price.length;
		int length[] = new int[n];
		for (int i = 0; i < n; i++) {
			length[i] = i + 1;
		}
		int Max_len = n;
		System.out.println("Maximum obtained value is " + cutRod(price, length, Max_len));
	}

	public static int cutRod(int[] price, int[] length, int maxLen) {
		int n = price.length;
		int[][] dp = new int[n + 1][maxLen + 1];
		
		for (int i = 1; i < n + 1; ++i) {
			for (int j = 1; j < maxLen + 1; ++j) {
				if (j - length[i - 1] >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - length[i - 1]] + price[i - 1]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][maxLen];
	}

}
