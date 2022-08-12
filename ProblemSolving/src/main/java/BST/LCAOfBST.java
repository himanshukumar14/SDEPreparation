package BST;

public class LCAOfBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int lca(TreeNode root, int B, int C) {
		if (root == null)
			return -1;

		if (root.val < B && root.val < C)
			return lca(root.right, B, C);
		else if (root.val > B && root.val > C)
			return lca(root.left, B, C);
		else
			return root.val;
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
