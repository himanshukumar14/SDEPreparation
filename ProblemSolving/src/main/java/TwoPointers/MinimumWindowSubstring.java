package TwoPointers;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given two strings s and t of lengths m and n respectively, return the minimum
 * window substring of s such that every character in t (including duplicates)
 * is included in the window. If there is no such substring, return the empty
 * string "".
 * 
 * The testcases will be generated such that the answer is unique.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "ADOBECODEBANC", t = "ABC" Output: "BANC" Explanation: The minimum
 * window substring "BANC" includes 'A', 'B', and 'C' from string t. Example 2:
 * 
 * Input: s = "a", t = "a" Output: "a" Explanation: The entire string s is the
 * minimum window. Example 3:
 * 
 * Input: s = "a", t = "aa" Output: "" Explanation: Both 'a's from t must be
 * included in the window. Since the largest window of s only has one 'a',
 * return empty string.
 *
 */

/**
 * Solution:::: The question asks us to return the minimum window from the
 * string SS which has all the characters of the string TT. Let us call a window
 * desirable if it has all the characters from TT.
 * 
 * We can use a simple sliding window approach to solve this problem.
 * 
 * In any sliding window based problem we have two pointers. One rightright
 * pointer whose job is to expand the current window and then we have the
 * leftleft pointer whose job is to contract a given window. At any point in
 * time only one of these pointers move and the other one remains fixed.
 * 
 * The solution is pretty intuitive. We keep expanding the window by moving the
 * right pointer. When the window has all the desired characters, we contract
 * (if possible) and save the smallest window till now.
 * 
 * The answer is the smallest desirable window.
 * 
 * For eg. S = "ABAACBAB" T = "ABC". Then our answer window is "ACB" and shown
 * below is one of the possible desirable windows.
 * 
 *
 */
public class MinimumWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String minWindow(String s, String t) {
		if (s.length() == 0 || t.length() == 0) {
			return "";
		}
		int n = s.length();
		int m = t.length();

		int l = 0;
		int r = 0;
		int formed = 0;
		Map<Character, Integer> dict = new HashMap<>();
		for (int i = 0; i < m; ++i) {
			char c = t.charAt(i);
			dict.put(c, dict.getOrDefault(c, 0) + 1);
		}
		int target = dict.size();
		int[] ans = new int[] { -1, 0, 0 };
		Map<Character, Integer> count = new HashMap<>();
		while (r < n) {
			char c = s.charAt(r);
			count.put(c, count.getOrDefault(c, 0) + 1);

			if (dict.containsKey(c) && count.get(c).intValue() == dict.get(c).intValue()) {
				formed++;
			}

			while (l <= r && formed == target) {
				if (ans[0] == -1 || ans[0] > r - l + 1) {
					ans[0] = r - l + 1;
					ans[1] = l;
					ans[2] = r;
				}
				char cb = s.charAt(l);
				if (dict.containsKey(cb) && count.get(cb).intValue() == dict.get(cb).intValue()) {
					formed--;
				}
				count.put(cb, count.getOrDefault(cb, 0) - 1);
				l++;
			}
			r++;
		}
		return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
	}

}
