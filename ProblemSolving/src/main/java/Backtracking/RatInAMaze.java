package Backtracking;

import java.util.ArrayList;

public class RatInAMaze {

	public static ArrayList<String> findPath(int[][] m, int n) {
		// Your code here
		int[] xpath = new int[] { 0, 0, 1, -1 };
		int[] ypath = new int[] { 1, -1, 0, 0 };
		String[] dirpath = new String[] { "R", "L", "D", "U" };
		int[][] visited = new int[n][n];
		ArrayList<String> ans = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		dfs(new int[] { 0, 0 }, new int[] { n - 1, n - 1 }, xpath, ypath, visited, ans, sb, dirpath, n, m);
		return ans;
	}

	public static void dfs(int[] start, int[] end, int[] xpath, int[] ypath, int[][] visited, ArrayList<String> ans,
			StringBuilder sb, String[] dirpath, int n, int[][] m) {
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
				dfs(new int[] { xnew, ynew }, end, xpath, ypath, visited, ans, sb, dirpath, n, m);
				sb.delete(sb.length() - 1, sb.length());
			}
		}
		visited[start[0]][start[1]] = 0;
	}

	public static boolean isSafe(int row, int col, int m[][], int n, int visited[][]) {
		if (row == -1 || row == n || col == -1 || col == n || visited[row][col] == 1 || m[row][col] == 0)
			return false;
		return true;
	}
}
