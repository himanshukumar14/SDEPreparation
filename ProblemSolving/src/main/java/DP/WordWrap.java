package DP;

/**
 * 
 * Given an array nums[] of size n, where nums[i] denotes the number of
 * characters in one word. Let K be the limit on the number of characters that
 * can be put in one line (line width). Put line breaks in the given sequence
 * such that the lines are printed neatly. Assume that the length of each word
 * is smaller than the line width. When line breaks are inserted there is a
 * possibility that extra spaces are present in each line. The extra spaces
 * include spaces put at the end of every line except the last one.
 * 
 * You have to minimize the following total cost where total cost = Sum of cost
 * of all lines, where cost of line is = (Number of extra spaces in the line)^2.
 * 
 * Example 1:
 * 
 * Input: nums = {3,2,2,5}, k = 6 Output: 10 Explanation: Given a line can have
 * 6 characters, Line number 1: From word no. 1 to 1 Line number 2: From word
 * no. 2 to 3 Line number 3: From word no. 4 to 4 So total cost = (6-3)2 +
 * (6-2-2-1)2 = 32+12 = 10. As in the first line word length = 3 thus extra
 * spaces = 6 - 3 = 3 and in the second line there are two word of length 2 and
 * there already 1 space between two word thus extra spaces = 6 - 2 -2 -1 = 1.
 * As mentioned in the problem description there will be no extra spaces in the
 * last line. Placing first and second word in first line and third word on
 * second line would take a cost of 02 + 42 = 16 (zero spaces on first line and
 * 6-2 = 4 spaces on second), which isn't the minimum possible cost. Example 2:
 * 
 * Input: nums = {3,2,2}, k = 4 Output: 5 Explanation: Given a line can have 4
 * characters, Line number 1: From word no. 1 to 1 Line number 2: From word no.
 * 2 to 2 Line number 3: From word no. 3 to 3 Same explaination as above total
 * cost = (4 - 3)2 + (4 - 2)2 = 5.
 *
 * 
 */

public class WordWrap {

	// Text Justification
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 3, 2, 2, 5 };
		int k = 6;
		System.out.println(solveWordWrap(arr, k));
	}

	public static int solveWordWrap(int[] nums, int k) {
		// Code here
		int n = nums.length;
		int[][] dp = new int[n + 1][2];
		dp[0][0] = 0;
		dp[0][1] = 0;

		for (int i = 1; i < n + 1; ++i) {
			// single
			int val1 = dp[i - 1][0] + ((k - nums[i - 1]) * (k - nums[i - 1]));
			int line1 = dp[i - 1][1] + 1;

			// together
			int val2 = Integer.MAX_VALUE;
			int line2 = -1;
			int sum = nums[i - 1];
			for (int j = i - 1; j >= 1; --j) {
				sum += nums[j - 1] + 1;
				if (sum > k)
					break;
				if (val2 > dp[j - 1][0] + ((k - sum) * (k - sum))) {
					val2 = dp[j - 1][0] + ((k - sum) * (k - sum));
					line2 = dp[j - 1][1] + 1;
				}
			}
			if (val1 > val2) {
				dp[i][0] = val2;
				dp[i][1] = line2;
			} else {
				dp[i][0] = val1;
				dp[i][1] = line1;
			}
		}
		int bestLine = dp[n][1] - 1; //since last line is not considered in the cost so we take 1 line less and look for it's best cost
		int bestCost = Integer.MAX_VALUE;
		for (int i = 0; i < n + 1; ++i) {
			if (dp[i][1] == bestLine) {
				bestCost = Math.min(bestCost, dp[i][0]);
			}
		}
		return bestCost;
	}
}
