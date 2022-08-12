package DP;

import java.util.Arrays;

/**
 * 
 * A and B are playing a game. At the beginning there are n coins. Given two
 * more numbers x and y. In each move a player can pick x or y or 1 coins. A
 * always starts the game. The player who picks the last coin wins the game or
 * the person who is not able to pick any coin loses the game. For a given value
 * of n, find whether A will win the game or not if both are playing optimally.
 * 
 * Examples:
 * 
 * Input : n = 5, x = 3, y = 4 Output : A There are 5 coins, every player can
 * pick 1 or 3 or 4 coins on his/her turn. A can win by picking 3 coins in first
 * chance. Now 2 coins will be left so B will pick one coin and now A can win by
 * picking the last coin.
 * 
 * Input : 2 3 4 Output : B
 *
 */

public class CoinGameWinner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean findWinner(int x, int y, int n) {
		boolean[] dp = new boolean[n + 1];
		Arrays.fill(dp, false);

		dp[0] = false;
		dp[1] = true;

		for (int i = 2; i <= n; i++) {
			if (i - 1 >= 0 && dp[i - 1] == false)
				dp[i] = true;
			else if (i - x >= 0 && dp[i - x] == false)
				dp[i] = true;
			else if (i - y >= 0 && dp[i - y] == false)
				dp[i] = true;
			else
				dp[i] = false;
		}
		return dp[n];
	}

}
