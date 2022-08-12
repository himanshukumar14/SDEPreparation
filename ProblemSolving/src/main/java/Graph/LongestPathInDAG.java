package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * Given a Weighted Directed Acyclic Graph (DAG) and a source vertex s in it,
 * find the longest distances from s to all other vertices in the given graph.
 * The longest path problem for a general graph is not as easy as the shortest
 * path problem because the longest path problem doesn’t have optimal
 * substructure property. In fact, the Longest Path problem is NP-Hard for a
 * general graph. However, the longest path problem has a linear time solution
 * for directed acyclic graphs. The idea is similar to linear time solution for
 * shortest path in a directed acyclic graph., we use Topological Sorting. We
 * initialize distances to all vertices as minus infinite and distance to source
 * as 0, then we find a topological sorting of the graph. Topological Sorting of
 * a graph represents a linear ordering of the graph (See below, figure (b) is a
 * linear representation of figure (a) ). Once we have topological order (or
 * linear representation), we one by one process all vertices in topological
 * order. For every vertex being processed, we update distances of its adjacent
 * using distance of current vertex.
 *
 */

public class LongestPathInDAG {

	public static Stack<Integer> topologicalSortDFS(int n, Map<Integer, Map<Integer, Integer>> graph) {
		Set<Integer> visited = new HashSet<>();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			if (!visited.contains(i)) {
				dfs(i, visited, graph, stack);
			}
		}
		return stack;
	}

	public static void dfs(int curr, Set<Integer> visited, Map<Integer, Map<Integer, Integer>> graph,
			Stack<Integer> order) {
		visited.add(curr);

		Map<Integer, Integer> map = graph.get(curr);
		if (map != null) {
			for (int adj : map.keySet()) {
				if (!visited.contains(adj))
					dfs(adj, visited, graph, order);
			}
		}
		order.add(curr);
	}

	public static void longestPath(int source, int[][] edges, int n) {
		Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

		for (int i = 0; i < edges.length; ++i) {
			Map<Integer, Integer> map = graph.getOrDefault(edges[i][0], new HashMap<>());
			map.put(edges[i][1], edges[i][2]);
			graph.put(edges[i][0], map);
		}

		int dist[] = new int[n];
		for (int i = 0; i < n; i++)
			dist[i] = Integer.MIN_VALUE;

		dist[source] = 0;

		Stack<Integer> stack = topologicalSortDFS(n, graph);

		while (!stack.isEmpty()) {
			int u = stack.pop();

			// want to calculate distance from starting source
			if (graph.get(u) != null && dist[u] != Integer.MIN_VALUE) {
				for (Entry<Integer, Integer> adjMap : graph.get(u).entrySet()) {
					int adj = adjMap.getKey();
					int weight = adjMap.getValue();
					// System.out.println(u + " " + adj + " " + weight);
					if (dist[adj] < dist[u] + weight)
						dist[adj] = dist[u] + weight;
				}
			}
		}

		for (int i = 0; i < n; i++)
			if (dist[i] == Integer.MIN_VALUE)
				System.out.print("INF ");
			else
				System.out.print(dist[i] + " ");

	}

	// Driver program to test above functions
	public static void main(String args[]) {
		int n = 6;
		int[][] edges = new int[][] { { 0, 1, 5 }, { 0, 2, 3 }, { 1, 3, 6 }, { 1, 2, 2 }, { 2, 4, 4 }, { 2, 5, 2 },
				{ 2, 3, 7 }, { 3, 5, 1 }, { 3, 4, -1 }, { 4, 5, -2 } };

		int source = 1;
		System.out.print("Following are longest distances from source vertex " + source + " \n");
		longestPath(source, edges, n);

	}

}
