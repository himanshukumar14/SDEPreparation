package BST;

public class MinimumAbsoluteDifferenceInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int prev = -1;
	int curr = prev;
	int min = Integer.MAX_VALUE;

	public int minDiffInBST(TreeNode root) {
		if (root == null)
			return 0;
		minDiffInBST(root.left);
		prev = curr;
		curr = root.val;
		if (prev != -1)
			min = Math.min(min, (curr - prev));
		minDiffInBST(root.right);
		return min;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}
