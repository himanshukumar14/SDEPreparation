package Graph;

public class DisjointSetUnion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int parent;
	int rank;

	DisjointSetUnion(int parent, int rank) {
		this.parent = parent;
		this.rank = rank;
	}

	// union by rank - improves time to O(logn) from O(n)
	// attach smaller rank tree under a larger rank tree
	public static void union(DisjointSetUnion[] set, int x, int y) {
		int xparent = find(set, x);
		int yparent = find(set, y);
		if (xparent == yparent)
			return;
		if (set[xparent].rank > set[yparent].rank) {
			set[yparent].parent = xparent;
			set[xparent].rank += set[yparent].rank;
		} else {
			set[xparent].parent = yparent;
			set[yparent].rank += set[xparent].rank;
		}
	}

	// Path compression - improves time to O(logn)
	/**
	 * The idea is to flatten the tree when find() is called. When find() is called
	 * for an element x, root of the tree is returned. The find() operation
	 * traverses up from x to find root. The idea of path compression is to make the
	 * found root as parent of x so that we don�t have to traverse all intermediate
	 * nodes again. If x is root of a subtree, then path (to root) from all nodes
	 * under x also compresses.
	 */
	public static int find(DisjointSetUnion[] set, int x) {
		if (set[x].parent == x)
			return x;
		return set[x].parent = find(set, set[x].parent);
	}

}
