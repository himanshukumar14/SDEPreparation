package DP;

/**
 * 
 * The variance of a string is defined as the largest difference between the
 * number of occurrences of any 2 characters present in the string. Note the two
 * characters may or may not be the same.
 * 
 * Given a string s consisting of lowercase English letters only, return the
 * largest variance possible among all substrings of s.
 * 
 * A substring is a contiguous sequence of characters within a string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aababbb" Output: 3 Explanation: All possible variances along with
 * their respective substrings are listed below: - Variance 0 for substrings
 * "a", "aa", "ab", "abab", "aababb", "ba", "b", "bb", and "bbb". - Variance 1
 * for substrings "aab", "aba", "abb", "aabab", "ababb", "aababbb", and "bab". -
 * Variance 2 for substrings "aaba", "ababbb", "abbb", and "babb". - Variance 3
 * for substring "babbb". Since the largest possible variance is 3, we return
 * it. Example 2:
 * 
 * Input: s = "abcde" Output: 0 Explanation: No letter occurs more than once in
 * s, so the variance of every substring is 0.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104 s consists of lowercase English letters.
 *
 */

public class SubstringWithLargestVariance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * The solution boils down to finding the solution if only 2 elements were
	 * present in array, as given in example "aababbb", if we can do that in O(n),
	 * we can iterate over all 26 alphabet characters as the 2 elements and find the
	 * solution in O(26 * 26 * n) (around 10^7 operations, so should pass test
	 * cases) and find the maximum considering those 2 characters, note that other
	 * elements would not interfere as at each iteration, variance is found
	 * considering only 2 elements. Finding maximum variance considering only 2
	 * elements can be done using Kadanes algorithm. In this case, when i was 'b'
	 * and j was 'a', then (let) maxV value is increased only if there are more b's
	 * than a's, else maxV is 0, so maxV is 0,0,1,0,1,2,3 after all the iterations
	 * over string length, and max of these elements is answer when iterated over
	 * all i's and j's.
	 * 
	 */

	public int largestVariance(String s) {
		int n = s.length();
		// consider the fact that i have just two chars a & b in my string, then we can
		// find the variance in O(n) using Kadane algo
		int[] freq = new int[26];
		for (int i = 0; i < n; ++i) {
			freq[s.charAt(i) - 'a']++;
		}

		int max = 0;
		for (int i = 0; i < 26; ++i) {
			for (int j = 0; j < 26; ++j) {
				if (i == j || freq[i] == 0 || freq[j] == 0)
					continue;

				int count1 = 0;
				int count2 = 0;
				for (int k = 0; k < n; ++k) {
					int c = s.charAt(k) - 'a';
					if (i == c)
						count1++;

					if (j == c)
						count2++;

					if (count1 > 0 && count2 > 0)
						max = Math.max(max, count1 - count2);

					if (count1 < count2) {
						count1 = 0;
						count2 = 0;
					}
				}
				count1 = 0;
				count2 = 0;
				for (int k = n - 1; k >= 0; --k) {
					int c = s.charAt(k) - 'a';
					if (i == c)
						count1++;
					if (j == c)
						count2++;
					if (count1 > 0 && count2 > 0)
						max = Math.max(max, count1 - count2);
					if (count1 < count2) {
						count1 = 0;
						count2 = 0;
					}
				}
			}
		}
		return max;
	}

}
