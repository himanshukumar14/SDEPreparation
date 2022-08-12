package Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * 
 * Example 1:
 * 
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]] Output: [1,2,3,6,9,8,7,4,5]
 *
 */

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<>();
		if (matrix.length == 0)
			return ans;
		int r1 = 0;
		int r2 = matrix.length - 1;
		int c1 = 0;
		int c2 = matrix[0].length - 1;
		while (r1 <= r2 && c1 <= c2) {
			for (int i = c1; i <= c2; ++i)
				ans.add(matrix[r1][i]);
			for (int i = r1 + 1; i <= r2; ++i)
				ans.add(matrix[i][c2]);
			if (r1 < r2 && c1 < c2) { // we have this condition to stop looping
				for (int i = c2 - 1; i >= c1; --i)
					ans.add(matrix[r2][i]);
				for (int i = r2 - 1; i >= r1 + 1; --i)
					ans.add(matrix[i][c1]);
			}
			r1++;
			c1++;
			r2--;
			c2--;
		}
		return ans;
	}

}
