package BST;

public class DistanceBetweenNodesOfBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(TreeNode A, int B, int C) {
		return findlcaandDistance(A, B, C);
	}

	public int findlcaandDistance(TreeNode root, int B, int C) {
		if (root == null) {
			return 0;
		}
		if (root.val < B && root.val < C)
			return findlcaandDistance(root.right, B, C);
		else if (root.val > B && root.val > C)
			return findlcaandDistance(root.left, B, C);
		else
			return findDis(root, B) + findDis(root, C);
	}

	public int findDis(TreeNode root, int A) {
		if (root == null) {
			return 0;
		}

		if (root.val < A)
			return findDis(root.right, A) + 1;
		else if (root.val > A)
			return findDis(root.left, A) + 1;
		else
			return 0;
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
