package Matrix;

import java.util.Arrays;

/**
 * 
 * Given a matrix of integers A of size N x M and an integer B.
 * 
 * In a single operation, B can be added to or subtracted from any element of
 * the matrix.
 * 
 * Find and return the minimum number of operations required to make all the
 * elements of the matrix equal and if it impossible return -1 instead.
 * 
 * NOTE: Rows are numbered from top to bottom and columns are numbered from left
 * to right.

 * Problem Constraints 1 <= N, M <= 1000 -1000 <= A[i] <= 1000 1 <= B <= 1000

 * 
 * Input Format The first argument given is the integer matrix A. The second
 * argument given is the integer B.

 * Output Format Return the minimum number of operations required to make all
 * the elements of the matrix equal and if it impossible return -1 instead.
 * 

 * Example Input A = [ [0, 2, 8] [8, 2, 0] [0, 2, 8] ] B = 2
 * 
 * 
 * Example Output 12
 * 
 * 
 * Example Explanation We can make all value equal to 2 by adding 2 one time to
 * 0's and subtracting 2 three times from 8's. So there are all total 12
 * operations needed to be done.
 *
 */

public class MinimumOprsToMakeAllElementsEqual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int[][] A, int B) {
		int r = A.length;
		int c = A[0].length;
		int[] nums = new int[r * c];

		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				nums[i * c + j] = A[i][j];
				if (Math.abs(A[i][j] - A[0][0]) % B != 0) { // to check if possible or not
					return -1;
				}
			}
		}
		Arrays.sort(nums);
		int median1 = nums[(r * c) / 2];
		int ans = minOper(nums, median1, B); // minimum would be from median
		if (nums.length % 2 == 0) {
			int median2 = nums[((r * c) / 2) - 1];
			int o2 = minOper(nums, median2, B);
			ans = Math.min(ans, o2);
		}
		return ans;
	}

	public int minOper(int[] nums, int median, int B) {
		int oprs = 0;
		for (int i = 0; i < nums.length; ++i) {
			oprs += Math.abs(median - nums[i]) / B;
		}
		return oprs;
	}

}
