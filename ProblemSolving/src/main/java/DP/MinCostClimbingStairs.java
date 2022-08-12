package DP;

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		int[] dp = new int[n];

		dp[0] = cost[0];
		dp[1] = cost[1];

		for (int i = 2; i < n; ++i) {
			dp[i] += Math.min(dp[i - 1], dp[i - 2]) + cost[i];
		}
		return Math.min(dp[n - 1], dp[n - 2]); // can reach dp[n] from dp[n-1] and dp[n-2]
	}

	// constant space
	public int minCostClimbingStairs1(int[] cost) {
		int n = cost.length;
		int first = cost[0];
		int second = cost[1];
		if (n <= 2)
			return Math.min(first, second);
		for (int i = 2; i < n; i++) {
			int curr = cost[i] + Math.min(first, second);
			first = second;
			second = curr;
		}
		return Math.min(first, second);
	}

}
