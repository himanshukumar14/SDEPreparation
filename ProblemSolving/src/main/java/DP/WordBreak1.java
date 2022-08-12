package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Given a string s and a dictionary of strings wordDict, return true if s can
 * be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the
 * segmentation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "leetcode", wordDict = ["leet","code"] Output: true Explanation:
 * Return true because "leetcode" can be segmented as "leet code". Example 2:
 * 
 * Input: s = "applepenapple", wordDict = ["apple","pen"] Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple". Note that you are allowed to reuse a dictionary word. Example 3:
 * 
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"] Output:
 * false
 *
 */

public class WordBreak1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "iamace";
		List<String> dict = new ArrayList<>();
		dict.add("i");
		dict.add("am");
		dict.add("ace");
		System.out.println(wordBreak(test, dict));
	}

	// O(N3) solution
	public static boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		Set<String> dict = new HashSet<>(wordDict);
		boolean[][] dp = new boolean[n][n];

		for (int i = 0; i < n; ++i) {
			if (dict.contains(String.valueOf(s.charAt(i))))
				dp[i][i] = true;
		}

		for (int k = 2; k <= n; ++k) {
			for (int i = 0; i < n - k + 1; ++i) {
				int j = i + k - 1;
				if (dict.contains(s.substring(i, j + 1))) {
					dp[i][j] = true;
				} else {
					dp[i][j] = isPartition(s, dp, i, j);
				}
			}
		}
		return dp[0][n - 1];
	}

	public static boolean isPartition(String s, boolean[][] dp, int i, int j) {
		for (int k = i; k < j; ++k) {
			if (dp[i][k] && dp[k + 1][j]) {
				return true;
			}
		}
		return false;
	}

	// -----------------------------------------------------------------------------------------------------------

	// O(N2) solution similar to palindrome partition

	public boolean wordBreak2(String s, List<String> wordDict) {
		if (s == null || s.length() == 0)
			return false;
		Set<String> dict = new HashSet<>(wordDict);
		int n = s.length();
		boolean[] dp = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (dict.contains(s.substring(0, i + 1))) {
				dp[i] = true;
			} else {
				for (int j = 0; j < i; ++j) {
					if (dict.contains(s.substring(j + 1, i + 1)) && dp[j]) {
						dp[i] = true;
						break;
					}
				}
			}
		}
		return dp[n - 1];
	}
}
