package Matrix;

/**
 * 
 * Given a positive integer n, generate an n x n matrix filled with elements
 * from 1 to n2 in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3 Output: [[1,2,3],[8,9,4],[7,6,5]]
 *
 */

public class SpiralMatrix2 {
	public int[][] generateMatrix(int n) {
		int r1 = 0;
		int r2 = n - 1;
		int c1 = 0;
		int c2 = n - 1;
		int count = 1;
		int[][] ans = new int[n][n];

		while (r1 <= r2 && c1 <= c2) {
			for (int i = c1; i <= c2; ++i)
				ans[r1][i] = count++;
			for (int i = r1 + 1; i <= r2; ++i)
				ans[i][c2] = count++;
			if (r1 < r2 && c1 < c2) {
				for (int i = c2 - 1; i >= c1; --i)
					ans[r2][i] = count++;
				for (int i = r2 - 1; i > r1; --i)
					ans[i][c1] = count++;
			}
			r1++;
			c1++;
			r2--;
			c2--;
		}
		return ans;
	}
}
