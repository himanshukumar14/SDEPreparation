package Trie;

import java.util.Arrays;

/**
 * 
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: strs = ["flower","flow","flight"] Output: "fl" Example 2:
 * 
 * Input: strs = ["dog","racecar","car"] Output: "" Explanation: There is no
 * common prefix among the input strings.
 *
 */

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String longestCommonPrefix(String[] strs) {
		Arrays.sort(strs);
		String first = strs[0];
		String last = strs[strs.length - 1];
		int len = Math.min(first.length(), last.length());

		int i = 0;
		for (; i < len; ++i) {
			if (first.charAt(i) != last.charAt(i))
				break;
		}

		return i == 0 ? "" : first.substring(0, i);
	}

}
