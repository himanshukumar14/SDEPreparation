package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a binary matrix. The problem is to find the largest area rectangular
 * sub-matrix with equal number of 1’s and 0’s. Examples:
 * 
 * Input : mat[][] = { {0, 0, 1, 1}, {0, 1, 1, 0}, {1, 1, 1, 0}, {1, 0, 0, 1} }
 * Output : 8 sq. units (Top, left): (0, 0) (Bottom, right): (3, 1)
 * 
 * Input : mat[][] = { {0, 0, 1, 1}, {0, 1, 1, 1} } Output : 6 sq. units
 *
 */


// Same as largest subarray matrix with sum zero as we can replace 0 with -1
public class LargestAreaSubMatrixWithEqualZeroAndOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] { { 0, 0, 1, 1 }, { 0, 1, 1, 0 }, { 1, 1, 1, 0 }, { 1, 0, 0, 1 } };
		int[] ans = getMaxArea(matrix);
		System.out.println("left: " + ans[0] + " right: " + ans[1] + " top: " + ans[2] + " bottom: " + ans[3]);
	}

	public static int[] getMaxArea(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (matrix[i][j] == 0)
					matrix[i][j] = -1;
			}
		}
		return maximumRectangleWithZeroSum(n, m, matrix);
	}

	public static int[] getMaxLen(int arr[]) {
		Map<Integer, Integer> map = new HashMap<>();

		int prefixSum = 0;
		int maxLen = 0;
		int[] ans = new int[2];

		for (int i = 0; i < arr.length; i++) {
			prefixSum += arr[i];

			if (arr[i] == 0 && maxLen == 0) {
				maxLen = 1;
				ans[0] = i;
				ans[1] = i;
			}

			if (prefixSum == 0) {
				maxLen = i + 1;
				ans[0] = 0;
				ans[1] = i;
			}

			Integer prev = map.get(prefixSum);
			if (prev != null) {
				if (i - prev > maxLen) {
					maxLen = i - prev;
					ans[0] = prev + 1;
					ans[1] = i;
				}
			} else
				map.put(prefixSum, i);
		}

		return ans;
	}

	public static int[] maximumRectangleWithZeroSum(int r, int c, int matrix[][]) {
		int maxLeft = 0;
		int maxRight = 0;
		int maxTop = 0;
		int maxBottom = 0;
		int maxArea = Integer.MIN_VALUE;

		for (int i = 0; i < c; ++i) {
			int[] mem = new int[r];
			for (int j = i; j < c; ++j) {
				for (int k = 0; k < r; ++k)
					mem[k] += matrix[k][j];
				int[] ans = getMaxLen(mem);
				int area = (j - i + 1) * (ans[1] - ans[0] + 1);
				if (area > maxArea) {
					maxArea = area;
					maxLeft = i;
					maxRight = j;
					maxTop = ans[0];
					maxBottom = ans[1];
				}
			}
		}
		return new int[] { maxLeft, maxRight, maxTop, maxBottom };
	}

}
