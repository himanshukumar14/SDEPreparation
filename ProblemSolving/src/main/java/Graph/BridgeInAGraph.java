//package Graph;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
////uses articulation point concept
//public class BridgeInAGraph {
//
//	private int v;
//
//	int time = 0;
//	static final int NIL = -1;
//
//	void bridgeUtil(int u, boolean visited[], int disc[], int low[], int parent[]) {
//
//		visited[u] = true;
//
//		disc[u] = low[u] = ++time;
//
//		Iterator<Integer> i = adj[u].iterator();
//		while (i.hasNext()) {
//			int v = i.next();
//
//			if (!visited[v]) {
//				parent[v] = u;
//				bridgeUtil(v, visited, disc, low, parent);
//
//				low[u] = Math.min(low[u], low[v]);
//
//				if (low[v] > disc[u])
//					System.out.println(u + " " + v);
//			}
//
//			else if (v != parent[u])
//				low[u] = Math.min(low[u], disc[v]);
//		}
//	}
//
//	public static void bridge(int[][] edges, int v) {
//		Map<Integer, List<Integer>> graph = new HashMap<>();
//		for (int i = 0; i < v; ++i) {
//			List<Integer> temp = graph.getOrDefault(edges[i][0], new ArrayList<>());
//			temp.add(edges[i][1]);
//			graph.put(edges[i][0], temp);
//
//			temp = graph.getOrDefault(edges[i][1], new ArrayList<>());
//			temp.add(edges[i][0]);
//			graph.put(edges[i][1], temp);
//		}
//
//		Set<Integer> visited = new HashSet<>();
//		int disc[] = new int[V];
//		int low[] = new int[V];
//		int parent[] = new int[V];
//
//		for (int i = 0; i < v; i++) {
//			parent[i] = NIL;
//		}
//
//		for (int i = 0; i < v; i++)
//			if (!visited.contains(i))
//				bridgeUtil(i, visited, disc, low, parent);
//	}
//
//	public static void main(String args[]) {
//		System.out.println("Bridges in first graph ");
//		int[][] graph1 = new int[][] { { 1, 0 }, { 0, 2 }, { 2, 1 }, { 0, 3 }, { 3, 4 } };
//		bridge(graph1, 5);
//		System.out.println();
//
//		System.out.println("Bridges in Second graph");
//		int[][] graph2 = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 } };
//		bridge(graph2, 3);
//		System.out.println();
//
//		System.out.println("Bridges in Third graph ");
//		int[][] graph3 = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 1, 3 }, { 1, 4 }, { 1, 6 }, { 3, 5 }, { 4, 5 } };
//		bridge(graph3, 8);
//	}
//
//}
