package Graph;

import java.util.Stack;

/**
 * 
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that
 * are 4-directionally surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 *
 */

public class SurroundedRegions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void solve(char[][] board) {
		if (board.length == 0)
			return;
		int n = board.length;
		int m = board[0].length;

		for (int i = 0, j = 0; j < m; ++j) {
			if (board[i][j] == 'O')
				dfs(i, j, n, m, board);
		}

		for (int i = n - 1, j = 0; j < m; ++j) {
			if (board[i][j] == 'O')
				dfs(i, j, n, m, board);
		}

		for (int j = 0, i = 1; i < n - 1; ++i) {
			if (board[i][j] == 'O')
				dfs(i, j, n, m, board);
		}

		for (int j = m - 1, i = 1; i < n - 1; ++i) {
			if (board[i][j] == 'O')
				dfs(i, j, n, m, board);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; ++j) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				if (board[i][j] == 'I')
					board[i][j] = 'O';
			}
		}
	}

	public void dfs(int x, int y, int n, int m, char[][] board) {
		int[] xpath = new int[] { 0, 1, 0, -1 };
		int[] ypath = new int[] { 1, 0, -1, 0 };
		Stack<int[]> s = new Stack<>();
		s.push(new int[] { x, y });

		while (!s.isEmpty()) {
			int[] temp = s.pop();
			int xc = temp[0];
			int yc = temp[1];

			board[xc][yc] = 'I';

			for (int i = 0; i < 4; ++i) {
				int nx = xc + xpath[i];
				int ny = yc + ypath[i];
				if (isValid(nx, ny, n, m) && board[nx][ny] == 'O')
					s.push(new int[] { nx, ny });
			}
		}
	}

	public boolean isValid(int x, int y, int n, int m) {
		if (x >= 0 && x < n && y >= 0 && y < m)
			return true;
		return false;
	}

}
