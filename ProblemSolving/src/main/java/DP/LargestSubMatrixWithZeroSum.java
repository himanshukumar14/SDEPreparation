package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a 2D matrix, find the largest rectangular sub-matrix whose sum is 0.
 * for example consider the following N x M input matrix
 * 
 * 
 * 
 * 
 * Examples:
 * 
 * 
 * Input : 1, 2, 3 -3, -2, -1 1, 7, 5
 * 
 * Output : 1, 2, 3 -3, -2, -1
 * 
 * Input : 9, 7, 16, 5 1, -6, -7, 3 1, 8, 7, 9 7, -2, 0, 10
 * 
 * Output :-6, -7 8, 7 -2, 0
 *
 */


// se the concept of 2D kadane and largest subarray with zero sum
public class LargestSubMatrixWithZeroSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] getMaxLen(int arr[]) {
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

	public int[] maximumRectangleWithZeroSum(int r, int c, int matrix[][]) {
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
