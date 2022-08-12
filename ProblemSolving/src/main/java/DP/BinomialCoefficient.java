package DP;

/**
 * 
 * Given two integers n and r, find nCr. Since the answer may be very large,
 * calculate the answer modulo 109+7.
 * 
 * A binomial coefficient C(n, k) can be defined as the coefficient of x^k in
 * the expansion of (1 + x)^n.
 * 
 * A binomial coefficient C(n, k) also gives the number of ways, disregarding
 * order, that k objects can be chosen from among n objects more formally, the
 * number of k-element subsets (or k-combinations) of a n-element set.
 *
 * Example 1:
 * 
 * Input: n = 3, r = 2 Output: 3 Explaination: 3C2 = 3.
 * 
 * Example 2:
 * 
 * Input: n = 2, r = 4 Output: 0 Explaination: r is greater than n.
 * 
 * Your Task: You do not need to take input or print anything. Your task is to
 * complete the function nCr() which takes n and r as input parameters and
 * returns nCr modulo 109+7..
 * 
 * 
 * Expected Time Complexity: O(n*r) Expected Auxiliary Space: O(r)
 *
 */

/**
 * 
 *  C(n, k) = C(n-1, k-1) + C(n-1, k)
 *  C(n, 0) = C(n, n) = 1
 *
 */

public class BinomialCoefficient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int nCr(int n, int r) {
		final int mod = 1000000007;
		if (r > n)
			return 0;
		int[][] dp = new int[n + 1][r + 1];
		for (int i = 0; i < n + 1; ++i) {
			for (int j = 0; j < Math.min(i + 1, r + 1); ++j) {
				if (j == 0 || j == i)
					dp[i][j] = 1;
				else
					dp[i][j] = ((dp[i - 1][j - 1] % mod) + (dp[i - 1][j] % mod)) % mod;
			}
		}
		return dp[n][r];
	}

}
