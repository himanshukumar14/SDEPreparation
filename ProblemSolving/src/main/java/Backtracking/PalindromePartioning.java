package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome. Return all possible palindrome partitioning of s.
 * 
 * A palindrome string is a string that reads the same backward as forward.
 * 
 * Example 1:
 * 
 * Input: s = "aab" Output: [["a","a","b"],["aa","b"]] Example 2:
 * 
 * Input: s = "a" Output: [["a"]]
 *
 */

public class PalindromePartioning {

	public static void main(String[] args) {

	}

	List<List<String>> ans = new ArrayList<>();

	public List<List<String>> partition(String s) {
		List<String> l = new ArrayList<>();
		recur(s, s.length(), 0, l);
		return ans;
	}

	public void recur(String s, int n, int index, List<String> l) {
		if (index == n) {
			ans.add(new ArrayList<String>(l));
			return;
		}
		for (int i = index; i < n; ++i) {
			String temp = s.substring(index, i + 1);
			if (isPalindrome(temp)) {
				l.add(temp);
				recur(s, n, i + 1, l);
				l.remove(l.size() - 1);
			}
		}
	}

	public boolean isPalindrome(String s) {
		int l = 0;
		int r = s.length() - 1;
		while (l < r) {
			if (s.charAt(l) != s.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}

}
