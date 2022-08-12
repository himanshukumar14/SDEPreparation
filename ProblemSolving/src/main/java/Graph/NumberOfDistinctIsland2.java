package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Given a non-empty 2D arraygridof 0's and 1's, an island is a group of1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * Count the number of distinct islands. An island is considered to be the same
 * as another if they have the same shape, or have the same shape after rotation
 * (90, 180, or 270 degrees only) or reflection (left/right direction or up/down
 * direction).
 *
 */

public class NumberOfDistinctIsland2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numDistinctIslands2(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		Set<String> set = new HashSet();

		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int[][] transformations = { { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

		int m = grid.length, n = grid[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					List<int[]> cells = new ArrayList();
					getIslandsByDFS(i, j, grid, cells, directions);
					String key = normalize(cells, transformations);
					set.add(key);
				}
			}
		}
		return set.size();
	}

	public void getIslandsByDFS(int row, int col, int[][] grid, List<int[]> cells, int[][] directions) {
		cells.add(new int[] { row, col });
		grid[row][col] = 0;

		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextCol = col + direction[1];

			if (isValid(nextRow, nextCol, grid)) {
				getIslandsByDFS(nextRow, nextCol, grid, cells, directions);
			}
		}
	}

	public boolean isValid(int row, int col, int[][] grid) {
		return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1;
	}

	public String normalize(List<int[]> cells, int[][] transformations) {
		List<String> forms = new ArrayList();

		for (int[] tran : transformations) {
			List<int[]> list1 = new ArrayList();
			List<int[]> list2 = new ArrayList();

			for (int[] cell : cells) {
				int x = cell[0];
				int y = cell[1];

				// Generate the 8 different transformations
				// (x, y), (x, -y), (-x, y), (-x, -y)
				// (y, x), (-y, x), (y, -x), (-y, -x)
				list1.add(new int[] { x * tran[0], y * tran[1] });
				list2.add(new int[] { y * tran[1], x * tran[0] });
			}
			forms.add(getKey(list1));
			forms.add(getKey(list2));
		}

		// Take the first one the represent the shape of the island
		Collections.sort(forms);
		return forms.get(0);
	}

	public String getKey(List<int[]> cells) {
		// Sort the cells and the take the first cell in sorted order as the origin
		Collections.sort(cells, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
			}
		});

		StringBuilder key = new StringBuilder();

		int originX = cells.get(0)[0], originY = cells.get(0)[1];
		// Generate the key
		for (int[] cell : cells) {
			key.append((cell[0] - originX) + ":" + (cell[1] - originY));
		}
		return key.toString();
	}
}
