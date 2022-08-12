package BST;

public class DeleteFromBST {

	TreeNode root;
	// This method mainly calls deleteRec()
	void deleteKey(int key) {
		root = deleteRec(root, key);
	}

	/*
	 * A recursive function to delete an existing key in BST
	 */
	public TreeNode deleteRec(TreeNode root, int key) {
		/* Base Case: If the tree is empty */
		if (root == null)
			return root;

		/* Otherwise, recur down the tree */
		if (key < root.val)
			root.left = deleteRec(root.left, key);
		else if (key > root.val)
			root.right = deleteRec(root.right, key);

		// if key is same as root's
		// key, then This is the
		// node to be deleted
		else {
			// node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// node with two children: Get the inorder
			// successor (smallest in the right subtree)
			root.val = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteRec(root.right, root.val);
		}

		return root;
	}

	int minValue(TreeNode root) {
		int minv = root.val;
		while (root.left != null) {
			minv = root.left.val;
			root = root.left;
		}
		return minv;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

}
