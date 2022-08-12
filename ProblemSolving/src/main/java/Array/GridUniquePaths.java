package Array;

/**
 * 
 * Problem Statement: Given a matrix m X n, count paths from left-top to the
 * right bottom of a matrix with the constraints that from each cell you can
 * either only move to the rightward direction or the downward direction.
 * 
 * Example 1:
 * 
 * Input Format: m = 2, n= 2 Output: 2
 *
 */

public class GridUniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// dp solution
	public int uniquePaths1(int m, int n) {
		int[][] dp = new int[n + 1][m + 1];
		dp[1][1] = 0;
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[n][m];
	}

	// permutation
	int uniquePaths2(int m, int n) {
		int N = n + m - 2;
		int r = m - 1;
		double res = 1;

		for (int i = 1; i <= r; i++)
			res = res * (N - r + i) / i;
		return (int) res;
	}

}
