package DP;

/**
 * 
 * Given a 2D array, find the maximum sum subarray in it. For example, in the
 * following 2D array, the maximum sum subarray is highlighted with blue
 * rectangle and sum of this subarray is 29.
 * 
 */

// 2D kadane's
public class MaximumSumSubRectangle {

	public int maximumSumRectangle(int r, int c, int matrix[][]) {
		int currentSum;
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < c; ++i) {
			int[] mem = new int[r];
			for (int j = i; j < c; ++j) {
				for (int k = 0; k < r; ++k)
					mem[k] += matrix[k][j];
				
				int sum = 0;
				currentSum = Integer.MIN_VALUE;
				for (int k = 0; k < r; ++k) {
					sum += mem[k];
					currentSum = Math.max(currentSum, sum);
					if (sum < 0)
						sum = 0;
				}
				maxSum = Math.max(currentSum, maxSum); // can keep track of i,j, top, bottom to get the rectangles as well
			}
		}
		return maxSum;
	}
}
