package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class qItem {
		TreeNode node;
		int depth;

		public qItem(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		Queue<qItem> q = new LinkedList<>();
		q.add(new qItem(root, 1));
		while (!q.isEmpty()) {
			qItem temp = q.poll();
			TreeNode node = temp.node;
			int depth = temp.depth;
			if (node.left == null && node.right == null)
				return depth;

			if (node.left != null)
				q.add(new qItem(node.left, depth + 1));
			if (node.right != null)
				q.add(new qItem(node.right, depth + 1));
		}
		return 0;
	}
	
	class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
	}

}
