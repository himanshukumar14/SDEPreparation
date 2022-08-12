package DP;

import java.util.Arrays;

/**
 * 
 * Given N integers and K, find the minimum number of elements that should be
 * removed, such that Amax-Amin<=K. After the removal of elements, Amax and Amin
 * is considered among the remaining elements.
 * 
 * Examples:
 * 
 * Input : a[] = {1, 3, 4, 9, 10, 11, 12, 17, 20} k = 4 Output : 5 Explanation:
 * Remove 1, 3, 4 from beginning and 17, 20 from the end.
 * 
 * Input : a[] = {1, 5, 6, 2, 8} K=2 Output : 3 Explanation: There are multiple
 * ways to remove elements in this case. One among them is to remove 5, 6, 8.
 * The other is to remove 1, 2, 5
 *
 */

public class MinimumRemovalsFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int MAX = 100;
	static int dp[][] = new int[MAX][MAX];

	// O(N2) approach
	public static int countRemovals(int a[], int i, int j, int k) {
		if (i >= j)
			return 0;

		else if ((a[j] - a[i]) <= k)
			return 0;

		else if (dp[i][j] != -1)
			return dp[i][j];

		else if ((a[j] - a[i]) > k) {
			dp[i][j] = 1 + Math.min(countRemovals(a, i + 1, j, k), countRemovals(a, i, j - 1, k));
		}
		return dp[i][j];
	}

	static int removals(int a[], int n, int k) {
		Arrays.sort(a);
		for (int[] rows : dp)
			Arrays.fill(rows, -1);
		if (n == 1)
			return 0;
		else
			return countRemovals(a, 0, n - 1, k);
	}

	// --------------------------------------------------------------------------------------------------------

	// O(NlogN) approach
	public static int findInd(int i, int r, int k, int arr[]) {
		int ind = -1;
		int key = arr[i];
		int l = i + 1;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] - key <= k) {
				ind = mid;
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return ind;
	}

	public static int removals2(int arr[], int n, int k) {
		int ans = n - 1;
		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			int j = findInd(i, n - 1, k, arr);
			if (j != -1) {
				ans = Math.min(ans, n - (j - i + 1));
			}
		}
		return ans;
	}

}
