package Graph;

/**
 * 
 * In this problem, a tree is an undirected graph that is connected and has no
 * cycles.
 * 
 * You are given a graph that started as a tree with n nodes labeled from 1 to
 * n, with one additional edge added. The added edge has two different vertices
 * chosen from 1 to n, and was not an edge that already existed. The graph is
 * represented as an array edges of length n where edges[i] = [ai, bi] indicates
 * that there is an edge between nodes ai and bi in the graph.
 * 
 * Return an edge that can be removed so that the resulting graph is a tree of n
 * nodes. If there are multiple answers, return the answer that occurs last in
 * the input.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: edges = [[1,2],[1,3],[2,3]] Output: [2,3] Example 2:
 * 
 * 
 * Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]] Output: [1,4]
 *
 */

public class RedundantConnection {

	public static void main(String[] args) {

	}

	public int[] findRedundantConnection(int[][] edges) {
		int[] ans = new int[2];
		customSet[] set = new customSet[edges.length + 1];
		for (int i = 1; i < edges.length + 1; ++i) {
			set[i] = new customSet();
			set[i].parent = i;
			set[i].rank = 1;
		}
		for (int i = 0; i < edges.length; ++i) {
			int x = find(set, edges[i][0]);
			int y = find(set, edges[i][1]);

			if (x != y)
				union(set, x, y);
			else {
				ans[0] = edges[i][0];
				ans[1] = edges[i][1];
				return ans;
			}
		}
		return ans;
	}

	class customSet {
		int parent;
		int rank;
	}

	public void union(customSet[] set, int x, int y) {
		int xroot = find(set, x);
		int yroot = find(set, y);

		if (xroot == yroot)
			return;
		if (set[xroot].rank < set[yroot].rank) {
			set[xroot].parent = yroot;
			set[yroot].rank += set[xroot].rank;
		} else {
			set[yroot].parent = xroot;
			set[xroot].rank += set[yroot].rank;
		}
	}

	public int find(customSet[] set, int i) {
		if (set[i].parent == i)
			return i;
		return find(set, set[i].parent);
	}

}
