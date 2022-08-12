package Graph;

/**
 * 
 * A source and destination is given in matrix where source is top left and
 * destination is bottom right and other cell values contain sea level which
 * decreases 1 every year.possible move is right and down. Was asked to find max
 * years till there exist a path b/w source and destination . Path is broken
 * when some cell value beacomes 0
 *
 */

public class FallingSeaLevel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] { { 4, 7, 2 }, { 1, 4, 5 }, { 8, 2, 7 } };
		System.out.println(getLongestLife(matrix));
	}

	public static int getLongestLife(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		dfs(0, 0, n - 1, m - 1, Integer.MAX_VALUE, matrix);
		return globalMax;
	}

	static int globalMax = Integer.MIN_VALUE;
	static int[] xpath = new int[] { 1, 0 };
	static int[] ypath = new int[] { 0, 1 };

	public static void dfs(int x, int y, int xdest, int ydest, int min, int[][] mat) {
		if (x == xdest && y == ydest) {
			min = Math.min(mat[xdest][ydest], min);
			globalMax = Math.max(globalMax, min);
			return;
		}
		for (int i = 0; i < 2; ++i) {
			int xnew = x + xpath[i];
			int ynew = y + ypath[i];
			if (isValid(xnew, ynew, mat)) {
				dfs(xnew, ynew, xdest, ydest, Math.min(min, mat[x][y]), mat);
			}
		}
	}

	public static boolean isValid(int x, int y, int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		return x >= 0 && x < n && y >= 0 && y < m && mat[x][y] > 0;
	}

}
