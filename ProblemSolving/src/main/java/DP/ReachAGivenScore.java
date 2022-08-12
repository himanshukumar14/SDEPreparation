package DP;

import java.util.Arrays;

/**
 * 
 * Consider a game where a player can score 3 or 5 or 10 points in a move. Given
 * a total score n, find number of distinct combinations to reach the given
 * score.
 * 
 * Example: Input 3 8 20 13 Output 1 4 2 Explanation For 1st example when n = 8
 * { 3, 5 } and {5, 3} are the two possible permutations but these represent the
 * same cobmination. Hence output is 1.
 *
 * 
 */

public class ReachAGivenScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long count(int n) {
		long[] dp = new long[(int) n + 1];
		Arrays.fill(dp, 0);
		dp[0] = 1;
		int[] score = new int[] { 3, 5, 10 };
		// Add your code here.
		for (int i = 0; i < score.length; ++i) {
			for (int j = 1; j < n + 1; ++j) {
				if (j - score[i] >= 0)
					dp[j] += dp[j - score[i]];
			}
		}

		return dp[n];
	}

}
