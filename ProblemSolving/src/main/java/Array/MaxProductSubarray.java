package Array;

/**
 * 
 * Given an integer array nums, find a contiguous non-empty subarray within the
 * array that has the largest product, and return the product.
 * 
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * 
 * A subarray is a contiguous subsequence of the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,-2,4] Output: 6 Explanation: [2,3] has the largest product
 * 6. Example 2:
 * 
 * Input: nums = [-2,0,-1] Output: 0 Explanation: The result cannot be 2,
 * because [-2,-1] is not a subarray.
 *
 * 
 */

public class MaxProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProduct(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int max = A[0], min = A[0], result = A[0];
		for (int i = 1; i < A.length; i++) {
			int temp = max;
			max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
			min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
			if (max > result) {
				result = max;
			}
		}
		return result;
	}

}
