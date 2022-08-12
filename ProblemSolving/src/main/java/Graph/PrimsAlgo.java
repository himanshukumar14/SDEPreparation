package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PrimsAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int prims(int A, int[][] B) {
		Graph graph = new Graph();
		// build graph
		for (int i = 0; i < B.length; i++) {
			int src = B[i][0];
			int dest = B[i][1];
			int weight = B[i][2];
			graph.addEdge(src, dest, weight);
		}

		// to keep track of weights taken into consideration for MST
		int[] weights = new int[A + 1];
		Arrays.fill(weights, Integer.MAX_VALUE);

		// to keep track of all the vertices visited
		int[] visited = new int[A + 1];

		bfs(1, graph, weights, visited);

		int cost = 0;
		for (int i = 1; i < weights.length; ++i)
			cost += weights[i];
		return cost;
	}

	public void bfs(int vertex, Graph graph, int[] weights, int[] visited) {
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.weight - e2.weight;
			}
		});

		pq.add(new Edge(vertex, vertex, 0));
		weights[vertex] = 0;

		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			visited[curr.dest] = 1;

			List<Edge> nList = graph.edgeList.get(curr.dest);
			if (nList != null) {
				for (Edge neighbour : nList) {
					int w = neighbour.weight;
					if (visited[neighbour.dest] == 0 && w < weights[neighbour.dest]) {
						weights[neighbour.dest] = w;
						pq.add(neighbour);
					}
				}
			}
		}
	}

	class Edge {
		int src;
		int dest;
		int weight;

		Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}

	class Graph {
		Map<Integer, List<Edge>> edgeList;

		Graph() {
			this.edgeList = new HashMap<>();
		}

		void addEdge(int src, int dest, int weight) {
			List<Edge> l = edgeList.getOrDefault(src, new ArrayList<>());
			l.add(new Edge(src, dest, weight));
			edgeList.put(src, l);
			l = edgeList.getOrDefault(dest, new ArrayList<>());
			l.add(new Edge(dest, src, weight));
			edgeList.put(dest, l);
		}
	}

}
