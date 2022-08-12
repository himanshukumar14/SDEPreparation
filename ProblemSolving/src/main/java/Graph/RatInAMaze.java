package Graph;

import java.util.ArrayList;

/**
 * 
 * Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to
 * reach the destination at (N - 1, N - 1). Find all possible paths that the rat
 * can take to reach from source to destination. The directions in which the rat
 * can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell
 * in the matrix represents that it is blocked and rat cannot move to it while
 * value 1 at a cell in the matrix represents that rat can be travel through it.
 * Note: In a path, no cell can be visited more than one time. If the source
 * cell is 0, the rat cannot move to any other cell.
 * 
 * Example 1:
 * 
 * Input: N = 4 m[][] = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}}
 * Output: DDRDRR DRDDRR Explanation: The rat can reach the destination at (3,
 * 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order
 * we get DDRDRR DRDDRR.
 *
 */

public class RatInAMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] xpath = new int[] { 0, 0, 1, -1 };
	public static int[] ypath = new int[] { 1, -1, 0, 0 };
	public static String[] dirpath = new String[] { "R", "L", "D", "U" };

	public static ArrayList<String> findPath(int[][] m, int n) {
		// Your code here
		int[][] visited = new int[n][n];
		ArrayList<String> ans = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		dfs(new int[] { 0, 0 }, new int[] { n - 1, n - 1 }, visited, ans, sb, n, m);
		return ans;
	}

	public static void dfs(int[] start, int[] end, int[][] visited, ArrayList<String> ans, StringBuilder sb, int n,
			int[][] m) {
		if (!isSafe(start[0], start[1], m, n, visited))
			return;
		if (start[0] == end[0] && start[1] == end[1]) {
			ans.add(sb.toString());
			return;
		}

		visited[start[0]][start[1]] = 1;
		for (int i = 0; i < 4; ++i) {
			int xnew = start[0] + xpath[i];
			int ynew = start[1] + ypath[i];
			if (isSafe(xnew, ynew, m, n, visited)) {
				sb.append(dirpath[i]);
				dfs(new int[] { xnew, ynew }, end, visited, ans, sb, n, m);
				sb.delete(sb.length() - 1, sb.length());
			}
		}
		visited[start[0]][start[1]] = 0;
	}

	public static boolean isSafe(int row, int col, int m[][], int n, int visited[][]) {
		if (row >= 0 && row < n && col >= 0 && col < n && visited[row][col] == 0 && m[row][col] == 1)
			return true;
		return false;
	}

}
