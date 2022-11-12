package Backtracking;

import java.util.ArrayList;

/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.
 */

public class Sudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void solveSudoku(ArrayList<ArrayList<Character>> a) {
		solveSudoku(0, 0, a.size(), a);
	}

	public boolean solveSudoku(int r, int c, int n, ArrayList<ArrayList<Character>> a) {
		if (c >= n) {
			c = 0;
			r++;
		}
		if (r >= n) {
			return true;
		}
		if (a.get(r).get(c) != '.') {
			return solveSudoku(r, c + 1, n, a);
		}
		for (int i = 1; i <= n; ++i) {
			a.get(r).set(c, (char) (48 + i));
			if (isValid(a, r, c, n) && solveSudoku(r, c + 1, n, a)) {
				return true;
			} else {
				a.get(r).set(c, '.');
			}
		}
		return false;
	}

	public boolean isValid(ArrayList<ArrayList<Character>> a, int r, int c, int n) {
		int l = (int) Math.sqrt(n);
		int b = n / l;
		int xh = (r / l) * l;
		int yh = (c / b) * b;
		for (int i = 0; i < n; ++i) {
			if (i != r && (a.get(r).get(c) == a.get(i).get(c)))
				return false;
			if (i != c && (a.get(r).get(c) == a.get(r).get(i)))
				return false;
		}

		for (int i = xh; i < xh + l; ++i) {
			for (int j = yh; j < yh + b; ++j) {
				if (i != r && j != c && (a.get(i).get(j) == a.get(r).get(c)))
					return false;
			}
		}
		return true;
	}

}
