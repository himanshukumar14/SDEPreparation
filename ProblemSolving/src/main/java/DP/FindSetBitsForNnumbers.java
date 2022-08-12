package DP;

/**
 * 
 * You are given a number N and for all number from 0 to N, you have to find the
 * number of set bits. Return an array of size N such that array[i] = number of
 * set bits in i
 *
 */

public class FindSetBitsForNnumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] findSetBits(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 1; i < n; ++i) {
			dp[i] = dp[i >> 2] + (i % 2);
		}
		return dp;
	}
}
