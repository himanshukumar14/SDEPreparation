package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakesAndLadderProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int snakesAndLadders(int[][] board) {
		int n = board.length;
		return bfs(1, n, board);
	}

	public int bfs(int start, int n, int[][] board) {
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		int count = 0;

		queue.add(start);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				int curr = queue.poll();
				visited.add(curr);

				if (curr == n * n)
					return count;

				for (int j = 1; j <= 6 && curr + j <= n * n; ++j) {
					int newpos = curr + j;
					int value = getBoardValue(newpos, board);
					if (!visited.contains(value)) {
						queue.add(value);
					}
				}
			}
			count++;
		}
		return -1;
	}

	public int getBoardValue(int pos, int[][] board) {
		int n = board.length;
		int r = (pos - 1) / n;
		int x = n - 1 - r;
		int y = r % 2 == 0 ? pos - 1 - (r * n) : n + (r * n) - pos;
		return board[x][y] == -1 ? pos : board[x][y];
	}

}
