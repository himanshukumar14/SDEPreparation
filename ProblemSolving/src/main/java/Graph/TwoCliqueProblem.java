package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TwoCliqueProblem {

	public static void main(String[] args) {
		int[][] graph = { { 0, 1, 1, 1, 0 }, { 1, 0, 1, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 },
				{ 0, 0, 0, 1, 0 } };
		int v = 5;
		if (canBeDividedinTwoCliques(graph, v))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	public static boolean canBeDividedinTwoCliques(int[][] graph, int v) {
		int graphComplement[][] = new int[v][v];
		for (int i = 0; i < v; i++)
			for (int j = 0; j < v; j++)
				graphComplement[i][j] = (graph[i][j] != 1) && (i != j) ? 1 : 0;

		return isBipartite(graphComplement, v);
	}

	public static boolean isBipartite(int[][] graphComplement, int v) {

		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < v; ++i) {
			for (int j = 0; j < v; ++j) {
				if (graphComplement[i][j] == 1) {
					List<Integer> temp = graph.getOrDefault(i, new ArrayList<>());
					temp.add(j);
					graph.put(i, temp);

					temp = graph.getOrDefault(j, new ArrayList<>());
					temp.add(i);
					graph.put(j, temp);
				}
			}
		}

		Set<Integer> visited = new HashSet<>();
		Set[] colorSet = new Set[2];
		colorSet[0] = new HashSet<Integer>();
		colorSet[1] = new HashSet<Integer>();

		for (int i = 0; i < v; ++i) {
			if (!visited.contains(i))
				return bfs(i, visited, colorSet, graph);
		}
		return true;
	}

	public static boolean bfs(int node, Set<Integer> visited, Set[] colorSet, Map<Integer, List<Integer>> m) {
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
