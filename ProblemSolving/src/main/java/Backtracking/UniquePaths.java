package Backtracking;

public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		int x = -1;
		int y = -1;
		int numZero = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (A[i][j] == 1) {
					x = i;
					y = j;
				} else if (A[i][j] == 0) {
					numZero++;
				}
			}
		}
		recur(A, x, y, n, m, numZero);
		return 0;
	}

	int sum = 0;

	public void recur(int[][] A, int x, int y, int n, int m, int numZero) {
		if (isValid(x, y, n, m, A) && A[x][y] == 2 && numZero == 0) {
			sum++;
			return;
		} else if (isValid(x, y, n, m, A) && A[x][y] != 2) {
			if (A[x][y] == 0)
				numZero--;
			A[x][y] = A[x][y] == 1 ? 3 : -1;
			recur(A, x + 1, y, n, m, numZero);
			recur(A, x - 1, y, n, m, numZero);
			recur(A, x, y + 1, n, m, numZero);
			recur(A, x, y - 1, n, m, numZero);
			A[x][y] = A[x][y] == 3 ? 1 : 0;
			if (A[x][y] == 0)
				numZero++;
		}
	}

	public boolean isValid(int x, int y, int n, int m, int[][] A) {
		if (x >= 0 && x < n && y >= 0 && y < m && A[x][y] != -1 && A[x][y] != 3) {
			return true;
		}
		return false;
	}

}
