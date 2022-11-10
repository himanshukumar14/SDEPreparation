package Trees;

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode flattenBinaryTree(TreeNode root) {
		if (root == null)
			return null;

		TreeNode left = flattenBinaryTree(root.left);
		TreeNode right = flattenBinaryTree(root.right);
		root.left = null;
		if (left != null) {
			root.right = left;
			while (root.right != null) {
				root = root.right;
			}	
		}
		root.right = right;
		return root;
	}

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
	}

}
