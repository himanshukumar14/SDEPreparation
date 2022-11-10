package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * Given the root of a binary tree, return the maximum width of the given tree.
 * 
 * The maximum width of a tree is the maximum width among all levels.
 * 
 * The width of one level is defined as the length between the end-nodes (the
 * leftmost and rightmost non-null nodes), where the null nodes between the
 * end-nodes that would be present in a complete binary tree extending down to
 * that level are also counted into the length calculation.
 * 
 * It is guaranteed that the answer will in the range of a 32-bit signed
 * integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,3,2,5,3,null,9] Output: 4 Explanation: The maximum width
 * exists in the third level with length 4 (5,3,null,9). Example 2:
 * 
 * 
 * Input: root = [1,3,2,5,null,null,9,6,null,7] Output: 7 Explanation: The
 * maximum width exists in the fourth level with length 7
 * (6,null,null,null,null,null,7). Example 3:
 * 
 * 
 * Input: root = [1,3,2,5] Output: 2 Explanation: The maximum width exists in
 * the second level with length 2 (3,2).
 *
 */

public class MaximumWidthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int widthOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Map<TreeNode, Integer> treemap = new HashMap<>();

		queue.add(root);
		treemap.put(root, 1);
		int maxWidth = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			int start = 0;
			int end = 0;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (i == 0)
					start = treemap.get(node);
				if (i == size - 1)
					end = treemap.get(node);

				if (node.left != null) {
					treemap.put(node.left, treemap.get(node) * 2);
					queue.add(node.left);
				}
				if (node.right != null) {
					treemap.put(node.right, treemap.get(node) * 2 + 1);
					queue.add(node.right);
				}
			}
			maxWidth = Math.max(end - start + 1, maxWidth);
		}
		return maxWidth;
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
