package DP;

/**
 * 
 * Given a string str, find the length of the longest repeating subsequence such
 * that it can be found twice in the given string. The two identified
 * subsequences A and B can use the same ith character from string str if and
 * only if that ith character has different indices in A and B.
 * 
 * Example 1:
 * 
 * Input: str = "axxzxy" Output: 2 Explanation: The given array with indexes
 * looks like a x x z x y 0 1 2 3 4 5
 * 
 * The longest subsequence is "xx". It appears twice as explained below.
 * 
 * subsequence A x x 0 1 <-- index of subsequence A ------ 1 2 <-- index of str
 * 
 * 
 * subsequence B x x 0 1 <-- index of subsequence B ------ 2 4 <-- index of str
 * 
 * We are able to use character 'x' (at index 2 in str) in both subsequences as
 * it appears on index 1 in subsequence A and index 0 in subsequence B.
 *
 */

public class LongestRepeatingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestRepeatingSubsequence(String str) {
		int n = str.length();

		int[][] dp = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; ++i) {
			for (int j = 1; j < n + 1; ++j) {
				if (str.charAt(i - 1) == str.charAt(j - 1) && i - 1 != j - 1)
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[n][n];
	}

}
