package DP;

/**
 * 
 * Given two sequences, find the length of longest subsequence present in both
 * of them. Both the strings are of uppercase.
 * 
 * Example 1:
 * 
 * Input: A = 6, B = 6 str1 = ABCDGH str2 = AEDFHR Output: 3 Explanation: LCS
 * for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3. Example 2:
 * 
 * Input: A = 3, B = 2 str1 = ABC str2 = AC Output: 2 Explanation: LCS of "ABC"
 * and "AC" is "AC" of length 2.
 *
 */

public class LongestCommonSubsequence {

	// we can track the path to determine what was the longest common subsequence -
	// Tushar Roy
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text1 = "geeks";//geeks geeksfor geeksforgeeks
		String text2 = "geeksfor";
		longestCommonSubsequence(text1, text2);
		System.out.println(sb.toString());
		System.out.println(sb.length());
	}

	public static int longestCommonSubsequence(String text1, String text2) {
		int l1 = text1.length();
		int l2 = text2.length();

		int[][] dp = new int[l1 + 1][l2 + 1];

		for (int i = 1; i < l1 + 1; ++i) {
			for (int j = 1; j < l2 + 1; ++j) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		getLongestSubseqString(text1, text2, dp, l1, l2);
		return dp[l1][l2];
	}

	// space optimized solution ---- O(N) space
	public int longestCommonSubsequence2(String text1, String text2) {
		int l1 = text1.length();
		int l2 = text2.length();

		int[][] dp = new int[2][l2 + 1];
		for (int i = 1; i < l1 + 1; ++i) {
			for (int j = 1; j < l2 + 1; ++j) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + 1;
				} else {
					dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
				}
			}
		}
		return dp[l1 % 2][l2];
	}

	// Backtrack to find longest common subsequence string
	public static StringBuilder sb = new StringBuilder();

	public static void getLongestSubseqString(String t1, String t2, int[][] dp, int l, int r) {
		if (l == 0 || r == 0)
			return;
		if (t1.charAt(l - 1) == t2.charAt(r - 1)) {
			sb.insert(0, t1.charAt(l - 1));
			getLongestSubseqString(t1, t2, dp, l - 1, r - 1);
		} else {
			if (dp[l][r] == dp[l - 1][r]) {
				getLongestSubseqString(t1, t2, dp, l - 1, r);
			} else {
				getLongestSubseqString(t1, t2, dp, l, r - 1);
			}
		}
	}

}
