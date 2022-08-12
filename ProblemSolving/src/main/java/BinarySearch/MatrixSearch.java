package BinarySearch;

/**
 * 
 * Given a matrix of integers A of size N x M and an integer B. Write an
 * efficient algorithm that searches for integer B in matrix A.
 * 
 * This matrix A has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than or equal to the last integer of the previous row. Return
 * 1 if B is present in A, else return 0.
 * 
 * NOTE: Rows are numbered from top to bottom, and columns are from left to
 * right.
 * 
 * 
 * 
 * Problem Constraints 1 <= N, M <= 1000 1 <= A[i][j], B <= 106
 * 
 * 
 * 
 * Input Format The first argument given is the integer matrix A. The second
 * argument given is the integer B.
 * 
 * 
 * 
 * Output Format Return 1 if B is present in A else, return 0.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [ [1, 3, 5, 7] [10, 11, 16, 20] [23, 30, 34, 50] ] B = 3 Input 2:
 * 
 * A = [ [5, 17, 100, 111] [119, 120, 127, 131] ] B = 3
 * 
 * 
 * Example Output Output 1:
 * 
 * 1 Output 2:
 * 
 * 0
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * 3 is present in the matrix at A[0][1] position so return 1. Explanation 2:
 * 
 * 3 is not present in the matrix so return 0.
 *
 */

public class MatrixSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// O(n+m)
	// public int searchMatrix(int[][] A, int B) {
	// int i = 0;
	// int j= A[0].length - 1;

	// while(i < A.length && j >= 0) {
	// if(B == A[i][j])
	// return 1;
	// else if(B < A[i][j]) {
	// j--;
	// } else if(B > A[i][j]) {
	// i++;
	// }
	// }
	// return 0;
	// }

	// O(Log(n*m))
	
	// --------------------------------------------------------------------------------------------------------------
	// Easier to understand
	public boolean searchMatrix2(int[][] matrix, int target) {
		int lo = 0;
		if (matrix.length == 0)
			return false;
		int n = matrix.length;
		int m = matrix[0].length;
		int hi = (n * m) - 1;

		while (lo <= hi) {
			int mid = (lo + (hi - lo) / 2);
			if (matrix[mid / m][mid % m] == target) {
				return true;
			} else if (matrix[mid / m][mid % m] < target) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return false;
	}
	
	//--------------------------------------------------------------------------------------------------------------------------
	//Hard to understand
	public int searchMatrix(int[][] A, int B) {
		int r = A.length;
		int c = A[0].length;

		return sortedbinarysearch(A, r, c, B);
	}

	public int sortedbinarysearch(int[][] A, int n, int m, int x) {
		if (n == 1)
			return binarysearch(A, 0, 0, m - 1, x);

		int i_low = 0;
		int i_high = n - 1;
		int j_mid = m / 2;
		while ((i_low + 1) < i_high) {
			int i_mid = (i_low + i_high) / 2;

			if (A[i_mid][j_mid] == x)
				return 1;
			else if (A[i_mid][j_mid] > x)
				i_high = i_mid;
			else
				i_low = i_mid;
		}

		if (A[i_low][j_mid] == x)
			return 1;
		else if (A[i_low + 1][j_mid] == x)
			return 1;
		else if (j_mid > 0 && x <= A[i_low][j_mid - 1])
			return binarysearch(A, i_low, 0, j_mid - 1, x);
		else if (j_mid < m - 1 && x >= A[i_low][j_mid + 1] && x <= A[i_low][m - 1])
			return binarysearch(A, i_low, j_mid + 1, m - 1, x);
		else if (j_mid > 0 && x <= A[i_low + 1][j_mid - 1])
			return binarysearch(A, i_low + 1, 0, j_mid - 1, x);
		else if (j_mid < m - 1)
			return binarysearch(A, i_low + 1, j_mid + 1, m - 1, x);
		return 0;
	}

	public int binarysearch(int[][] A, int i, int j_low, int j_high, int x) {
		while (j_low <= j_high) {
			int mid = (j_low + j_high) / 2;

			if (A[i][mid] == x)
				return 1;
			else if (A[i][mid] > x)
				j_high = mid - 1;
			else
				j_low = mid + 1;
		}
		return 0;
	}



}
