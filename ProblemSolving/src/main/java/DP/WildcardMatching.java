package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an input string (s) and a pattern (p), implement wildcard pattern
 * matching with support for '?' and '*' where:
 * 
 * '?' Matches any single character. '*' Matches any sequence of characters
 * (including the empty sequence). The matching should cover the entire input
 * string (not partial).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aa", p = "a" Output: false Explanation: "a" does not match the
 * entire string "aa".
 * 
 * Example 2:
 * 
 * Input: s = "aa", p = "*" Output: true Explanation: '*' matches any sequence.
 * 
 * Example 3:
 * 
 * Input: s = "cb", p = "?a" Output: false Explanation: '?' matches 'c', but the
 * second letter is 'a', which does not match 'b'.
 *
 */

public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isMatch(String s, String p) {
		Map<String, Boolean> memo = new HashMap<>();
		return helper(s, p, 0, 0, memo);
	}

	public static boolean helper(String s, String p, int startS, int startP, Map<String, Boolean> memo) {
		if (memo.containsKey(startS + "-" + startP))
			return memo.get(startS + "-" + startP);
		boolean res = false;
		if (startS == s.length() && startP == p.length())
			res = true;
		else if (startP == p.length())
			res = false;
		else if (startS == s.length())
			res = p.charAt(startP) == '*' && helper(s, p, startS, startP + 1, memo);
		else if (p.charAt(startP) == '*')
			res = helper(s, p, startS + 1, startP, memo) || helper(s, p, startS, startP + 1, memo);
		else if (p.charAt(startP) == '?' || p.charAt(startP) == s.charAt(startS))
			res = helper(s, p, startS + 1, startP + 1, memo);
		else
			res = false;
		memo.put(startS + "-" + startP, res);
		return res;
	}

	public static boolean isMatch2(String s, String p) {
		int n = s.length();
		int m = p.length();
		boolean[][] dp = new boolean[n + 1][m + 1];
		dp[0][0] = true;

		if(m > 0 && p.charAt(0) == '*')
			dp[0][1] = true;

		for (int i = 1; i < n + 1; ++i) {
			for (int j = 1; j < m + 1; ++j) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[n][m];
	}

}
