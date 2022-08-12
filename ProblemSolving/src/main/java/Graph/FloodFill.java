package Graph;

import java.util.Stack;

public class FloodFill {

	/**
	 * 
	 * An image is represented by an m x n integer grid image where image[i][j]
	 * represents the pixel value of the image.
	 * 
	 * You are also given three integers sr, sc, and newColor. You should perform a
	 * flood fill on the image starting from the pixel image[sr][sc].
	 * 
	 * To perform a flood fill, consider the starting pixel, plus any pixels
	 * connected 4-directionally to the starting pixel of the same color as the
	 * starting pixel, plus any pixels connected 4-directionally to those pixels
	 * (also with the same color), and so on. Replace the color of all of the
	 * aforementioned pixels with newColor.
	 * 
	 * Return the modified image after performing the flood fill.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int[] start = new int[] { sr, sc };
		int[] xpath = new int[] { 0, 0, 1, -1 };
		int[] ypath = new int[] { 1, -1, 0, 0 };
		dfs(start, image[sr][sc], newColor, xpath, ypath, image);
		return image;
	}

	public void dfs(int[] start, int color, int newColor, int[] xpath, int[] ypath, int[][] image) {
		int n = image.length;
		int m = image[0].length;
		Stack<int[]> stack = new Stack<>();
		boolean[][] visited = new boolean[n][m];

		stack.add(start);

		while (!stack.isEmpty()) {
			int[] curr = stack.pop();
			visited[curr[0]][curr[1]] = true;
			image[curr[0]][curr[1]] = newColor;

			for (int i = 0; i < 4; ++i) {
				int xnew = curr[0] + xpath[i];
				int ynew = curr[1] + ypath[i];

				if (isSafe(xnew, ynew, n, m, visited) && image[xnew][ynew] == color)
					stack.add(new int[] { xnew, ynew });
			}
		}
	}

	public boolean isSafe(int x, int y, int n, int m, boolean[][] visited) {
		if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y])
			return true;
		return false;
	}

}
