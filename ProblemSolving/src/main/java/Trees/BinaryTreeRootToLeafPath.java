package Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a binary tree, return all root-to-leaf paths. Note: A leaf is a node
 * with no children. Example: Input: 1 / \ 2 3 \ 5 Output: ["1->2->5", "1->3"]
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 */

public class BinaryTreeRootToLeafPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	List<String> rootToLeafPath = new ArrayList<>();

	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null)
			return rootToLeafPath;
		recur(root, "");
		return rootToLeafPath;
	}

	public void recur(TreeNode root, String path) {
		if (root.left == null && root.right == null) {
			rootToLeafPath.add(path + root.val);
			return;
		}
		if (root.left != null)
			recur(root.left, path + root.val + "->");
		if (root.right != null)
			recur(root.right, path + root.val + "->");
	}

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
	}
}
