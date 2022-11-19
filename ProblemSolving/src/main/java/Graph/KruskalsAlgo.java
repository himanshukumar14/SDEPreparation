package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * Minimum Spanning Tree is tree or a subgraph that has minimum weight and
 * minimum edges
 * 
 * A minimum spanning tree (MST) or minimum weight spanning tree for a weighted,
 * connected, undirected graph is a spanning tree with a weight less than or
 * equal to the weight of every other spanning tree. The weight of a spanning
 * tree is the sum of weights given to each edge of the spanning tree.
 * 
 * How many edges does a minimum spanning tree has? A minimum spanning tree has
 * (V  1) edges where V is the number of vertices in the given graph.
 * 
 * Applications: Network design. telephone, electrical, hydraulic, TV cable,
 * computer, road
 *
 */

public class KruskalsAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void KruskalMST(int[][] edges, int n) {
		int m = edges.length;
		List<int[]> mst = new ArrayList<>(); 
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[2] - b[2];
			}
		});
		
		DisjointSetUnion[] set = new DisjointSetUnion[n];
		for (int i = 0; i < n; ++i)
			set[i] = new DisjointSetUnion(i, 0);

		for(int i = 0; i < m; ++i) {
			int x = DisjointSetUnion.find(set, edges[i][0]);
			int y = DisjointSetUnion.find(set, edges[i][1]);
			if (x != y) {
				DisjointSetUnion.union(set, x, y);
				mst.add(edges[i]);
			}
		}

		// MST weight
		int minimumCost = 0;
		for (int i = 0; i < mst.size(); ++i) {
			minimumCost += mst.get(i)[2];
		}
		System.out.println("Minimum Cost Spanning Tree " + minimumCost);
	}

}
