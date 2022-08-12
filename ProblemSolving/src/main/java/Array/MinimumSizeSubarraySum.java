package Array;

/**
 * 
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a contiguous subarray [numsl, numsl+1, ...,
 * numsr-1, numsr] of which the sum is greater than or equal to target. If there
 * is no such subarray, return 0 instead.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: target = 7, nums = [2,3,1,2,4,3] Output: 2 Explanation: The subarray
 * [4,3] has the minimal length under the problem constraint. Example 2:
 * 
 * Input: target = 4, nums = [1,4,4] Output: 1 Example 3:
 * 
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1] Output: 0
 *
 */

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0)
			return 0;
		int max = nums.length + 1;
		int sum = nums[0];
		int count = 1;
		int j = 0;

		for (int i = 1; i <= nums.length; ++i) {
			while (sum >= s) {
				if (sum >= s) {
					max = Math.min(max, count);
				}
				sum = sum - nums[j];
				count--;
				j++;
			}

			if (i < nums.length) {
				sum = sum + nums[i];
				count++;
			}
		}
		return max == (nums.length + 1) ? 0 : max;
	}

}
