package DP;

/**
 * 
 * Given a 2D integer matrix A of size N x M.
 * 
 * 
 * From A[i][j] you can move to A[i+1][j], if A[i+1][j] > A[i][j], or can move
 * to A[i][j+1] if A[i][j+1] > A[i][j].
 * 
 * The task is to find and output the longest path length possible if we start
 * from the cell (0, 0) and want to reach cell (N - 1, M - 1).
 * 
 * NOTE:
 *  
 * If there doesn't exist a path return -1.
 *  
 * Problem Constraints 1 <= N, M <= 103
 * 
 * 1 <= A[i][j] <= 108
 *  
 * 
 * Input Format First and only argument is an 2D integer matrix A of size N x M.
 *  
 * 
 * Output Format Return a single integer denoting the length of longest path in
 * the matrix if no such path exists return -1.
 *  
 * 
 * Example Input Input 1:
 * 
 * A = [ [1, 2] [3, 4] ] Input 2:
 * 
 * A = [ [1, 2, 3, 4] [2, 2, 3, 4] [3, 2, 3, 4] [4, 5, 6, 7] ]
 * 
 * 
 * Example Output Output 1:
 * 
 * 3 Output 2:
 * 
 * 7
 *
 * 
 */

public class IncreasingPathInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		int[][] dp = new int[n][m];
		dp[0][0] = 1;
		for (int i = 1; i < n; ++i) {
			dp[i][0] = dp[i - 1][0] > 0 && A[i][0] > A[i - 1][0] ? dp[i - 1][0] + 1 : dp[i][0];
		}
		for (int i = 1; i < m; ++i) {
			dp[0][i] = dp[0][i - 1] > 0 && A[0][i] > A[0][i - 1] ? dp[0][i - 1] + 1 : dp[0][i];
		}

		for (int i = 1; i < n; ++i) {
			for (int j = 1; j < m; ++j) {
				int val1 = 0;
				if (dp[i - 1][j] > 0 && A[i][j] > A[i - 1][j]) {
					val1 = dp[i - 1][j] + 1;
				}
				int val2 = 0;
				if (dp[i][j - 1] > 0 && A[i][j] > A[i][j - 1]) {
					val2 = dp[i][j - 1] + 1;
				}
				dp[i][j] = Math.max(val1, val2);
			}
		}
		return dp[n - 1][m - 1] > 0 ? dp[n - 1][m - 1] : -1;
	}
}
