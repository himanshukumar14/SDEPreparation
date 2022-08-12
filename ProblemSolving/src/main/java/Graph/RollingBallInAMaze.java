package Graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RollingBallInAMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int[][] A, int[] B, int[] C) {
		int n = A.length;
		int m = A[0].length;
		return bfs(B, C, n, m, A);
	}

	public boolean isValid(int x, int y, int n, int m, int[][] a) {
		return x >= 0 && x < n && y >= 0 && y < m && a[x][y] == 0;
	}

	class Pair {
		int x;
		int y;
		int d;

		Pair(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d; //distance
		}
	}

	public int bfs(int[] start, int[] dest, int n, int m, int[][] a) {
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			public int compare(Pair a, Pair b) {
				return a.d - b.d;
			}
		});
		boolean[][][] visited = new boolean[n][m][4];
		pq.add(new Pair(start[0], start[1], 0));
		while (!pq.isEmpty()) {
			Pair p = pq.poll();

			if (p.x == dest[0] && p.y == dest[1])
				return p.d;

			int l = p.x;
			int r = p.y;
			int d = p.d;
			while (isValid(l + 1, r, n, m, a) && !visited[l][r][0]) {  //first we check whether the position we are at is visited
				visited[l][r][0] = true;
				l++;
				d++;
			}
			if (d != p.d)
				pq.add(new Pair(l, r, d));

			l = p.x;
			r = p.y;
			d = p.d;
			while (isValid(l - 1, r, n, m, a) && !visited[l][r][1]) {
				visited[l][r][1] = true;
				l--;
				d++;
			}
			if (d != p.d)
				pq.add(new Pair(l, r, d));

			l = p.x;
			r = p.y;
			d = p.d;
			while (isValid(l, r + 1, n, m, a) && !visited[l][r][2]) {
				visited[l][r][2] = true;
				r++;
				d++;
			}
			if (d != p.d)
				pq.add(new Pair(l, r, d));

			l = p.x;
			r = p.y;
			d = p.d;
			while (isValid(l, r - 1, n, m, a) && !visited[l][r][3]) {
				visited[l][r][3] = true;
				r--;
				d++;
			}
			if (d != p.d)
				pq.add(new Pair(l, r, d));
		}
		return -1;
	}

}
