package DP;

/**
 * 
 * Given two strings word1 and word2, return the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following three operations permitted on a word:
 * 
 * Insert a character Delete a character Replace a character
 * 
 * 
 * Example 1:
 * 
 * Input: word1 = "horse", word2 = "ros" Output: 3 Explanation: horse -> rorse
 * (replace 'h' with 'r') rorse -> rose (remove 'r') rose -> ros (remove 'e')
 *
 */

public class EditDistance {

	// we can track the path to determine what was the edited chars - Tushar Roy
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// check Tushar Roy video
	public int minDistance(String word1, String word2) {
		int l1 = word1.length();
		int l2 = word2.length();
		if (l1 == 0 || l2 == 0)
			return Math.abs(l1 - l2);
		int[][] dp = new int[l1 + 1][l2 + 1];
		dp[0][0] = 0;

		for (int i = 1; i <= l1; ++i) {
			dp[i][0] = dp[i - 1][0] + 1;
		}

		for (int i = 1; i <= l2; ++i) {
			dp[0][i] = dp[0][i - 1] + 1;
		}

		for (int i = 1; i <= l1; ++i) {
			for (int j = 1; j <= l2; ++j) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
			}
		}
		return dp[l1][l2];
	}

	// backtrack to find edited chars
	public void getOrder(int i, int j, String word1, String word2, int[][] dp) {
		if (i == 0 || j == 0)
			return;
		if (word1.charAt(i) == word2.charAt(j)) {
			System.out.println("No change");
			getOrder(i - 1, j - 1, word1, word2, dp);
		} else {
			int val1 = dp[i - 1][j]; // delete
			int val2 = dp[i - 1][j - 1]; // replace
			int val3 = dp[i][j - 1]; // insert
			if (val1 <= val2 && val1 < val3) {
				System.out.println("delete " + word1.charAt(i));
				getOrder(i - 1, j, word1, word2, dp);
			} else if (val2 <= val3 && val2 < val1) {
				System.out.println("replace " + word1.charAt(i) + " with " + word2.charAt(j));
				getOrder(i - 1, j - 1, word1, word2, dp);
			} else {
				System.out.println("insert " + word2.charAt(j));
				getOrder(i, j - 1, word1, word2, dp);
			}
		}
	}

}
