package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumStepsByKnight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int[] xpath = new int[] { 1, 1, 2, 2, -1, -1, -2, -2 };
	int[] ypath = new int[] { 2, -2, 1, -1, 2, -2, 1, -1 };
	public int knight(int A, int B, int C, int D, int E, int F) {
		int[] start = new int[] { C, D };
		int[] end = new int[] { E, F };

		return bfs(start, end, A, B);
	}

	public int bfs(int[] start, int[] dest, int a, int b) {
		int[][] visited = new int[a][b];
		Queue<int[]> queue = new LinkedList<>();
		int count = 0;

		queue.add(start);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int j = 0; j < size; ++j) {
				int[] curr = queue.poll();
				visited[curr[0]][curr[1]] = 1;

				if (curr[0] == dest[0] && curr[1] == dest[1])
					return count;

				for (int i = 0; i < 8; ++i) {
					int xnew = curr[0] + xpath[i];
					int ynew = curr[1] + ypath[i];

					if (xnew >= 0 && ynew >= 0 && xnew < a && ynew < b && visited[xnew][ynew] == 0) {
						queue.add(new int[] { xnew, ynew });
					}
				}
			}
			count++;

		}
		return -1;
	}

}
