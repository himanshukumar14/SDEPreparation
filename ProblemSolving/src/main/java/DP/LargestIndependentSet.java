package DP;

// This is house robbery 3
public class LargestIndependentSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//house robber3 question
	public static int liss(TreeNode root) {
		if (root == null)
			return 0;
		if (root.liss != 0)
			return root.liss;
		if (root.left == null && root.right == null)
			return root.liss = 1;

		int liss_excl = liss(root.left) + liss(root.right);
		
		int liss_incl = 1;
		if (root.left != null) {
			liss_incl += (liss(root.left.left) + liss(root.left.right));
		}
		if (root.right != null) {
			liss_incl += (liss(root.right.left) + liss(root.right.right));
		}
		return root.liss = Math.max(liss_excl, liss_incl);
	}
	
	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
		int liss;
	}

}
