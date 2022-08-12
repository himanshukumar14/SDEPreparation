package Array;

import java.util.Arrays;

/**
 * Given an array arr[] denoting heights of N towers and a positive integer K,
 * you have to modify the height of each tower either by increasing or
 * decreasing them by K only once. After modifying, height should be a
 * non-negative integer. Find out the minimum possible difference of the height
 * of shortest and longest towers after you have modified each tower.
 * 
 * You can find a slight modification of the problem here. Note: It is
 * compulsory to increase or decrease by K to each tower.
 *
 */

public class MinimizeTheHeights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// height difference is minimum between neighbors, so keep checking between
	// neighbors
	public int getMinDiff(int[] arr, int n, int k) {

		Arrays.sort(arr);
		int ans = arr[n - 1] - arr[0];

		int min = arr[0] + k;
		int max = arr[n - 1] - k;

		int newMin = Integer.MAX_VALUE;
		int newMax = Integer.MIN_VALUE;

		for (int i = 0; i < n - 1; i++) {
			if (arr[i + 1] - k < 0)
				continue;

			newMin = Math.min(min, arr[i + 1] - k);
			newMax = Math.max(arr[i] + k, max);
			ans = Math.min(ans, newMax - newMin);
		}
		return ans;
	}

}
