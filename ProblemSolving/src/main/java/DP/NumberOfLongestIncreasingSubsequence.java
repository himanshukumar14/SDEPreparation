package DP;

/**
 * 
 * Given an integer array nums, return the number of longest increasing
 * subsequences.
 * 
 * Notice that the sequence has to be strictly increasing.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,5,4,7] Output: 2 Explanation: The two longest increasing
 * subsequences are [1, 3, 4, 7] and [1, 3, 5, 7]. Example 2:
 * 
 * Input: nums = [2,2,2,2,2] Output: 5 Explanation: The length of longest
 * continuous increasing subsequence is 1, and there are 5 subsequences' length
 * is 1, so output 5.
 *
 * 
 */

public class NumberOfLongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findNumberOfLIS(int[] nums) {
		int n = nums.length;
		int[] count = new int[n];
		int[] dp = new int[n];
		int max = 1;
		for (int i = 0; i < n; ++i) {
			dp[i] = 1;
			count[i] = 1;
		}

		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (nums[i] > nums[j]) {
					if (dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						count[i] = count[j];
					} else if (dp[i] == dp[j] + 1) {
						count[i] += count[j];
					}
				}
			}
			max = Math.max(max, dp[i]);
		}
		int ans = 0;
		for (int i = 0; i < n; i++)
			if (dp[i] == max)
				ans += count[i];
		return ans;
	}

}
