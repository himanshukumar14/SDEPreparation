package BST;

public class MinInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minValue(TreeNode node) {
		if (node == null)
			return -1;
		while (node.left != null) {
			node = node.left;
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
