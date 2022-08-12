package DP;

/**
 * 
 * Given an array arr[] of length N and an integer X, the task is to find the
 * number of subsets with a sum equal to X.
 * 
 * Examples:
 * 
 * Input: arr[] = {1, 2, 3, 3}, X = 6 Output: 3 All the possible subsets are {1,
 * 2, 3}, {1, 2, 3} and {3, 3}
 * 
 * Input: arr[] = {1, 1, 1, 1}, X = 1 Output: 4
 *
 */

public class CountOfSubsetsWithSumK {

	// Based on subset sum or better 0/1 knapsack
	public static int subsetSum(int a[], int n, int sum) {
		int tab[][] = new int[n + 1][sum + 1];
		tab[0][0] = 1;

		for (int i = 1; i <= sum; ++i)
			tab[0][i] = 0; // we can never form a positive sum with zero elements
		for (int i = 1; i <= n; ++i)
			tab[i][0] = 1; // we can form a zero sum by not selecting any element in the subset

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (j - a[i - 1] >= 0) {
					tab[i][j] = tab[i - 1][j] + tab[i - 1][j - a[i - 1]];
				} else {
					tab[i][j] = tab[i - 1][j];
				}
			}
		}
		return tab[n][sum];
	}

	// Driver Code
	public static void main(String[] args) {
		int n = 4;
		int a[] = { 3, 3, 3, 3 };
		int sum = 6;

		System.out.print(subsetSum(a, n, sum));
	}

}
