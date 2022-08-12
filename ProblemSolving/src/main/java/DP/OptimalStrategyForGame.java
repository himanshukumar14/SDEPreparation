package DP;

/**
 * 
 * You are given an array A of size N. The array contains integers and is of
 * even length. The elements of the array represent N coin of values V1, V2,
 * ....Vn. You play against an opponent in an alternating way.
 * 
 * In each turn, a player selects either the first or last coin from the row,
 * removes it from the row permanently, and receives the value of the coin.
 * 
 * You need to determine the maximum possible amount of money you can win if you
 * go first. Note: Both the players are playing optimally.
 * 
 * Example 1:
 * 
 * Input: N = 4 A[] = {5,3,7,10} Output: 15 Explanation: The user collects
 * maximum value as 15(10 + 5) Example 2:
 * 
 * Input: N = 4 A[] = {8,15,3,7} Output: 22 Explanation: The user collects
 * maximum value as 22(7 + 15) Your Task: Complete the function maximumAmount()
 * which takes an array arr[] (represent values of N coins) and N as number of
 * coins as a parameter and returns the maximum possible amount of money you can
 * win if you go first
 *
 */

public class OptimalStrategyForGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static long[][] mem;

	public static long countMaximum(int arr[], int n) {
		mem = new long[n][n];
		return recur(arr, 0, n - 1);
	}

	public static long recur(int[] arr, int l, int r) {
		if (l > r)
			return 0;
		if (mem[l][r] != 0)
			return mem[l][r];
		// pick left coin
		long left = arr[l] + Math.min(recur(arr, l + 2, r), recur(arr, l + 1, r - 1));
		// pick right coin
		long right = arr[r] + Math.min(recur(arr, l + 1, r - 1), recur(arr, l, r - 2));
		mem[l][r] = Math.max(left, right);
		return mem[l][r];
	}

//---------------------------------------------------------------------------------------------------
	// Tushar Roy video

	public boolean optimalStrategyGame(int[] piles) {
		int n = piles.length;

		Pair[][] dp = new Pair[n][n];
		for (int i = 0; i < n; ++i) {
			dp[i][i] = new Pair(piles[i], 0);
		}

		for (int i = 0; i < n - 1; ++i) {
			dp[i][i + 1] = new Pair(Math.max(piles[i], piles[i + 1]), Math.min(piles[i], piles[i + 1]));
		}

		for (int k = 3; k <= n; ++k)
			for (int i = 0; i < n - k + 1; ++i) {
				int j = i + k - 1;
				Pair x;
				if (dp[i + 1][j].second + piles[i] > piles[j] + dp[i][j - 1].second) {
					x = new Pair(dp[i + 1][j].second + piles[i], dp[i + 1][j].first);
				} else if (dp[i + 1][j].second + piles[i] == piles[j] + dp[i][j - 1].second) {
					if (dp[i][j - 1].first < dp[i + 1][j].first) {
						x = new Pair(dp[i][j - 1].second + piles[j], dp[i][j - 1].first);
					} else {
						x = new Pair(dp[i + 1][j].second + piles[i], dp[i + 1][j].first);
					}
				} else {
					x = new Pair(dp[i][j - 1].second + piles[j], dp[i][j - 1].first);
				}
				dp[i][j] = x;
			}
		return dp[0][n - 1].first > dp[0][n - 1].second;
	}

	class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

}
