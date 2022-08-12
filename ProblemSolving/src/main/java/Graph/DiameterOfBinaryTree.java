package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int[] A) {
		Map<Integer, List<Integer>> m = new HashMap<>();
		int n = A.length;
		int root = -1;
		for (int i = 0; i < n; ++i) {
			if (A[i] != -1) {
				List<Integer> node = m.getOrDefault(A[i], new ArrayList<>());
				node.add(i);
				m.put(A[i], node);
				node = m.getOrDefault(i, new ArrayList<>());
				node.add(A[i]);
				m.put(i, node);
			} else {
				root = i;
			}
		}
		int[] leaf = bfs(root, m, n);
		leaf = bfs(leaf[1], m, n);
		return leaf[0] - 1;
	}

	public int[] bfs(int v, Map<Integer, List<Integer>> m, int n) {
		Queue<Integer> q = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		int height = 0;
		int leaf = 0;
		q.add(v);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int x = 0; x < size; ++x) {
				v = q.poll();
				visited.add(v);
				List<Integer> temp = m.get(v);
				if (temp != null) {
					for (int adj : temp) {
						if (!visited.contains(adj))
							q.add(adj);
					}
				}
				if (x == size - 1) {
					height++;
					leaf = v;
				}
			}
		}
		return new int[] { height, leaf };
	}
}
