package Trees;

//Binary Search Solution
public class CountCompleteTreeNodes {

	/**
	 * 
	 * Given the root of a complete binary tree, return the number of the nodes in
	 * the tree.
	 * 
	 * According to Wikipedia, every level, except possibly the last, is completely
	 * filled in a complete binary tree, and all nodes in the last level are as far
	 * left as possible. It can have between 1 and 2h nodes inclusive at the last
	 * level h.
	 * 
	 * Design an algorithm that runs in less than O(n) time complexity.
	 */

	// Can give a binary search solution
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// binary search solution
//	public int countNodes(TreeNode root) {
//		if (root == null)
//			return 0;
//		if (root.left == null)
//			return 1;
//		int height = 0;
//		int nodesSum = 0;
//		TreeNode curr = root;
//		while (curr.left != null) {
//			nodesSum += (1 << height);
//			height++;
//			curr = curr.left;
//		}
//		return nodesSum + countLastLevel(root, height);
//	}
//
//	private int countLastLevel(TreeNode root, int height) {
//		if (height == 1)
//			if (root.right != null)
//				return 2;
//			else if (root.left != null)
//				return 1;
//			else
//				return 0;
//		TreeNode midNode = root.left;
//		int currHeight = 1;
//		while (currHeight < height) {
//			currHeight++;
//			midNode = midNode.right;
//		}
//		if (midNode == null)
//			return countLastLevel(root.left, height - 1);
//		else
//			return (1 << (height - 1)) + countLastLevel(root.right, height - 1);
//	}

	//-------------------------------------------------------------------

	//recursive solution
	public int countNodes(TreeNode root) {

		int leftDepth = leftDepth(root);
		int rightDepth = rightDepth(root);

		if (leftDepth == rightDepth)
			return (1 << leftDepth) - 1; //2^h - 1
		else
			return 1 + countNodes(root.left) + countNodes(root.right);

	}

	private int rightDepth(TreeNode root) {
		// TODO Auto-generated method stub
		int dep = 0;
		while (root != null) {
			root = root.right;
			dep++;
		}
		return dep;
	}

	private int leftDepth(TreeNode root) {
		int dep = 0;
		while (root != null) {
			root = root.left;
			dep++;
		}
		return dep;
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
