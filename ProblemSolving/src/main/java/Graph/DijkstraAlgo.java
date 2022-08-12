package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		int v;
		Map<Integer, List<Edge>> edgeList;

		Graph(int v) {
			this.v = v;
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

	//Greedy Algo
	public int[] solve(int A, int[][] B, int C) {
		Graph g = new Graph(A);
		for (int i = 0; i < B.length; i++) {
			int src = B[i][0];
			int dest = B[i][1];
			int weight = B[i][2];
			g.addEdge(src, dest, weight);
		}

		int[] distances = new int[A];
		Arrays.fill(distances, -1);

		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			public int compare(Edge e1, Edge e2) {
				return e1.weight - e2.weight;
			}
		});

		pq.add(new Edge(C, C, 0));
		distances[C] = 0;
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			List<Edge> l = g.edgeList.get(e.dest);
			if (l != null) {
				for (Edge neigh : l) {
					int d = distances[e.dest] + neigh.weight;
					if (distances[neigh.dest] == -1 || d < distances[neigh.dest]) {
						distances[neigh.dest] = d;
						neigh.weight = d;
						pq.add(neigh);
					}
				}
			}
		}
		return distances;
	}

}
