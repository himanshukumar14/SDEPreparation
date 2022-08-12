package DP;

/**
 * 
 * Given a matrix of 2 rows, if you select an element, you can't select
 * immediate diagonals, immediate horizontals and immediate vertical. Find the
 * maximum sum of elements you can select.
 *
 */

//Scaler lecture
//Similar to house robber

public class MatrixSelection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int selectMatrix(int[][] matrix) {
		int n = matrix[0].length;
		// we will take only elements which in greater in between two rows, since if we
		// select one we can't select the vertical other

		int[] mat = new int[n];
		for (int i = 0; i < n; ++i) {
			mat[i] = Math.max(matrix[0][i], matrix[1][i]);
		}
		return robLogic(mat);
	}

	public int robLogic(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return nums[0];

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = nums[0];

		for (int i = 2; i < n + 1; ++i) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
		}
		return dp[n];
	}

}
