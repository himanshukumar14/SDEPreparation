package String;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] xpath = new int[] { 0, 0, 1, -1 };
	int[] ypath = new int[] { 1, -1, 0, 0 };

	public boolean exist(char[][] board, String word) {
		char ch = word.charAt(0);
		boolean ans = false;
		int[][] visited = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				if (board[i][j] == ch)
					ans = ans | recur(i, j, board, word, visited, "", 0);
			}
		}
		return ans;
	}

	public boolean recur(int x, int y, char[][] board, String target, int[][] visited, String curr, int index) {
		visited[x][y] = 1;
		curr = curr + board[x][y];

		if (curr.length() == target.length() && curr.toString().equals(target))
			return true;

		if (curr.length() == target.length())
			return false;

		boolean ans = false;
		for (int i = 0; i < 4; ++i) {
			int xnew = x + xpath[i];
			int ynew = y + ypath[i];
			if (isValid(xnew, ynew, board.length, board[0].length, visited)
					&& board[xnew][ynew] == target.charAt(index + 1)) {
				ans |= recur(xnew, ynew, board, target, visited, curr, index + 1);
			}
		}
		curr.substring(0, curr.length() - 1);
		visited[x][y] = 0;

		return ans;
	}

	public boolean isValid(int x, int y, int n, int m, int[][] visited) {
		if (x >= 0 && x < n && y >= 0 && y < m && visited[x][y] != 1)
			return true;
		return false;
	}

}
