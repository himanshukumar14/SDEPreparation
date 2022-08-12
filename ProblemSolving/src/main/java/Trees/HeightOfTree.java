package Trees;

public class HeightOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int height(TreeNode root) {
		if (root == null)
			return 0;
		int l = height(root.left);
		int r = height(root.right);
		return Math.max(l, r) + 1;
	}

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
	}
}
