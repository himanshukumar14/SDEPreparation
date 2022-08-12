package BST;

public class KthLargestInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree = new TreeNode(50);
		tree.left = new TreeNode(30);
		tree.right = new TreeNode(70);
		tree.left.left = new TreeNode(20);
		tree.left.right = new TreeNode(40);
		tree.right.left = new TreeNode(60);
		tree.right.right = new TreeNode(80);

		kthLargestUtil(tree, 2);
		System.out.println(kthLargest);
	}

	public static int kthLargest;
	public static int count = 0;

	public static void kthLargestUtil(TreeNode node, int k) {
		if (node == null)
			return;
		if (count > k)
			return;
		kthLargestUtil(node.right, k);
		count++;
		if (count == k) {
			kthLargest = node.val;
			return;
		}
		kthLargestUtil(node.left, k);
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
