package DP;

import java.util.Arrays;

/**
 * 
 * You are given N Strings of same length. Remove some indexed character(>= 0)
 * from each of the string such that in each string S[i] > S[i-1]. Find the
 * minimum number of indexes to be removed
 */

//Scaler
public class RemoveMinimumIndexes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int removeIndexes(String[] input) {
		int m = input.length;
		int n = input[0].length();
		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				boolean valid = true;
				for (int k = 0; k < m; ++k) {
					if (input[j].charAt(k) >= input[i].charAt(k)) {
						valid = false;
						break;
					}
				}
				if (valid)
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		int max = 0;
		for (int i = 0; i < n; ++i) {
			max = Math.max(max, dp[i]);
		}
		return n - max;
	}

}
