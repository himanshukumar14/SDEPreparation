package BST;

public class MaxInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxValue(TreeNode node) {
		if (node == null)
			return -1;
		while (node.right != null) {
			node = node.right;
		}
		return node.val;
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
