package BST;

public class SortedArrayToBalancedBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedArrayToBST(int[] A) {
		int n = A.length;
		return buildTree(A, 0, n - 1);
	}

	public TreeNode buildTree(int[] A, int l, int r) {
		if (l > r)
			return null;
		int mid = (l + r) / 2;
		TreeNode root = new TreeNode(A[mid]);
		root.left = buildTree(A, l, mid - 1);
		root.right = buildTree(A, mid + 1, r);
		return root;
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
