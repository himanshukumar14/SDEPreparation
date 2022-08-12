package DP;

/**
 * 
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * 
 * Return the number of combinations that make up that amount. If that amount of
 * money cannot be made up by any combination of the coins, return 0.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * The answer is guaranteed to fit into a signed 32-bit integer.
 *
 */

//So in coin change 2 order does not matters so we cannot have coins like {1,3,1} and {3,1,1}
public class CoinChange2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//ways of coin change but where order of coins does not matter that means two different of same set of coins is counted as 1
	public int change(int amount, int[] coins) {
		int n = coins.length;
		int[] dp = new int[amount + 1];

		dp[0] = 1;

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j <= amount; ++j) {
				if (j - coins[i] >= 0)
					dp[j] += dp[j - coins[i]];
			}
		}
		return dp[amount];
	}

}
