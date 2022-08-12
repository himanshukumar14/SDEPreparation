package DP;

/**
 * 
 * You are given two identical eggs and you have access to a building with n
 * floors labeled from 1 to n.
 * 
 * You know that there exists a floor f where 0 <= f <= n such that any egg
 * dropped at a floor higher than f will break, and any egg dropped at or below
 * floor f will not break.
 * 
 * In each move, you may take an unbroken egg and drop it from any floor x
 * (where 1 <= x <= n). If the egg breaks, you can no longer use it. However, if
 * the egg does not break, you may reuse it in future moves.
 * 
 * Return the minimum number of moves that you need to determine with certainty
 * what the value of f is.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 2 Output: 2 Explanation: We can drop the first egg from floor 1
 * and the second egg from floor 2. If the first egg breaks, we know that f = 0.
 * If the second egg breaks but the first egg didn't, we know that f = 1.
 * Otherwise, if both eggs survive, we know that f = 2.
 *
 */

public class EggDropping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int twoEggDrop(int n) {
		int[][] dp = new int[2][n + 1];
		for (int i = 1; i <= n; ++i) {
			dp[0][i] = i;
		}
		dp[1][1] = 1;

		for (int i = 2; i <= n; ++i) {
			dp[1][i] = 1 + getMin(i, dp);
		}
		return dp[1][n];
	}

	public int getMin(int i, int[][] dp) {
		int minVal = Integer.MAX_VALUE;
		for (int k = 1; k <= i; ++k) {
			int val;
			if (k == 1)
				val = Math.max(0, dp[1][i - k]); //{break, not breaks} // if breaks go down // if not breaks go up
			else if (k == i)
				val = Math.max(dp[0][k - 1], 0);
			else
				val = Math.max(dp[0][k - 1], dp[1][i - k]);
			minVal = Math.min(minVal, val);
		}
		return minVal;
	}

}
