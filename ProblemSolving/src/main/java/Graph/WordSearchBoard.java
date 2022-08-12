package Graph;

/**
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The cell
 * itself does not count as an adjacent cell.
 * 
 * The same letter cell may be used more than once.
 * 
 * Example :
 * 
 * Given board =
 * 
 * [ ["ABCE"], ["SFCS"], ["ADEE"] ] word = "ABCCED", -> returns 1, word = "SEE",
 * -> returns 1, word = "ABCB", -> returns 1, word = "ABFSAB" -> returns 1 word
 * = "ABCD" -> returns 0 Note that 1 corresponds to true, and 0 corresponds to
 * false.
 *
 * 
 * 
 */

public class WordSearchBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] xpath = new int[] { 0, 0, 1, -1 };
	public int[] ypath = new int[] { 1, -1, 0, 0 };
	public char[][] board;

	// word search when same cell can be used multiple times
	public int exist(String[] A, String B) {
		int n = A.length;
		int m = A[0].length();
		board = new char[n][m];
		for (int i = 0; i < n; ++i) {
			char[] temp = A[i].toCharArray();
			for (int j = 0; j < m; ++j)
				board[i][j] = temp[j];
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (board[i][j] == B.charAt(0))
					if (dfs(i, j, B, 0, "", n, m))
						return 1;
			}
		}
		return 0;
	}

	public boolean dfs(int x, int y, String target, int i, String word, int n, int m) {
		word += board[x][y];

		if (word.length() == target.length() && word.equals(target))
			return true;

		if (word.length() == target.length())
			return false;

		for (int j = 0; j < 4; ++j) {
			int xnew = x + xpath[j];
			int ynew = y + ypath[j];
			if (isSafe(xnew, ynew, n, m) && target.charAt(i + 1) == board[xnew][ynew]) {
				if (dfs(xnew, ynew, target, i + 1, word, n, m))
					return true;
			}
		}
		word.substring(0, word.length() - 1);
		return false;
	}

	public boolean isSafe(int x, int y, int n, int m) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}

	// -----------------------------------------------------------------------------------------------------------------------------
	// when same cell cant be considered again
	public boolean exist2(char[][] board, String word) {
		int n = board.length;
		int m = board[0].length;
		int[][] visited = new int[n][m];
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				if (board[i][j] == word.charAt(0))
					if (dfs2(i, j, board, word, visited, "", 0, n, m))
						return true;
			}
		}
		return false;
	}

	public boolean dfs2(int x, int y, char[][] board, String target, int[][] visited, String curr, int i, int n,
			int m) {
		visited[x][y] = 1;
		curr += board[x][y];

		if (curr.length() == target.length() && curr.equals(target))
			return true;

		if (curr.length() == target.length())
			return false;

		for (int j = 0; j < 4; ++i) {
			int xnew = x + xpath[j];
			int ynew = y + ypath[j];
			if (isValid(xnew, ynew, n, m, visited) && board[xnew][ynew] == target.charAt(i + 1)) {
				if (dfs2(xnew, ynew, board, target, visited, curr, i + 1, n, m))
					return true;
			}
		}
		curr.substring(0, curr.length() - 1);
		visited[x][y] = 0;
		return false;
	}

	public boolean isValid(int x, int y, int n, int m, int[][] visited) {
		if (x >= 0 && x < n && y >= 0 && y < m && visited[x][y] != 1)
			return true;
		return false;
	}
}
