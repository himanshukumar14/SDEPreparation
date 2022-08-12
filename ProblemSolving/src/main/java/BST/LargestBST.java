package BST;

public class LargestBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(6);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(8);
		root.right.right = new TreeNode(3);
		root.right.left = new TreeNode(9);
		root.right.left.left = new TreeNode(8);
		root.right.left.right = new TreeNode(2);
		System.out.println(largestBST(root));
	}

	public static int bstSize;

	public static int largestBST(TreeNode root) {
		checkBST(root);
		return bstSize;
	}

	public static int[] checkBST(TreeNode root) {
		if (root == null) // max-min
			return new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 0 };

		int[] left = checkBST(root.left);
		int[] right = checkBST(root.right);
		if (root.val > left[0] && root.val < right[1]) {
			bstSize = Math.max(bstSize, left[2] + right[2] + 1);
		}
		return new int[] { Math.max(root.val, right[0]), Math.min(root.val, left[1]), left[2] + right[2] + 1 };
	}

	static class TreeNode {
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
