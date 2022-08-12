package DP;

/**
 * 
 * Given two strings. The task is to find the length of the longest common
 * substring.
 * 
 * 
 * Example 1:
 * 
 * Input: S1 = "ABCDGH", S2 = "ACDGHR" Output: 4 Explanation: The longest common
 * substring is "CDGH" which has length 4. Example 2:
 * 
 * Input: S1 = "ABC", S2 "ACB" Output: 1 Explanation: The longest common
 * substrings are "A", "B", "C" all having length 1.
 *
 */

public class LongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestCommonSubstr(String S1, String S2, int n, int m) {
		int[][] dp = new int[n + 1][m + 1];
		int max = 0;
		for (int i = 1; i < n + 1; ++i) {
			for (int j = 1; j < m + 1; ++j) {
				if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(max, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return max;
	}

}
