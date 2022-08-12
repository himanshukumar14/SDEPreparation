package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] topologicalSort(int n, int[][] edges) {
		int[] indegree = new int[n];
		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int i = 0; i < edges.length; ++i) {
			indegree[edges[i][1]]++;
			List<Integer> list = graph.getOrDefault(edges[i][0], new ArrayList<>());
			list.add(edges[i][1]);
			graph.put(edges[i][0], list);
		}
		// Using PriorityQueue to maintain lexicogrphical ordering
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < n; ++i) {
			if (indegree[i] == 0)
				pq.add(i);
		}
		return bfs(n, pq, indegree, graph);
	}

	public int[] bfs(int n, PriorityQueue<Integer> pq, int[] indegree, Map<Integer, List<Integer>> graph) {
		// Doesn't need visited array since it is a DAG
		int[] path = new int[n];
		int count = 0;
		while (!pq.isEmpty()) {
			int curr = pq.poll();
			path[count++] = curr;

			List<Integer> list = graph.get(curr);
			if (list != null) {
				for (int adj : list) {
					indegree[adj]--;
					if (indegree[adj] == 0)
						pq.add(adj);
				}
			}
		}
		if (count != n)
			return new int[] {};
		return path;
	}
	
	//-------------------------------------------------------------------
	//DFS Topological Sort
	
	public int[] topologicalSortDFS(int n, int[][] edges) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		Set<Integer> visited = new HashSet<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < edges.length; ++i) {
			List<Integer> list = graph.getOrDefault(edges[i][0], new ArrayList<>());
			list.add(edges[i][1]);
			graph.put(edges[i][0], list);
		}
		
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i, visited, graph, stack);
            }
        }
        int[] ans = new int[n];
        int j = 0;
        while(!stack.isEmpty()) {
        	ans[j++] = stack.pop();
        }
        return ans;
	}
	
	public void dfs(int curr, Set<Integer> visited, Map<Integer, List<Integer>> graph, Stack<Integer> order) {
		visited.add(curr);
		
		List<Integer> list = graph.get(curr);
		if(list != null) {
			for(int adj : list)  {
				if(!visited.contains(adj))
					dfs(adj, visited, graph, order);
			}
		}	
		order.add(curr);
	}

}
