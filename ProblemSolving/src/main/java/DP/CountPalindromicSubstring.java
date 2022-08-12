package DP;

/**
 * 
 * Given a string s, return the number of palindromic substrings in it.
 * 
 * A string is a palindrome when it reads the same backward as forward.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abc" Output: 3 Explanation: Three palindromic strings: "a", "b",
 * "c". Example 2:
 * 
 * Input: s = "aaa" Output: 6 Explanation: Six palindromic strings: "a", "a",
 * "a", "aa", "aa", "aaa".
 *
 */

public class CountPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countSubstrings(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		int count = 0;
		for (int i = 0; i < n; ++i) {
			dp[i][i] = 1;
			count++;
		}

		for (int i = 0; i < n - 1; ++i) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = 1;
				count++;
			}
		}

		for (int k = 3; k <= n; ++k) {
			for (int i = 0; i < n - k + 1; ++i) {
				int j = i + k - 1;
				if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
					dp[i][j] = 1;
					count++;
				}
			}
		}

		return count;
	}

}
