package BST;

/**
 * 
 * Given a Binary Tree where each node has the following structure, write a
 * function to populate the next pointer for all nodes. The next pointer for
 * every node should be set to point to inorder successor.
 *
 */

public class PopulateInorderSuccessor {

	public static void main(String[] args) {
		/*
		 * Constructed binary tree is 10 / \ 8 12 / 3
		 */
		TreeNode tree = new TreeNode(10);
		tree.left = new TreeNode(8);
		tree.right = new TreeNode(12);
		tree.left.left = new TreeNode(3);

		populateNext(tree);
	}

	public static TreeNode nextElement = new TreeNode(-1);

	public static void populateNext(TreeNode root) {
		if (root == null)
			return;
		populateNext(root.right);
		root.next = nextElement;
		nextElement = root;
		populateNext(root.left);
	}

	static class TreeNode {
		int val;
		TreeNode left, right, next;

		public TreeNode(int val) {
			this.val = val;
		}
	}

}
