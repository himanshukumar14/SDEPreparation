package DP;

public class HouseRobbery1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return nums[0];
		
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = nums[0];

		for (int i = 2; i < n + 1; ++i) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
		}
		return dp[n];
	}

	// constant space
	public int rob1(int[] nums) {
		if (nums.length == 0)
			return 0;
		int prev1 = 0;
		int prev2 = 0;
		for (int num : nums) {
			int tmp = prev1;
			prev1 = Math.max(prev2 + num, prev1);
			prev2 = tmp;
		}
		return prev1;
	}

}
