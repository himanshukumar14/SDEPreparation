package DP;

/**
 * 
 * Given a sequence of positive numbers, find the maximum sum that can be formed
 * which has no three consecutive elements present. Examples :
 * 
 * Input: arr[] = {1, 2, 3} 
 * Output: 5 We can't take three of them, so answer is 2 + 3 = 5
 * 
 * Input: arr[] = {3000, 2000, 1000, 3, 10} 
 * Output: 5013 
 * 3000 + 2000 + 3 + 10 = 5013
 * 
 * Input: arr[] = {100, 1000, 100, 1000, 1} 
 * Output: 2101 
 * 100 + 1000 + 1000 + 1 = 2101
 * 
 * Input: arr[] = {1, 1, 1, 1, 1} Output: 4
 * 
 * Input: arr[] = {1, 2, 3, 4, 5, 6, 7, 8} Output: 27
 *
 */

//This problem is mainly an extension of below problem.
//Maximum sum such that no two elements are adjacent

/**
 * 
 * sum[i] : Stores result for subarray arr[0..i], i.e., maximum possible sum in
 * subarray arr[0..i] such that no three elements are consecutive.
 * 
 * sum[0] = arr[0]
 * 
 * // Note : All elements are positive sum[1] = arr[0] + arr[1]
 * 
 * // We have three cases // 1) Exclude arr[2], i.e., sum[2] = sum[1] // 2)
 * Exclude arr[1], i.e., sum[2] = sum[0] + arr[2] // 3) Exclude arr[0], i.e.,
 * sum[2] = arr[1] + arr[2] sum[2] = max(sum[1], arr[0] + arr[2], arr[1] +
 * arr[2])
 * 
 * In general, // We have three cases // 1) Exclude arr[i], i.e., sum[i] =
 * sum[i-1] // 2) Exclude arr[i-1], i.e., sum[i] = sum[i-2] + arr[i] // 3)
 * Exclude arr[i-2], i.e., sum[i-3] + arr[i] + arr[i-1] sum[i] = max(sum[i-1],
 * sum[i-2] + arr[i], sum[i-3] + arr[i] + arr[i-1])
 *
 */

public class MaximumSubseqSumWithNoThreeAreConsecutive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxSumWO3Consec(int arr[], int n) {
		int dp[] = new int[n];
		//filling up base cases
		if (n >= 1)
			dp[0] = arr[0];

		if (n >= 2)
			dp[1] = arr[0] + arr[1];

		if (n > 2)
			dp[2] = Math.max(dp[1], Math.max(arr[1] + arr[2], dp[0] + arr[2]));

		for (int i = 3; i < n; i++)
			dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + arr[i]), arr[i] + arr[i - 1] + dp[i - 3]);

		return dp[n - 1];
	}

}
