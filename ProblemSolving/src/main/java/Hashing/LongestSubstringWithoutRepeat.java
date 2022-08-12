package Hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given a string A, find the length of the longest substring without repeating
 * characters.
 * 
 * Note: Users are expected to solve in O(N) time complexity.
 * 
 * 
 * 
 * Problem Constraints 1 <= size(A) <= 106
 * 
 * String consists of lowerCase,upperCase characters and digits are also present
 * in the string A.
 * 
 * 
 * 
 * Input Format Single Argument representing string A.
 * 
 * 
 * 
 * Output Format Return an integer denoting the maximum possible length of
 * substring without repeating characters.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = "abcabcbb" Input 2:
 * 
 * A = "AaaA"
 * 
 * 
 * Example Output Output 1:
 * 
 * 3 Output 2:
 * 
 * 2
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * Substring "abc" is the longest substring without repeating characters in
 * string A. Explanation 2:
 * 
 * Substring "Aa" or "aA" is the longest substring without repeating characters
 * in string A.
 *
 */

public class LongestSubstringWithoutRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int lengthOfLongestSubstring(String A) {
		Set<Character> s = new HashSet<>();
		int i = 0;
		int j = 0;
		int maxLen = 0;
		int len = 0;
		while (j < A.length()) {
			if (!s.contains(A.charAt(j))) {
				s.add(A.charAt(j));
				len++;
				maxLen = Math.max(len, maxLen);
				j++;
			} else {
				while (i < j && s.contains(A.charAt(j))) {
					s.remove(A.charAt(i));
					i++;
					len--;
				}
			}
		}
		return maxLen;
	}

}
