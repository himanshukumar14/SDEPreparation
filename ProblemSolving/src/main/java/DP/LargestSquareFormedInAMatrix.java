package DP;

/**
 * 
 * Given a binary matrix mat of size n * m, find out the maximum size square
 * sub-matrix with all 1s.
 * 
 * Example 1:
 * 
 * Input: n = 2, m = 2 mat = {{1, 1}, {1, 1}} Output: 2 Explaination: The
 * maximum size of the square sub-matrix is 2. The matrix itself is the maximum
 * sized sub-matrix in this case. Example 2:
 * 
 * Input: n = 2, m = 2 mat = {{0, 0}, {0, 0}} Output: 0 Explaination: There is
 * no 1 in the matrix.
 *
 */

public class LargestSquareFormedInAMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxSquare(int n, int m, int mat[][]) {
		// code here
		int[][] dp = new int[n + 1][m + 1];
		int max = 0;
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				if (mat[i - 1][j - 1] == 1) {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max;
	}

}
