package DP;

/**
 * 
 * Given an integer N denoting the Length of a line segment. You need to cut the
 * line segment in such a way that the cut length of a line segment each time is
 * either x , y or z. Here x, y, and z are integers. After performing all the
 * cut operations, your total number of cut segments must be maximum.
 * 
 * Example 1:
 * 
 * Input: N = 4 x = 2, y = 1, z = 1 Output: 4 Explanation:Total length is 4, and
 * the cut lengths are 2, 1 and 1. We can make maximum 4 segments each of length
 * 1. Example 2:
 * 
 * Input: N = 5 x = 5, y = 3, z = 2 Output: 2 Explanation: Here total length is
 * 5, and the cut lengths are 5, 3 and 2. We can make two segments of lengths 3
 * and 2
 *
 */

public class MaximizeTheCutSegments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maximizeCuts(int n, int x, int y, int z) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		for (int i = 1; i < n + 1; ++i) {
			int val1 = Integer.MIN_VALUE;
			int val2 = Integer.MIN_VALUE;
			int val3 = Integer.MIN_VALUE;
			if (i - x >= 0)
				val1 = dp[i - x];
			if (i - y >= 0)
				val2 = dp[i - y];
			if (i - z >= 0)
				val3 = dp[i - z];
			dp[i] = Math.max(val1, Math.max(val2, val3)) + 1;
		}
		return dp[n] <= 0 ? 0 : dp[n];
	}

	// recursive way
	public int maximizeCuts2(int l, int p, int q, int r) {
		if (l == 0)
			return 0;
		int a = Integer.MIN_VALUE;
		int b = Integer.MIN_VALUE;
		int c = Integer.MIN_VALUE;
		if (p <= l)
			a = maximizeCuts2(l - p, p, q, r);
		if (q <= l)
			b = maximizeCuts2(l - q, p, q, r);
		if (r <= l)
			c = maximizeCuts2(l - r, p, q, r);
		int val = 1 + Math.max(a, Math.max(b, c));
		return val <= 0 ? 0 : val;

	}

}
