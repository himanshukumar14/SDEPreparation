package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BipartiteGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int A, int[][] B) {
		int n = B.length;

		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			List<Integer> temp = graph.getOrDefault(B[i][0], new ArrayList<>());
			temp.add(B[i][1]);
			graph.put(B[i][0], temp);

			temp = graph.getOrDefault(B[i][1], new ArrayList<>());
			temp.add(B[i][0]);
			graph.put(B[i][1], temp);
		}

		Set<Integer> visited = new HashSet<>();
		Set[] colorSet = new Set[2];
		colorSet[0] = new HashSet<Integer>();
		colorSet[1] = new HashSet<Integer>();

		for (int i = 0; i < A; ++i) {
			if (!visited.contains(i)) {
				if (!bfs(i, visited, colorSet, graph)) {
					return 0;
				}
			}
		}
		return 1;
	}

	public boolean bfs(int node, Set<Integer> visited, Set[] colorSet, Map<Integer, List<Integer>> m) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		colorSet[0].add(node);
		while (!q.isEmpty()) {
			int curr = q.poll();
			visited.add(curr);
			int color = colorSet[0].contains(curr) ? 0 : 1;
			List<Integer> l = m.get(curr);
			if (l != null) {
				for (int adj : l) {
					if (!visited.contains(adj)) {
						if (!colorSet[0].contains(adj) && !colorSet[1].contains(adj)) {
							q.add(adj);
							colorSet[1 - color].add(adj);
						} else if (colorSet[color].contains(adj)) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

}
