package Matrix;

/**
 * 
 * Given a m x n matrix mat and an integer k, return a matrix answer where each
 * answer[i][j] is the sum of all elements mat[r][c] for:
 * 
 * i - k <= r <= i + k, j - k <= c <= j + k, and (r, c) is a valid position in
 * the matrix.
 * 
 * 
 * Example 1:
 * 
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1 Output:
 * [[12,21,16],[27,45,33],[24,39,28]] Example 2:
 * 
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2 Output:
 * [[45,45,45],[45,45,45],[45,45,45]]
 *
 */

public class MatrixBlockSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//prefix sum solution
	public int[][] matrixBlockSum(int[][] mat, int k) {
		int n = mat.length;
		int m = mat[0].length;
		int[][] prefixSum = new int[n + 1][m + 1];

		for (int i = 1; i < n + 1; ++i) {
			for (int j = 1; j < m + 1; ++j) {
				prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] + mat[i - 1][j - 1]
						- prefixSum[i - 1][j - 1];
			}
		}
		int[][] ans = new int[n][m];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				int r1 = Math.max(0, i - k);
				int c1 = Math.max(0, j - k);
				int r2 = Math.min(n - 1, i + k);
				int c2 = Math.min(m - 1, j + k);
				r1++;
				r2++;
				c1++;
				c2++;
				ans[i][j] = prefixSum[r2][c2] - prefixSum[r1 - 1][c2] - prefixSum[r2][c1 - 1]
						+ prefixSum[r1 - 1][c1 - 1];
			}
		}
		return ans;
	}

}
