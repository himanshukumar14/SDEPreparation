package Trees;

public class IdenticalBinaryTree {

	public boolean isSameTree(TreeNode A, TreeNode B) {
		if (A == null && B == null)
			return true;
		if (A == null || B == null)
			return false;
		return A.val == B.val && isSameTree(A.left, B.left) && isSameTree(A.right, B.right);
	}
}
