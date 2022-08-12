package DP;

/**
 * 
 * Given two strings s and t, return the number of distinct subsequences of s
 * which equals t.
 * 
 * A string's subsequence is a new string formed from the original string by
 * deleting some (can be none) of the characters without disturbing the
 * remaining characters' relative positions. (i.e., "ACE" is a subsequence of
 * "ABCDE" while "AEC" is not).
 * 
 * The test cases are generated so that the answer fits on a 32-bit signed
 * integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "rabbbit", t = "rabbit" Output: 3 Explanation: As shown below,
 * there are 3 ways you can generate "rabbit" from S. rabbbit rabbbit rabbbit
 * Example 2:
 * 
 * Input: s = "babgbag", t = "bag" Output: 5 Explanation: As shown below, there
 * are 5 ways you can generate "bag" from S. babgbag babgbag babgbag babgbag
 * babgbag
 *
 */

public class DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numDistinct(String s, String t) {
		int n = s.length();
		int m = t.length();
		int[][] dp = new int[n][m];
		dp[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
		for (int i = 1; i < m; ++i) {
			dp[0][i] = 0;
		}
		for (int i = 1; i < n; ++i) {
			if (s.charAt(i) == t.charAt(0)) {
				dp[i][0] = 1 + dp[i - 1][0]; // we are adding 1 because
												// we can always form a empty subs
			} else {
				dp[i][0] = dp[i - 1][0];
			}

		}

		for (int i = 1; i < n; ++i) {
			for (int j = 1; j < m; ++j) {
				if (s.charAt(i) == t.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] // incase we consider the equal elements
							+ dp[i - 1][j]; // incase we dont, then consider w/o incl
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n - 1][m - 1];
	}

}
