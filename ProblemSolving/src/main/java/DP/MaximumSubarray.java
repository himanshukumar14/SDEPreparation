package DP;

/**
 * 
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * A subarray is a contiguous part of an array.
 * 
 * Example 1:
 * 
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: [4,-1,2,1] has
 * the largest sum = 6.
 *
 */

public class MaximumSubarray {

	// Kadane's Algo
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxSubArray(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int n = nums.length;

		int sum = 0;
		int i = 0;
		while (i < n) {
			sum += nums[i++];
			maxSum = Math.max(maxSum, sum);

			if (sum < 0)
				sum = 0;
		}
		return maxSum;
	}

}
