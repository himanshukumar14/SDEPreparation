package Graph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DetectCycleInUndirected {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Using DSU
	public boolean detectCycle(int[][] edges, int n) {
		DisjointSetUnion[] set = new DisjointSetUnion[n];

		for (int i = 0; i < n; ++i) {
			set[i] = new DisjointSetUnion(i, 0);
		}

		for (int[] curr : edges) {
			int x = DisjointSetUnion.find(set, curr[0]);
			int y = DisjointSetUnion.find(set, curr[1]);
			if (x == y)
				return true;
			DisjointSetUnion.union(set, x, y);
		}
		return false;
	}

	// Using DFS // since undirected, uses only visited // if has cycle then run loop over vertex
	public boolean detectCycleDFS(int v, Map<Integer, List<Integer>> graph) {
		Set<Integer> visited = new HashSet<>();
		return dfs(v, visited, -1, graph);
	}

	public boolean dfs(int v, Set<Integer> visited, int parent, Map<Integer, List<Integer>> graph) {
		visited.add(v);
		List<Integer> temp = graph.get(v);
		if(temp != null ) {
			for(int curr : temp) {
				if(!visited.contains(curr)) {
					if(dfs(curr, visited, v, graph))
						return true;
				} else if(curr != parent) { //to ignore back edges in undirected graph
					return true;
				}
			}
		}
		return false;
	}

}
