package DP;

/**
 * Given a string s, return the longest palindromic substring in s.
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.

 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 */


public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String longestPalindrome(String s) {
		int n = s.length();
		int maxLen = 1;
		int start = 0;
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; ++i) {
			dp[i][i] = 1;
		}

		for (int i = 0; i < n - 1; ++i) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = 1;
				start = i;
				maxLen = 2;
			}
		}

		for (int k = 3; k <= n; ++k) {
			for (int i = 0; i < n - k + 1; ++i) {
				int j = i + k - 1;
				if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
					dp[i][j] = 1;
					if (k > maxLen) {
						maxLen = k;
						start = i;
					}
				}
			}
		}
		
		return s.substring(start, start + maxLen);
	}

}
