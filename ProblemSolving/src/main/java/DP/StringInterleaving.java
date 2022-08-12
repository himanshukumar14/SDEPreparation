package DP;

/**
 * 
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of
 * s1 and s2.
 * 
 * An interleaving of two strings s and t is a configuration where they are
 * divided into non-empty substrings such that:
 * 
 * s = s1 + s2 + ... + sn t = t1 + t2 + ... + tm |n - m| <= 1 The interleaving
 * is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 * 
 * Example 1:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac" Output: true
 * 
 * Example 2:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc" Output: false 
 * 
 * Example 3:
 * Input: s1 = "", s2 = "", s3 = "" Output: true
 *
 */

public class StringInterleaving {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null && s2 == null && s3 == null)
			return true;
		if (s1 == null || s2 == null || s3 == null)
			return false;
		int n = s1.length();
		int m = s2.length();
		int p = s3.length();

		if (n + m != p)
			return false;

		boolean[][] dp = new boolean[n + 1][m + 1];
		dp[0][0] = true;
		for (int i = 1; i < n + 1; ++i) {
			if (s3.charAt(i - 1) == s1.charAt(i - 1))
				dp[i][0] = dp[i - 1][0];
			else
				dp[i][0] = false;
		}
		for (int i = 1; i < m + 1; ++i) {
			if (s3.charAt(i - 1) == s2.charAt(i - 1))
				dp[0][i] = dp[0][i - 1];
			else
				dp[0][i] = false;
		}
		for (int i = 1; i < n + 1; ++i) {
			for (int j = 1; j < m + 1; ++j) {
				if (s3.charAt(i + j - 1) == s1.charAt(i - 1) && s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
				} else if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
					dp[i][j] = dp[i - 1][j];
				} else if (s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i][j - 1];
				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[n][m];
	}

}
