package Graph;

/**
 * 
 * Given a Graph, count number of triangles in it. The graph is can be directed
 * or undirected.
 * 
 * Example:
 * 
 * Input: digraph[V][V] = { {0, 0, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}, {0, 0, 1,
 * 0} }; Output: 2 Give adjacency matrix represents following directed graph.
 *
 */

/**
 * 
 * The idea is to use three nested loops to consider every triplet (i, j, k) and
 * check for the above condition (there is an edge from i to j, j to k and k to
 * i) However in an undirected graph, the triplet (i, j, k) can be permuted to
 * give six combination (See previous post for details). Hence we divide the
 * total count by 6 to get the actual number of triangles. In case of directed
 * graph, the number of permutation would be 3 (as order of nodes becomes
 * relevant). Hence in this case the total number of triangles will be obtained
 * by dividing total count by 3. For example consider the directed graph given
 * below
 *
 */
public class NumberOfTriangles {
	public static int V = 4;

	public static int countTriangle(int graph[][], boolean isDirected) {
		int count_Triangle = 0;

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				for (int k = 0; k < V; k++) {
					if (graph[i][j] == 1 && graph[j][k] == 1 && graph[k][i] == 1)
						count_Triangle++;
				}
			}
		}

		// If graph is directed , division
		// is done by 3 else division
		// by 6 is done
		if (isDirected == true) {
			count_Triangle /= 3;
		} else {
			count_Triangle /= 6;
		}
		return count_Triangle;
	}

	// Driver code
	public static void main(String args[]) {
		int graph[][] = { { 0, 1, 1, 0 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 0, 1, 1, 0 } };
		int digraph[][] = { { 0, 0, 1, 0 }, { 1, 0, 0, 1 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
		System.out.println("The Number of triangles " + "in undirected graph : " + countTriangle(graph, false));
		System.out.println("\n\nThe Number of triangles" + " in directed graph : " + countTriangle(digraph, true));

	}

}
