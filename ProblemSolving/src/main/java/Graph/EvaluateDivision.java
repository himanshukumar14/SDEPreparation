package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * You are given an array of variable pairs equations and an array of real
 * numbers values, where equations[i] = [Ai, Bi] and values[i] represent the
 * equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a
 * single variable.
 * 
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the
 * jth query where you must find the answer for Cj / Dj = ?.
 * 
 * Return the answers to all queries. If a single answer cannot be determined,
 * return -1.0.
 * 
 * Note: The input is always valid. You may assume that evaluating the queries
 * will not result in division by zero and that there is no contradiction.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries =
 * [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]] Output:
 * [6.00000,0.50000,-1.00000,1.00000,-1.00000] Explanation: Given: a / b = 2.0,
 * b / c = 3.0 queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x =
 * ? return: [6.0, 0.5, -1.0, 1.0, -1.0 ] Example 2:
 * 
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0],
 * queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]] Output:
 * [3.75000,0.40000,5.00000,0.20000] Example 3:
 * 
 * Input: equations = [["a","b"]], values = [0.5], queries =
 * [["a","b"],["b","a"],["a","c"],["x","y"]] Output:
 * [0.50000,2.00000,-1.00000,-1.00000]
 *
 */

public class EvaluateDivision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		int n = equations.size();
		double[] ans = new double[queries.size()];
		Map<String, Map<String, Double>> graph = new HashMap<>();
		Map<String, Double> temp = null;
		for (int i = 0; i < n; ++i) {
			// a/b
			temp = graph.getOrDefault(equations.get(i).get(0), new HashMap<>());
			temp.put(equations.get(i).get(1), values[i]);
			graph.put(equations.get(i).get(0), temp);

			// b/a
			temp = graph.getOrDefault(equations.get(i).get(1), new HashMap<>());
			temp.put(equations.get(i).get(0), 1 / values[i]);
			graph.put(equations.get(i).get(1), temp);

			// a/a
			temp = graph.getOrDefault(equations.get(i).get(0), new HashMap<>());
			temp.put(equations.get(i).get(0), 1.0);
			graph.put(equations.get(i).get(0), temp);

			// b/b
			temp = graph.getOrDefault(equations.get(i).get(1), new HashMap<>());
			temp.put(equations.get(i).get(1), 1.0);
			graph.put(equations.get(i).get(1), temp);
		}

		for (int i = 0; i < queries.size(); ++i) {
			String x = queries.get(i).get(0);
			String y = queries.get(i).get(1);
			ans[i] = dfs(x, y, graph, new HashSet<>());
		}

		return ans;
	}

	public double dfs(String start, String end, Map<String, Map<String, Double>> graph, Set<String> visited) {
		if (!graph.containsKey(start))
			return -1.0;
		if (start.equals(end))
			return graph.get(start).get(end);

		visited.add(start);
		Map<String, Double> temp = graph.get(start);
		if (temp != null) {
			Iterator<String> it = temp.keySet().iterator();
			while (it.hasNext()) {
				String node = it.next();
				if (!visited.contains(node)) {
					double path = dfs(node, end, graph, visited);
					if (path != -1.0)
						return path * temp.get(node);
				}
			}
		}
		return -1.0;
	}

}
