package Trees;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean balanced = true;

	public static int isBalanced(TreeNode root) {
		if (root == null)
			return 0;
		int lh = isBalanced(root.left);
		int rh = isBalanced(root.right);
		if (Math.abs(lh - rh) > 1)
			balanced = false;
		return Math.max(lh, rh) + 1;
	}

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
	}
}
