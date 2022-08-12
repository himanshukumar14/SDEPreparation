package DP;

import java.util.Arrays;

/**
 * 
 * Given a fence with n posts and k colors, find out the number of ways of
 * painting the fence such that at most 2 adjacent posts have the same color.
 * Since answer can be large return it modulo 10^9 + 7. Examples:
 * 
 * Input : n = 2 k = 4 Output : 16 We have 4 colors and 2 posts. Ways when both
 * posts have same color : 4 Ways when both posts have diff color : 4(choices
 * for 1st post) * 3(choices for 2nd post) = 12
 * 
 * Input : n = 3 k = 2 Output : 6
 *
 */

/**
 * 
 * diff = no of ways when color of last two posts is different 
 * same = no of ways when color of last two posts is same 
 * total ways = diff + sum
 * 
 * for n = 1 diff = k, same = 0 total = k
 * 
 * for n = 2 diff = k * (k-1) //k choices for first post, k-1 for next 
 * same = k //k choices for common color of two posts 
 * total = k + k * (k-1)
 * 
 * for n = 3 diff = k * (k-1)* (k-1) //(k-1) choices for the first place // k
 * choices for the second place //(k-1) choices for the third place 
 * same = k * (k-1) * 2 // 2 is multiplied because consider two color R and B // R R B or B
 * R R // B B R or R B B c'' != c, (k-1) choices for it
 * 
 * Hence we deduce that, total[i] = same[i] + diff[i] same[i] = diff[i-1]
 * diff[i] = (diff[i-1] + diff[i-2]) * (k-1) = total[i-1] * (k-1)
 *
 */

public class PaintingFence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static long countWays(int n, int k) {
		long dp[] = new long[n + 1];
		Arrays.fill(dp, 0);
		int mod = 1000000007;

		dp[1] = k;

		int same = 0, diff = k;

		for (int i = 2; i <= n; i++) {
			same = diff;
			diff = (int) (dp[i - 1] * (k - 1));
			diff = diff % mod;
			dp[i] = (same + diff) % mod;
		}
		return dp[n];
	}

	// space optimized
	public static long countWays2(int n, int k) {
		long total = k;
		int mod = 1000000007;

		int same = 0, diff = k;
		for (int i = 2; i <= n; i++) {
			same = diff;
			diff = (int) total * (k - 1);
			diff = diff % mod;
			total = (same + diff) % mod;
		}
		return total;
	}

}
