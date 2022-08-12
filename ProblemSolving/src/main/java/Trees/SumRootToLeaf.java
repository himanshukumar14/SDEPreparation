package Trees;

public class SumRootToLeaf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int sumNumbers(TreeNode root) {
		return recur(root, 0);
	}

	public int recur(TreeNode root, int sum) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return sum * 10 + root.val;
		int left = recur(root.left, sum * 10 + root.val);
		int right = recur(root.right, sum * 10 + root.val);
		return left + right;
	}

}
