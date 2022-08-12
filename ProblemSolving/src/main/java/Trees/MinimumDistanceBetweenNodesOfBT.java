package Trees;

public class MinimumDistanceBetweenNodesOfBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int ans = 0;

	public int findDist(TreeNode root, int a, int b) {
		if (root == null)
			return 0;

		int left = findDist(root.left, a, b);
		int right = findDist(root.right, a, b);

		if (root.val == a || root.val == b) {
			if (left != 0 || right != 0) {
				ans = Math.max(left, right);
				return 0;
			} else {
				return 1;
			}
		}

		if (left != 0 && right != 0) {
			ans = left + right;
			return 0;
		} else if (left != 0 || right != 0)
			return Math.max(left, right) + 1;
		return 0;
	}

	// ---------------------------------------------------------------------------------------

	public TreeNode LCA(TreeNode root, int n1, int n2) {
		if (root == null)
			return root;
		if (root.val == n1 || root.val == n2)
			return root;

		TreeNode left = LCA(root.left, n1, n2);
		TreeNode right = LCA(root.right, n1, n2);

		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}

	// Returns level of key k if it is present in
	// tree, otherwise returns -1
	public int findLevel(TreeNode root, int a, int level) {
		if (root == null)
			return -1;
		if (root.val == a)
			return level;
		int left = findLevel(root.left, a, level + 1);
		if (left == -1)
			return findLevel(root.right, a, level + 1);
		return left;
	}

	public int findDistance(TreeNode root, int a, int b) {
		TreeNode lca = LCA(root, a, b);

		int d1 = findLevel(lca, a, 0);
		int d2 = findLevel(lca, b, 0);

		return d1 + d2;
	}

}
