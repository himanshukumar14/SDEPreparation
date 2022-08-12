package DP;

/**
 * 
 * Given two string S and Q. The task is to count the number of the common
 * subsequence in S and T.
 * 
 * Examples:
 * 
 * Input : S = “ajblqcpdz”, T = “aefcnbtdi” Output : 11 Common subsequences are
 * : { “a”, “b”, “c”, “d”, “ab”, “bd”, “ad”, “ac”, “cd”, “abd”, “acd” }
 * 
 * Input : S = “a”, T = “ab” Output : 1
 *
 */

public class CountOfCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countOfCommonSubsequence(String s, String t) {
		int n1 = s.length();
		int n2 = t.length();
		int dp[][] = new int[n1 + 1][n2 + 1];
		char ch1, ch2;

		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				ch1 = s.charAt(i - 1);
				ch2 = t.charAt(j - 1);
				// if we consider both i && j element then, 1 + dp[i - 1][j - 1]
				// and if we don't consider then dp[i-1][j] + dp[i][j-1] - dp[i - 1][j - 1]
				// (subtract since this part counted twice), so
				// total leads to below
				if (ch1 == ch2)
					dp[i][j] = 1 + dp[i][j - 1] + dp[i - 1][j];
				else
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
			}
		}

		return dp[n1][n2];
	}
}
