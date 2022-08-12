package DP;

/**
 * 
 * Given a string s, find the longest palindromic subsequence's length in s.
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 * Example 1:
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 * 
 * Example 2:
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 *
 */

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; ++i) {
			dp[i][i] = 1;
		}

		for (int i = 0; i < n - 1; ++i) {
			if (s.charAt(i) == s.charAt(i + 1))
				dp[i][i + 1] = 2;
			else
				dp[i][i + 1] = 1;
		}

		for (int k = 3; k <= n; ++k) {
			for (int i = 0; i < n - k + 1; ++i) {
				int j = i + k - 1;
				if (s.charAt(i) == s.charAt(j))
					dp[i][j] = 2 + dp[i + 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
			}
		}
		return dp[0][n - 1];
	}

}
