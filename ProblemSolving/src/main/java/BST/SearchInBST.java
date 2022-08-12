package BST;

public class SearchInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode search(TreeNode root, int key) {
		if (root == null)
			return root;

		if (root.val == key)
			return root;

		if (root.val < key)
			return search(root.right, key);
		else
			return search(root.left, key);
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
