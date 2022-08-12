package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a set of distinct positive integers nums, return the largest subset
 * answer such that every pair (answer[i], answer[j]) of elements in this subset
 * satisfies:
 * 
 * answer[i] % answer[j] == 0, or answer[j] % answer[i] == 0 If there are
 * multiple solutions, return any of them.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3] Output: [1,2] Explanation: [1,3] is also accepted.
 * Example 2:
 * 
 * Input: nums = [1,2,4,8] Output: [1,2,4,8]
 *
 */

public class LargestDivisibleSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> largestDivisibleSubset(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		int maxLen = 0;
		int maxIndex = 0;
		Arrays.sort(nums);
		int[] ans = new int[n];
		for (int i = 0; i < n; ++i) {
			dp[i] = 1;
			ans[i] = i;
		}

		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (nums[i] % nums[j] == 0) {
					if (dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						ans[i] = j;
					}
				}
			}
			if (dp[i] > maxLen) {
				maxLen = dp[i];
				maxIndex = i;
			}
		}
		List<Integer> l = new ArrayList<>();
		int i = maxIndex;
		while (ans[i] != i) {
			l.add(nums[i]);
			i = ans[i];
		}
		l.add(nums[i]);
		return l;
	}
}
