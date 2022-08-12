package Array;

public class CountingBinarySubstrings {

	/**
	 * 
	 * Kindle Direct Publishing, Amazon’s e-book self-publishing platform, is
	 * working on a new feature to help authors track the use of text strings in
	 * different ways. A substring is a group of contiguous characters in a string.
	 * For instance, all substring of abc are [a, b, c, ab, bc, abc].
	 * 
	 * Given a binary representation of a number, determine the total number of
	 * substring present that match the following conditions:
	 * 
	 * The 0s and 1s are grouped consecutively (e.g., 01, 10, 0011, 1100, 000111,
	 * etc.). The number of 0s in the substring is equal to the number of 1s in the
	 * substring. Input s: a string representation of a binary integer Output the
	 * number of substrings of s that satisfy the two conditions
	 * 
	 * Examples Example 1: Input: 1s = 001101
	 * 
	 * Output: 4
	 * 
	 * Explanation:
	 * 
	 * The 4 substrings matching the two conditions include [0011, 01, 10, 01]. Note
	 * that 01 appears twice, from indices 1-2 and 4-5. There are other substrings,
	 * e.g. 001 and 011 that match the first condition but not the second.
	 * 
	 * Constraints 5<=|s|<=5*10^5 each s[i] is either ‘0’ or ‘1’
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * We can observe from the above examples that our final count will only depend
	 * on the consecutive counts of binary characters. With each two groups of
	 * consecutive characters, the number of substrings that can be formed will be
	 * minimum of count among the two groups.
	 * 
	 * Now, although we could maintain all the groupings and their counts and then
	 * count the number of substrings, we actually don’t even need to maintain the
	 * consecutive counts in all of the string. We can just store the current
	 * consecutive count and previous consecutive count and count the substrings on
	 * the fly.
	 * 
	 * s[i] == s[i - 1] : When current character is equal to previous – just
	 * increment the current consecutive count. s[i] != s[i - 1] :Whenever current
	 * character is not equal to previous – We know that we atleast have group of 2
	 * different characters having consecutiveCount >= 1. The number of substrings
	 * that can be formed from these would be equal to minimum of
	 * currentConsecutiveCount & prevConsecutiveCount. So just add that amount to
	 * ans. Now prevConsecutiveCount will become equal to currentConsecutiveCount
	 * and reset the currentConsecutiveCount to 1.
	 * 
	 */

	public int countBinarySubstrings(String s) {
		int curr = 1;
		int prev = 0;
		int ans = 0;
		int n = s.length();
		for (int i = 1; i < n; ++i) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				curr++;
			} else {
				ans += Math.min(prev, curr);
				prev = curr;
				curr = 1;
			}
		}
		return ans + Math.min(prev, curr);
	}

}
