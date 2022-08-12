package Graph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DetectCycleInDirected {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Using DFS
	public boolean detectCycleDFS(int v, Map<Integer, List<Integer>> graph) {
		Set<Integer> visited = new HashSet<>();
		Set<Integer> parent = new HashSet<>();
		return dfs(v, visited, parent, graph);
	}

	public boolean dfs(int v, Set<Integer> visited, Set<Integer> parent, Map<Integer, List<Integer>> graph) {
		if (parent.contains(v))
			return true;
		if (visited.contains(v))
			return false;
		visited.add(v);
		parent.add(v);
		List<Integer> temp = graph.get(v);
		if (temp != null) {
			for (int curr : temp) {
				if (!visited.contains(curr)) {
					if (dfs(curr, visited, parent, graph))
						return true;
				}
			}
		}
		parent.remove(v);
		return false;
	}

}
