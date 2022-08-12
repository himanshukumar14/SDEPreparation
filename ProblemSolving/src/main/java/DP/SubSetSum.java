package DP;

/**
 * 
 * Given a set of non-negative integers, and a value sum, determine if there is
 * a subset of the given set with sum equal to given sum.
 * 
 * Example:
 * 
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9 Output: True There is a subset
 * (4, 5) with sum 9.
 * 
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30 Output: False There is no
 * subset that add up to 30. Recommended Practice
 *
 */

public class SubSetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//uses 0/1 knapsack logic
	public static boolean isSubsetSum(int set[], int n, int sum) {
		boolean subset[][] = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++)
			subset[i][0] = true;

		for (int i = 1; i <= sum; i++)
			subset[0][i] = false;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (i >= set[j - 1])
					subset[i][j] = subset[i - 1][j] || subset[i - 1][j - set[i - 1]]; // include current number or donot
																						// include whichever is true
				else
					subset[i][j] = subset[i - 1][j]; // donot include current number

			}
		}
		return subset[n][sum];
	}

}
