package Graph;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given an m*n binary matrix mat, return the number of distinct island.
 * 
 * An island is considered to be the same as another if and only if one island
 * can be translated (and not rotated or reflected) to equal the other. Input
 * Format First line contains two integers n and m. Each of next n lines contain
 * n numbers containing either 0 or 1. Output Format print number of distinct
 * island.
 * 
 * 1<= n <= 1000 
 * 1<= e <= n*(n-1)/2 
 * 
 * Sample Input 
 * 3 3 
 * 1 0 0 
 * 0 1 0 
 * 1 1 1 
 * 
 * Sample Output 
 * 2
 *
 */

public class NumberOfDistinctIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int numDistinctIslands(int[][] arr) {
		// write your code here
		int n = arr.length;
		int m = arr[0].length;
		Set<String> distinctIsland = new HashSet<>();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (arr[i][j] == 1) {
					String path = dfs(i, j, arr, n, m, "X");
					distinctIsland.add(path);
				}
			}
		}
		return distinctIsland.size();
	}

	public static int[] xpath = new int[] { 0, 0, 1, -1 };
	public static int[] ypath = new int[] { 1, -1, 0, 0 };

	public static boolean isSafe(int x, int y, int[][] A, int n, int m) {
		if (x >= 0 && x < n && y >= 0 && y < m && A[x][y] == 1)
			return true;
		return false;
	}

	public static String dfs(int x, int y, int[][] A, int n, int m, String path) {
		A[x][y] = -1;

		for (int i = 0; i < 4; ++i) {
			int xnew = x + xpath[i];
			int ynew = y + ypath[i];

			if (isSafe(xnew, ynew, A, n, m)) {
				if (i == 0)
					path += "R";
				else if (i == 1)
					path += "L";
				else if (i == 2)
					path += "D";
				else if (i == 3)
					path += "U";
				path = dfs(xnew, ynew, A, n, m, path);
				path += "Z";
			}
		}
		return path;
	}

}
