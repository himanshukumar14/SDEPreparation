package DP;

/**
 * 
 * Given an array of non-negative integers nums, you are initially positioned at
 * the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * You can assume that you can always reach the last index.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,1,1,4] Output: 2 Explanation: The minimum number of jumps
 * to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to
 * the last index. Example 2:
 * 
 * Input: nums = [2,3,0,1,4] Output: 2
 *
 */

public class JumpGame2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// possible in O(n)
	public int jump(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = 0;

		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (i - j <= nums[j]) {
					dp[i] = dp[i] == 0 ? dp[j] + 1 : Math.min(dp[i], dp[j] + 1);
				}
			}
		}
		return dp[n - 1];
	}

	public int jump2(int[] nums) {
		int n = nums.length;
		int last = n - 1;
		int count = 0;
		while (last != 0) {
			for (int i = 0; i < last; ++i) {
				if (last - i <= nums[i])
					last = i;
			}
			count++;
		}
		return count;
	}

	// ------------------------------------------------------------------------------------------------

	// O(n) solution
	/**
	 * 
	 * The main idea is based on greedy. Let's say the range of the current jump is
	 * [curBegin, curEnd], curFarthest is the farthest point that all points in
	 * [curBegin, curEnd] can reach. Once the current point reaches curEnd, then
	 * trigger another jump, and set the new curEnd with curFarthest, then keep the
	 * above steps, as the following:
	 * 
	 */

	public int jumpO(int[] A) {
		int jumps = 0, curEnd = 0, curFarthest = 0;
		for (int i = 0; i < A.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + A[i]);
			if (i == curEnd) {
				jumps++;
				curEnd = curFarthest;
			}
		}
		return jumps;
	}

}
