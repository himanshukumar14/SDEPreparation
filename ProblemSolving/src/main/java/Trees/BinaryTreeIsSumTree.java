package Trees;

/*Write a function that returns true if the given Binary Tree is SumTree else false. 
A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree. 
An empty tree is SumTree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

Following is an example of SumTree.

          26
        /   \
      10     3
    /    \     \
  4      6      3
*/

public class BinaryTreeIsSumTree {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(26);
		tree.left = new TreeNode(10);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(6);
		tree.right.right = new TreeNode(3);
		isSumTree(tree);
		if (isSumTree)
			System.out.println("The given tree is a sum tree");
		else
			System.out.println("The given tree is not a sum tree");
	}

	public static boolean isSumTree = true;

	public static int isSumTree(TreeNode root) {
		if (root == null)
			return 0;
		int left = isSumTree(root.left);
		int right = isSumTree(root.right);

		int sum = left + right;
		if (sum != 0 && sum != root.val) {
			isSumTree = false;
		}
		return sum + root.val;
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
