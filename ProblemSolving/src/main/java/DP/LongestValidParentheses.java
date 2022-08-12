package DP;

/**
 * 
 * Given a string A containing just the characters '(' and ')'.
 * 
 * Find the length of the longest valid (well-formed) parentheses substring.
 *  
 * Problem Constraints 1 <= length(A) <= 750000
 *  
 * Input Format The only argument given is string A.
 *  
 * Output Format Return the length of the longest valid (well-formed)
 * parentheses substring.
 *  
 * 
 * Example Input Input 1:
 * 
 * A = "(()" Input 2:
 * A = ")()())"
 *  
 * Example Output Output 1:
 * 
 * 2 Output 2:
 * 
 * 4
 *  
 * Example Explanation Explanation 1:
 * 
 * The longest valid parentheses substring is "()", which has length = 2.
 * Explanation 2:
 * 
 * The longest valid parentheses substring is "()()", which has length = 4.
 *
 */

public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestValidParentheses(String A) {
		int n = A.length();
		int[] dp = new int[n + 1];

		int max = Integer.MIN_VALUE;

		for (int i = 1; i < n + 1; ++i) {
			char curr = A.charAt(i - 1);
			char prev = i > 1 ? A.charAt(i - 2) : ' ';
			if (curr == '(') {
				dp[i] = 0;
			} else {
				if (prev == '(')
					dp[i] = dp[i - 2] + 2;
				else if (prev == ')') {
					if (i - dp[i - 1] - 2 >= 0 && A.charAt(i - dp[i - 1] - 2) == '(')
						dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
					else
						dp[i] = 0;
				}
			}
			max = Math.max(max, dp[i]);
		}

		return max;
	}

}
