package DP;

public class HouseRobbery2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return nums[0];
		return Math.max(robHelper(nums, 0, n - 2), robHelper(nums, 1, n - 1));
	}

	public int robHelper(int[] nums, int l, int r) {
		int n = r - l + 1;
		int[] dp = new int[n + 1];

		dp[0] = 0;
		dp[1] = nums[l];
		for (int i = 2; i < n + 1; ++i) {
			dp[i] = Math.max(dp[i - 2] + nums[l + i - 1], dp[i - 1]);
		}
		return dp[n];
	}

}
