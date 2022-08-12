package BST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreeToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(30);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(20);
		root.right.right = new TreeNode(5);
		TreeNode tree = BinaryTreeToBSTUtil(root);
		List<Integer> l = inOrderUtil(tree);
		for(int x : l) {
			System.out.println(x);
		}
	}

	public static TreeNode BinaryTreeToBSTUtil(TreeNode root) {
		List<Integer> inOrder = inOrderUtil(root);
		Collections.sort(inOrder);
		return sortedArrayToBST(inOrder, 0, inOrder.size() - 1);
	}

	public static List<Integer> inOrderUtil(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> ans = new ArrayList<>();

		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.add(root);
				root = root.left;
			} else {
				TreeNode temp = stack.pop();
				ans.add(temp.val);
				root = temp.right;
			}
		}
		return ans;
	}

	public static TreeNode sortedArrayToBST(List<Integer> inorder, int left, int right) {
		if (left > right)
			return null;
		int mid = (left + right) / 2;
		TreeNode tree = new TreeNode(inorder.get(mid));
		tree.left = sortedArrayToBST(inorder, left, mid - 1);
		tree.right = sortedArrayToBST(inorder, mid + 1, right);
		return tree;
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
