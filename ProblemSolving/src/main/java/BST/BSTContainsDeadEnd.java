package BST;

import java.util.HashSet;
import java.util.Set;

public class BSTContainsDeadEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void traverseNodes(TreeNode root, Set<Integer> leafStore, Set<Integer> nodeStore) {
		if (root == null)
			return;
		nodeStore.add(root.val);

		if (root.left == null && root.right == null) {
			leafStore.add(root.val);
			return;
		}

		traverseNodes(root.left, leafStore, nodeStore);
		traverseNodes(root.right, leafStore, nodeStore);
	}

	public static boolean isDeadEnd(TreeNode root) {
		if (root == null)
			return false;

		Set<Integer> leafStore = new HashSet<>();
		Set<Integer> nodeStore = new HashSet<>();
		traverseNodes(root, leafStore, nodeStore);

		for (int leaf : leafStore) {
			if (nodeStore.contains(leaf + 1) && nodeStore.contains(leaf - 1))
				return true;
		}
		return false;
	}

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		TreeNode(int val) {
			this.left = null;
			this.right = null;
			this.val = val;
		}
	}

}
