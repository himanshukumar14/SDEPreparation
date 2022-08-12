package DP;

/**
 * 
 * Given an input string s and a pattern p, implement regular expression
 * matching with support for '.' and '*' where:
 * 
 * '.' Matches any single character.​​​​ '*' Matches zero or more of the
 * preceding element. The matching should cover the entire input string (not
 * partial).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aa", p = "a" Output: false Explanation: "a" does not match the
 * entire string "aa". Example 2:
 * 
 * Input: s = "aa", p = "a*" Output: true Explanation: '*' means zero or more of
 * the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes
 * "aa". Example 3:
 * 
 * Input: s = "ab", p = ".*" Output: true Explanation: ".*" means "zero or more
 * (*) of any character (.)".
 *
 */

public class RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}
		if (p.length() > 1 && p.charAt(1) == '*') {
			if (isMatch(s, p.substring(2))) {
				return true;
			}
			if (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
				return isMatch(s.substring(1), p);
			}
			return false;
		} else {
			if (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
				return isMatch(s.substring(1), p.substring(1));
			}
			return false;
		}
	}

	public static boolean isMatch2(String s, String p) {
		int n = s.length();
		int m = p.length();

		boolean[][] dp = new boolean[n + 1][m + 1];
		dp[0][0] = true;

		for (int i = 1; i < m + 1; ++i) {
			if (p.charAt(i - 1) == '*')
				dp[0][i] = dp[0][i - 2];
		}

		for (int i = 1; i < n + 1; ++i) {
			for (int j = 1; j < m + 1; ++j) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 2]; // for zero occurrence of preceding character
					if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
						dp[i][j] = dp[i][j] || dp[i - 1][j];
					}
				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[n][m];
	}

}
