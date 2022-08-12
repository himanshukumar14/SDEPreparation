package BST;

public class ValidateBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isBST = true;

	public static int isValidBST(TreeNode A) {
		max_min(A);
		return isBST ? 1 : 0;
	}

	public static int[] max_min(TreeNode root) {
		if (root == null) {
			return new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE };
		}

		int[] left = max_min(root.left);
		int[] right = max_min(root.right);

		if (root.val <= left[0] || root.val >= right[1]) {
			isBST = false;
		}
		return new int[] { Math.max(root.val, right[0]), Math.min(root.val, left[1]) };
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
