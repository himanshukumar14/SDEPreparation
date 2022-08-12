package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Given an N x M matrix A of non-negative integers representing the height of
 * each unit cell in a continent, the "Blue lake" touches the left and top edges
 * of the matrix and the "Red lake" touches the right and bottom edges.
 * 
 * Water can only flow in four directions (up, down, left, or right) from a cell
 * to another one with height equal or lower.
 * 
 * Find the number of cells from where water can flow to both the Blue and Red lake.
 * 
 * Problem Constraints 1 <= M, N <= 1000
 * 
 * 1 <= A[i][j] <= 109
 * 
 * Input Format First and only argument is a 2D matrix A.
 * 
 * Output Format Return an integer denoting the number of cells from where water
 * can flow to both the Blue and Red lake.
 * 
 * Example Input Input 1:
 * 
 * A = [ [1, 2, 2, 3, 5] [3, 2, 3, 4, 4] [2, 4, 5, 3, 1] [6, 7, 1, 4, 5] [5, 1,
 * 1, 2, 4] ] Input 2:
 * 
 * A = [ [2, 2] [2, 2] ]
 * 
 * 
 * Example Output Output 1:
 * 
 * 7 Output 2:
 * 
 * 4
 * Example Explanation Explanation 1:
 * 
 * Blue Lake ~ ~ ~ ~ ~ ~ 1 2 2 3 (5) * ~ 3 2 3 (4) (4) * ~ 2 4 (5) 3 1 * ~ (6)
 * (7) 1 4 5 * ~ (5) 1 1 2 4 * * * * * Red Lake Water can flow to both lakes
 * from the cells denoted in parentheses.
 * 
 * Explanation 2:
 * 
 * Water can flow from all cells.
 *
 */

public class WaterFlow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		boolean[][] visitedBlue = new boolean[n][m];
		boolean[][] visitedRed = new boolean[n][m];
		Queue<int[]> q1 = new LinkedList<>();
		Queue<int[]> q2 = new LinkedList<>();
		for (int i = 0; i < m; ++i) {
			q1.add(new int[] { 0, i });
			q2.add(new int[] { n - 1, i });
		}
		for (int i = 0; i < n; ++i) {
			q2.add(new int[] { i, m - 1 });
			q1.add(new int[] { i, 0 });
		}
		bfs(q1, visitedBlue, n, m, A);
		bfs(q2, visitedRed, n, m, A);

		List<int[]> res = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visitedBlue[i][j] && visitedRed[i][j])
					res.add(new int[] { i, j });
			}
		}
		return res.size();
	}

	public boolean isSafe(int x, int y, int n, int m, boolean[][] visited) {
		return x >= 0 && x < n && y >= 0 && y < m && !visited[x][y];
	}

	public void bfs(Queue<int[]> q, boolean[][] visited, int n, int m, int[][] A) {
		int[] xpath = new int[] { 0, 0, 1, -1 };
		int[] ypath = new int[] { 1, -1, 0, 0 };
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0];
			int y = curr[1];
			visited[x][y] = true;
			for (int i = 0; i < 4; ++i) {
				int xnew = x + xpath[i];
				int ynew = y + ypath[i];
				if (isSafe(xnew, ynew, n, m, visited) && A[xnew][ynew] >= A[x][y]) {
					q.add(new int[] { xnew, ynew });
				}
			}
		}
	}

}
