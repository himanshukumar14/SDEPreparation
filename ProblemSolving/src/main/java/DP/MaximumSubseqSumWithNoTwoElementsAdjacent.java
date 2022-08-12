package DP;

/**
 * 
 * Given an array arr[] of positive numbers, the task is to find the maximum sum
 * of a subsequence with the constraint that no 2 numbers in the sequence should
 * be adjacent in the array.
 * 
 * Examples:
 * 
 * Input: arr[] = {5, 5, 10, 100, 10, 5} Output: 110 Explanation: Pick the
 * subsequence {5, 100, 5}. The sum is 110 and no two elements are adjacent.
 * This is the highest possible sum.
 * 
 * Input: arr[] = {3, 2, 7, 10} Output: 13 Explanation: The subsequence is {3,
 * 10}. This gives sum = 13. This is the highest possible sum of a subsequence
 * following the given criteria
 * 
 * Input: arr[] = {3, 2, 5, 10, 7} Output: 15 Explanation: Pick the subsequence
 * {3, 5, 7}. The sum is 15.
 *
 */

public class MaximumSubseqSumWithNoTwoElementsAdjacent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 5, 10, 100, 10, 5 };
		int N = arr.length;

		// Function call
		System.out.println(findMaxSum(arr, N));
	}

	//can do with rob logic
	public static int findMaxSum(int[] arr, int n) {
		int[][] dp = new int[n][2];
		dp[0][0] = 0;
		dp[0][1] = arr[0];

		for (int i = 1; i < n; ++i) {
			dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
			dp[i][1] = arr[i] + dp[i - 1][0];
		}

		return Math.max(dp[n - 1][0], dp[n - 1][1]);
	}

}
