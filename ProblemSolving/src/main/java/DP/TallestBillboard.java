package DP;

import java.util.Arrays;

/**
 * 
 * You are installing a billboard and want it to have the largest height. The
 * billboard will have two steel supports, one on each side. Each steel support
 * must be an equal height.
 * 
 * You are given a collection of rods that can be welded together. For example,
 * if you have rods of lengths 1, 2, and 3, you can weld them together to make a
 * support of length 6.
 * 
 * Return the largest possible height of your billboard installation. If you
 * cannot support the billboard, return 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: rods = [1,2,3,6] Output: 6 Explanation: We have two disjoint subsets
 * {1,2,3} and {6}, which have the same sum = 6. Example 2:
 * 
 * Input: rods = [1,2,3,4,5,6] Output: 10 Explanation: We have two disjoint
 * subsets {2,3,5} and {4,6}, which have the same sum = 10. Example 3:
 * 
 * Input: rods = [1,2] Output: 0 Explanation: The billboard cannot be supported,
 * so we return 0.
 *
 */

public class TallestBillboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// recursive solution
	public int tallestBillboard(int[] rods) {
		int n = rods.length;
		int sum = 0;
		for (int i = 0; i < n; ++i) {
			sum += rods[i];
		}
		int[][] dp = new int[sum + 1][sum + 1];

		return find(rods, 0, 0, 0, dp);
	}

	public int find(int[] rods, int g0, int g1, int i, int[][] dp) {
		if (i == rods.length)
			return g0 == g1 ? g0 : 0;
		if (dp[g0][g1] != 0)
			return dp[g0][g1];
		int val = Math.max(find(rods, g0, g1, i + 1, dp), // Ignore
				Math.max(find(rods, g0 + rods[i], g1, i + 1, dp), // Put in g0
						find(rods, g0, g1 + rods[i], i + 1, dp))); // Put in g1

		dp[g0][g1] = val;
		return val;
	}

	/**
	 * 
	 * Similar to backpack DP problem as Leetcode 416. But this one is more
	 * challenging because some data point may not be chosen. Moreover, the dp
	 * definition is different. In this question, dp[i][j] denotes the largest left
	 * sum at the case of after using i-th rod and the difference between left sum
	 * and right sum is j - sum of all rods. Initially, I want to design dp as i-th
	 * rod and difference between left sum and right to be j, however, j could be
	 * negative, use sum of all rods to offset all negative values. So the answer
	 * should be dp[n][sum of all rods].
	 *
	 */

	// iterative solution
//Time complexity: O(n * sum)
//	Space complexity: O(n * sum)
	public int tallestBillboard1(int[] rods) {
		int sum = 0;
		for (int i : rods) {
			sum += i;
		}
		int n = rods.length;
		int[][] dp = new int[n + 1][2 * sum + 1];// largest sum of left at i-th rod and difference between
		// sum of left and sum of right equals to j-sum
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);// -1 means the value could not be reached.
		}
		dp[0][sum] = 0; // it means if there is no rods, the largest left sum could be 0, not -1.
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= 2 * sum; j++) {
				if (j - rods[i - 1] >= 0 && dp[i - 1][j - rods[i - 1]] != -1) {// this means we will add next rod
																				// (rods[i-1] to the left,
					// so the largest left sum should be added by rods[i-1] from previous step
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - rods[i - 1]] + rods[i - 1]);
				}
				if (j + rods[i - 1] <= 2 * sum && dp[i - 1][j + rods[i - 1]] != -1) {// this means we will add next
																						// rod(rods[i-1]) to the right,
					// so largest left sum at previous step stays at dp[i-1][j+rods[i-1]]
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + rods[i - 1]]);
				}
				if (dp[i - 1][j] != -1) {// this means we don't use rods[i-1] but we need ensure
					// previous step could be reached, so we can compare.
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
				}
			}
		}
		return dp[n][sum];
	}

}
