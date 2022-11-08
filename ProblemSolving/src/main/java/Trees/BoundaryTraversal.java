package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> boundaryTraversal(TreeNode root) {
		leftBoundaryTraversal(root);
		bottomBoundaryTraversal(root);
		rightBoundaryTraversal(root.right);
		return list;
	}

	List<Integer> list = new ArrayList<>();

	public void leftBoundaryTraversal(TreeNode root) {
		while (root.left != null || root.right != null) { // not including the leaf
			list.add(root.val);
			root = root.left != null ? root.left : root.right;
		}
	}

	public void rightBoundaryTraversal(TreeNode root) {
		Stack<Integer> s = new Stack<>();
		while (root.right != null || root.left != null) { // not including the leaf
			s.push(root.val);
			root = root.right != null ? root.right : root.left;
		}

		while (!s.isEmpty()) {
			list.add(s.pop());
		}
	}

	public void bottomBoundaryTraversal(TreeNode root) {
		if (root.left == null && root.right == null) {
			list.add(root.val);
			return;
		}
		if (root.left != null)
			bottomBoundaryTraversal(root.left);
		if (root.right != null)
			bottomBoundaryTraversal(root.right);
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
