package DP;

/**
 * 
 * Permutation refers to the process of arranging all the members of a given set
 * to form a sequence. The number of permutations on a set of n elements is
 * given by n! , where “!” represents factorial.
 * 
 * The coefficient can also be computed recursively using the below recursive
 * formula:
 * 
 * P(n, k) = P(n-1, k) + k* P(n-1, k-1)
 *
 */

public class PermutationCoefficient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int permutationCoeff(int n, int k) {
		int dp[][] = new int[n + 2][k + 2];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {
				if (j == 0)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i - 1][j] + (j * dp[i - 1][j - 1]);
				dp[i][j + 1] = 0;
			}
		}
		return dp[n][k];
	}

}
