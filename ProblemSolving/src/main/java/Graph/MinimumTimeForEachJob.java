package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * Given a Directed Acyclic Graph having V vertices and E edges, where each edge
 * {U, V} represents the Jobs U and V such that Job V can only be started only
 * after completion of Job U. The task is to determine the minimum time taken by
 * each job to be completed where each Job takes unit time to get completed.
 *
 */

public class MinimumTimeForEachJob {

	public static void getMinTime(int[][] edges, int n) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
		int[] indegree = new int[n];

		for (int i = 0; i < edges.length; ++i) {
			indegree[edges[i][1]]++;
			List<Integer> list = graph.getOrDefault(edges[i][0], new ArrayList<>());
			list.add(edges[i][1]);
			graph.put(edges[i][0], list);
		}

		for (int i = 0; i < n; ++i) {
			if (indegree[i] == 0)
				queue.add(i);
		}
		int[] ans = topologicalSorting(queue, n, graph, indegree);
		for (int x : ans) {
			System.out.println(x);
		}
	}

	public static int[] topologicalSorting(Queue<Integer> queue, int n, Map<Integer, List<Integer>> graph,
			int[] indegree) {
		int time = 1;
		int[] timeTrack = new int[n];

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				int curr = queue.poll();
				timeTrack[curr] = time;

				List<Integer> list = graph.get(curr);
				if (list != null) {
					for (int adj : list) {
						indegree[adj]--;
						if (indegree[adj] == 0)
							queue.add(adj);
					}
				}
			}
			time++;
		}
		return timeTrack;
	}

	// Driver Code
	public static void main(String[] args) {
		int n = 10;
		int[][] edges = new int[][] { { 0, 2 }, { 0, 3 }, { 0, 4 }, { 1, 2 }, { 1, 7 }, { 1, 8 }, { 2, 5 }, { 3, 5 },
				{ 3, 7 }, { 4, 7 }, { 5, 6 }, { 6, 7 }, { 7, 9 } };
		getMinTime(edges, n);
	}

}
