package DP;

/**
 * 
 * Given a string s, find the count of odd length palindrome subsequence of A where A[i] is center
 *
 */

public class OddPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ans = getOddLengthPalindrome("xyzx");
		for(int x : ans) {
			System.out.println(x);
		}
	}

	public static int[] getOddLengthPalindrome(String s) {
		int n = s.length();
		int[] ans = new int[n];

		for (int i = 0; i < n; ++i) {
			StringBuilder s1 = new StringBuilder(s.substring(0, i));
			StringBuilder s2 = new StringBuilder(s.substring(i + 1, n));
			ans[i] = 1 + countOfCommonSubsequence(s1.toString(), s2.reverse().toString());
		}
		return ans;
	}

	public static int countOfCommonSubsequence(String s, String t) {
		int n1 = s.length();
		int n2 = t.length();
		int dp[][] = new int[n1 + 1][n2 + 1];
		char ch1, ch2;

		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				ch1 = s.charAt(i - 1);
				ch2 = t.charAt(j - 1);
				// if we consider both i && j element then, 1 + dp[i + 1][j - 1]
				// and if we don't consider then dp[i-1][j] + dp[i][j-1] - dp[i + 1][j - 1], so
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
