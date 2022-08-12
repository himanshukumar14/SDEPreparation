package Graph;

/**
 * 
 * Given a matrix of integers A of size N x M consisting of 0 and 1. A group of
 * connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you
 * can visit any cell that shares a corner with (i, j) and value in that cell is
 * 1.
 * 
 * More formally, from any cell (i, j) if A[i][j] = 1 you can visit:
 * 
 * (i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1. (i, j-1) if (i,
 * j-1) is inside the matrix and A[i][j-1] = 1. (i+1, j) if (i+1, j) is inside
 * the matrix and A[i+1][j] = 1. (i, j+1) if (i, j+1) is inside the matrix and
 * A[i][j+1] = 1. (i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1]
 * = 1. (i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1. (i-1,
 * j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1. (i+1, j-1) if
 * (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1. Return the number of
 * islands.
 * 
 * NOTE: Rows are numbered from top to bottom and columns are numbered from left
 * to right.
 * 
 * Problem Constraints 1 <= N, M <= 100
 * 
 * 0 <= A[i] <= 1
 * 
 * Input Format The only argument given is the integer matrix A.
 * 
 * Output Format Return the number of islands.
 * 
 * Example Input Input 1:
 * 
 * A = [ [0, 1, 0] [0, 0, 1] [1, 0, 0] ] Input 2:
 * 
 * A = [ [1, 1, 0, 0, 0] [0, 1, 0, 0, 0] [1, 0, 0, 1, 1] [0, 0, 0, 0, 0] [1, 0,
 * 1, 0, 1] ]
 * 
 * Example Output Output 1:
 * 
 * 2 Output 2:
 * 
 * 5
 * 
 */

public class NumberOfIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] xpath = new int[] { 0, 0, 1, -1, 1, 1, -1, -1 };
	public static int[] ypath = new int[] { 1, -1, 0, 0, 1, -1, 1, -1 };

	public static int solve(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		int count = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (A[i][j] == 1) {
					dfs(i, j, A, n, m);
					count++;
				}
			}
		}
		return count;
	}

	public static boolean isSafe(int x, int y, int[][] A, int n, int m) {
		if (x >= 0 && x < n && y >= 0 && y < m && A[x][y] == 1)
			return true;
		return false;
	}

	public static void dfs(int x, int y, int[][] A, int n, int m) {
		A[x][y] = -1;

		for (int i = 0; i < 8; ++i) {
			int xnew = x + xpath[i];
			int ynew = y + ypath[i];
			if (isSafe(xnew, ynew, A, n, m))
				dfs(xnew, ynew, A, n, m);
		}
	}

}
