package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 * 
 * Note: The test cases are generated in the following format (use the following
 * format to use See Expected Output option): First integer N is the number of
 * nodes. Then, N intgers follow denoting the label (or hash) of the N nodes.
 * Then, N2 integers following denoting the adjacency matrix of a graph, where
 * Adj[i][j] = 1 denotes presence of an undirected edge between the ith and jth
 * node, O otherwise.
 *
 */

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		return dfs(node);
	}

	public UndirectedGraphNode dfs(UndirectedGraphNode v) {
		Stack<UndirectedGraphNode> s1 = new Stack<>();
		Map<UndirectedGraphNode, UndirectedGraphNode> s2 = new HashMap<>();
		s1.push(v);
		s2.put(v, new UndirectedGraphNode(v.label));
		while (!s1.isEmpty()) {
			UndirectedGraphNode graphNode = s1.pop();
			UndirectedGraphNode cloneGraph = s2.get(graphNode);

			List<UndirectedGraphNode> temp1 = graphNode.neighbors;
			for (UndirectedGraphNode adj : temp1) {
				UndirectedGraphNode node = s2.get(adj);
				if (node == null) {
					s1.push(adj);
					node = new UndirectedGraphNode(adj.label);
					s2.put(adj, node);
				}
				cloneGraph.neighbors.add(node);
			}
		}
		return s2.get(v);
	}

}
