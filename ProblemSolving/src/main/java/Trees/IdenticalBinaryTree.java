package Trees;

public class IdenticalBinaryTree {

	public boolean isSameTree(TreeNode A, TreeNode B) {
		if (A == null && B == null)
			return true;
		if (A == null || B == null)
			return false;
		boolean left = isSameTree(A.left, B.left);
		boolean right = isSameTree(A.right, B.right);
		return A.val == B.val && left && right;
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
