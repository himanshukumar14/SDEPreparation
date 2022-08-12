package BST;

public class KthSmallestInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree = new TreeNode(50);
		tree.left = new TreeNode(30);
		tree.right = new TreeNode(70);
		tree.left.left = new TreeNode(20);
		tree.left.right = new TreeNode(40);
		tree.right.left = new TreeNode(60);
		tree.right.right = new TreeNode(80);

		kthSmallestUtil(tree, 2);
		System.out.println(kthSmallest);
	}

	public static int kthSmallest;
	public static int count = 0;

	public static void kthSmallestUtil(TreeNode node, int k) {
		if (node == null)
			return;
		if (count > k)
			return;
		kthSmallestUtil(node.left, k);
		count++;

		if (count == k) {
			kthSmallest = node.val;
			return;
		}
		kthSmallestUtil(node.right, k);
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
