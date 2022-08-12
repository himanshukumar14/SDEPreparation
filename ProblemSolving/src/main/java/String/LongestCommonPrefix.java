package String;

import java.util.Arrays;

/**
 * 
 * Given a array of N strings, find the longest common prefix among all strings
 * present in the array.
 * 
 * 
 * Example 1:
 * 
 * Input: N = 4 arr[] = {geeksforgeeks, geeks, geek, geezer} Output: gee
 * Explanation: "gee" is the longest common prefix in all the given strings.
 * Example 2:
 * 
 * Input: N = 2 arr[] = {hello, world} Output: -1 Explanation: There's no common
 * prefix in the given strings.
 * 
 * Your Task: You don't need to read input or print anything. Your task is to
 * complete the function longestCommonPrefix() which takes the string array
 * arr[] and its size N as inputs and returns the longest common prefix common
 * in all the strings in the array. If there's no prefix common in all the
 * strings, return "-1".
 * 
 * 
 * Expected Time Complexity: O(N*max(|arri|)). Expected Auxiliary Space:
 * O(max(|arri|)) for result.
 *
 */

public class LongestCommonPrefix {

	// O(m * n)
	public static String commonPrefixUtil(String str1, String str2) {
		String result = "";
		int n1 = str1.length();
		int n2 = str2.length();

		for (int i = 0, j = 0; i < n1 && j < n2; i++, j++) {
			if (str1.charAt(i) != str2.charAt(j))
				break;
			result += str1.charAt(i);
		}

		return (result);
	}

	public static String commonPrefix(String arr[], int n) {
		String prefix = arr[0];
		for (int i = 1; i <= n - 1; i++) {
			prefix = commonPrefixUtil(prefix, arr[i]);
		}
		return (prefix);
	}

	public static void main(String[] args) {
		String arr[] = { "geeksforgeeks", "geeks", "geek", "geezer" };
		int n = arr.length;

		String ans = commonPrefix(arr, n);

		if (ans.length() > 0) {
			System.out.printf("The longest common prefix is - %s", ans);
		} else {
			System.out.printf("There is no common prefix");
		}
	}

	// -------------------------------------------------------------------------------------------------
	
	public String longestCommonPrefix(String[] strs) {
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
