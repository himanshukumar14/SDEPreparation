package Backtracking;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * The N Queen is the problem of placing N chess queens on an NxN chessboard so
 * that no two queens attack each other. For example, following is a solution
 * for 4 Queen problem.
 */

public class NQueen {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	}

	ArrayList<ArrayList<String>> queens = new ArrayList<>();

	public ArrayList<ArrayList<String>> solveNQueens(int a) {
		int[] col = new int[a];
		for (int i = 0; i < a; ++i) {
			col[i] = Integer.MIN_VALUE;
		}
		findQueens(0, a, col);
		return queens;
	}

	public void findQueens(int r, int n, int[] col) {
		if (r == n) {
			ArrayList<String> l = createSol(col);
			queens.add(new ArrayList<>(l));
			return;
		}
		for (int i = 0; i < n; ++i) {
			if (isValid(r, i, col)) {
				col[r] = i;
				findQueens(r + 1, n, col);
				col[r] = Integer.MIN_VALUE;
			}
		}
	}

	public boolean isValid(int r, int c, int[] col) {
		if (col[r] > Integer.MIN_VALUE)
			return false;
		for (int i = 0; i < col.length; ++i) {
			if (i != r) {
				if (c == col[i])
					return false;
				if (((r - i) == (c - col[i])) || ((r + c) == (i + col[i])))
					return false;
			}
		}
		return true;
	}

	public ArrayList<String> createSol(int[] col) {
		ArrayList<String> queens = new ArrayList<>();
		for (int i = 0; i < col.length; ++i) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < col.length; ++j) {
				if (col[i] == j)
					sb.append("Q");
				else
					sb.append(".");
			}
			queens.add(sb.toString());
		}
		return queens;
	}

}
