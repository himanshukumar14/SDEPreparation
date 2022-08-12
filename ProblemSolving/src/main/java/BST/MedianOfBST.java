package BST;

public class MedianOfBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		System.out.println(getMedian(root));
	}

	public static int getMedian(TreeNode root) {
		int treeSize = getTreeSize(root);
		// System.out.println(treeSize);
		getKthElement(root, treeSize / 2);
		if (treeSize % 2 == 0)
			return (kthElement + kthElementNext) / 2;
		else
			return (kthElementNext);
	}

	public static int count = 0;
	public static int kthElement = 0;
	public static int kthElementNext = 0;

	public static void getKthElement(TreeNode root, int k) {
		if (root == null)
			return;
		if (count > k + 1)
			return;
		getKthElement(root.left, k);
		count++;

		if (count == k) {
			kthElement = root.val;
		}
		if (count == k + 1) {
			kthElementNext = root.val;
			return;
		}
		getKthElement(root.right, k);
	}

	public static int getTreeSize(TreeNode root) {
		if (root == null)
			return 0;
		int left = getTreeSize(root.left);
		int right = getTreeSize(root.right);
		return left + right + 1;
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
