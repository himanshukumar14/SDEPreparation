package Trees;

/**
 * 
 * Given the root of a binary tree, check whether it is a mirror of itself
 * (i.e., symmetric around its center).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,2,3,4,4,3] Output: true
 *
 */

public class SymmetricBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean symmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(TreeNode A, TreeNode B) {
		if (A == null && B == null)
			return true;
		if (A == null || B == null)
			return false;
		return A.val == B.val && isSymmetric(A.left, B.right) && isSymmetric(A.right, B.left);
	}

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
	}

}
