package DP;

import java.util.Arrays;

/**
 * 
 * You are given an integer array nums and an integer target.
 * 
 * You want to build an expression out of nums by adding one of the symbols '+'
 * and '-' before each integer in nums and then concatenate all the integers.
 * 
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1
 * and concatenate them to build the expression "+2-1". Return the number of
 * different expressions that you can build, which evaluates to target.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1,1,1], target = 3 Output: 5 Explanation: There are 5 ways
 * to assign symbols to make the sum of nums be target 3. -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3 +1 + 1 - 1 + 1 + 1 = 3 +1 + 1 + 1 - 1 + 1 = 3 +1 + 1 +
 * 1 + 1 - 1 = 3 Example 2:
 * 
 * Input: nums = [1], target = 1 Output: 1
 *
 */

public class TargetSum {

	// This question boils down to count of partitions with given difference where diff is the target
	//So s1 will be sets with positive elements and s2 will be sets with negative and s1 - s2 = target  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findTargetSumWays(int[] nums, int target) {
		int n = nums.length;
		int total = 0;
		for (int i = 0; i < n; ++i) {
			total += nums[i];
		}
		int[][] memo = new int[n][2 * total + 1];
		for (int[] row : memo) {
			Arrays.fill(row, Integer.MIN_VALUE);
		}
		return recur(0, 0, nums, target, memo, total);
	}

	public int recur(int sum, int i, int[] nums, int target, int[][] memo, int total) {
		if (i == nums.length && sum == target)
			return 1;
		if (i >= nums.length)
			return 0;
		if (memo[i][sum + total] != Integer.MIN_VALUE)
			return memo[i][sum + total];
		int plus = recur(sum + nums[i], i + 1, nums, target, memo, total);
		int minus = recur(sum - nums[i], i + 1, nums, target, memo, total);
		memo[i][sum + total] = plus + minus;
		return memo[i][sum + total];
	}
	
	//-------------------------------------------------------------------------------------------------
    public int findTargetSumWays2(int[] nums, int S) {
        int total = Arrays.stream(nums).sum();
        int[] dp = new int[2 * total + 1];
        dp[nums[0] + total] = 1;
        dp[-nums[0] + total] += 1;
        
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2 * total + 1];
            for (int sum = -total; sum <= total; sum++) {
                if (dp[sum + total] > 0) {
                    next[sum + nums[i] + total] += dp[sum + total];
                    next[sum - nums[i] + total] += dp[sum + total];
                }
            }
            dp = next;
        }
        
        return Math.abs(S) > total ? 0 : dp[S + total];
    }

}
