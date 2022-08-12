package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MakingWiredConnections {

	// to make a tree, need v-1 edges, so for v comps need v - 1 cables

	/**
	 * 
	 * We need at least n - 1 cables to connect all nodes (like a tree). If
	 * connections.size() < n - 1, we can directly return -1.
	 * 
	 * One trick is that, if we have enough cables, we don't need to worry about
	 * where we can get the cable from.
	 * 
	 * We only need to count the number of connected networks. To connect two
	 * unconneccted networks, we need to set one cable.
	 * 
	 * The number of operations we need = the number of connected networks - 1
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int makeConnected(int n, int[][] connections) {
		if (connections.length < n - 1)
			return -1;
		int wires = connections.length;
		int spareWire = 0;
		int components = 0;
		int[] parent = new int[n];
		for (int i = 0; i < n; i++)
			parent[i] = -1;

		for (int i = 0; i < wires; ++i) {
			int x = find(parent, connections[i][0]);
			int y = find(parent, connections[i][1]);
			if (x != y)
				union(parent, connections[i][0], connections[i][1]);
			else
				spareWire++;
		}
		for (int i = 0; i < n; i++)
			if (parent[i] == -1)
				components++;
		return spareWire >= components - 1 ? components - 1 : -1;
	}

	public void union(int[] parent, int x, int y) {
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
	}

	public int find(int[] parent, int i) {
		if (parent[i] == -1)
			return i;
		return parent[i] = find(parent, parent[i]);
	}

	// ----------------------------------------------------------------------------------------------------------
// Using Island Number concept
	public int makeConnected1(int n, int[][] connections) {
		if (connections.length < n - 1)
			return -1;

		Map<Integer, List<Integer>> graph = new HashMap<>();
		Set<Integer> visited = new HashSet<>();

		for (int[] x : connections) {
			List<Integer> l = graph.getOrDefault(x[0], new ArrayList<>());
			l.add(x[1]);
			graph.put(x[0], l);
			l = graph.getOrDefault(x[1], new ArrayList<>());
			l.add(x[0]);
			graph.put(x[1], l);
		}

		int components = 0;
		for (int i = 0; i < n; i++)
			if (!visited.contains(i)) {
				dfs(graph, visited, i);
				components++;
			}
		return components - 1;
	}
	
	public void dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int src) {
		visited.add(src);
		List<Integer> l = graph.get(src);
		if (l != null) {
			for (int i : l) {
				if (!visited.contains(i))
					dfs(graph, visited, i);
			}
		}
	}

}
