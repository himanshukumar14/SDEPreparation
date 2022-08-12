package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
 * 
 * Each cell can have three values:
 * 
 * The value 0 representing an empty cell.
 * 
 * The value 1 representing a fresh orange.
 * 
 * The value 2 representing a rotten orange.
 * 
 * Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom)
 * to a rotten orange becomes rotten. Return the minimum number of minutes that
 * must elapse until no cell has a fresh orange. If this is impossible, return
 * -1 instead.
 * 
 * Note: Your solution will run on multiple test cases. If you are using global
 * variables, make sure to clear them.
 *
 */

public class RottenOranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		int[][] time = new int[n][m];
		Queue<int[]> q = new LinkedList<>();
		int[] a1 = new int[] { 0, 1, 0, -1 };
		int[] a2 = new int[] { 1, 0, -1, 0 };

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (A[i][j] == 2)
					q.add(new int[] { i, j });
				if (A[i][j] != 0)
					time[i][j] = -1;
			}
		}

		while (!q.isEmpty()) {
			int[] tom = q.poll();
			int i = tom[0];
			int j = tom[1];
			time[i][j] = time[i][j] == -1 ? 0 : time[i][j];
			for (int k = 0; k < 4; ++k) {
				int x = i + a1[k];
				int y = j + a2[k];
				if (x >= 0 && x < n && y >= 0 && y < m && A[x][y] == 1) {
					q.add(new int[] { x, y });
					A[x][y] = 2;
					time[x][y] = time[i][j] + 1; // same as nearest cell
				}
			}
		}

		int maxTime = Integer.MIN_VALUE;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (time[i][j] == -1)
					return -1;
				else
					maxTime = Math.max(time[i][j], maxTime);
			}
		}
		return maxTime;
	}

}
