package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TraversalOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println(morrisPreorderTraversal(root));
	}

	// Root Left Right - Iterative
	public static List<Integer> preOrder(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		List<Integer> l = new ArrayList<>();

		while (!s.isEmpty() || root != null) {
			if (root != null) {
				l.add(root.val);
				s.push(root);
				root = root.left;
			} else {
				TreeNode temp = s.pop();
				root = temp.right;
			}
		}
		return l;
	}

	// Root Left Right - Recursive
	public static void preOrder2(TreeNode root, List<Integer> l) {
		l.add(root.val);
		preOrder2(root.left, l);
		preOrder2(root.right, l);
	}

	// Left Root Right - Iterative
	public static List<Integer> inOrder(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		List<Integer> l = new ArrayList<>();

		while (!s.isEmpty() || root != null) {
			if (root != null) {
				s.push(root);
				root = root.left;
			} else {
				TreeNode temp = s.pop();
				l.add(temp.val);
				root = temp.right;
			}
		}
		return l;
	}

	// Left Root Right - Recursive
	public static void inOrder2(TreeNode root, List<Integer> l) {
		inOrder2(root.left, l);
		l.add(root.val);
		inOrder2(root.right, l);
	}

	// Left Right Root
	public static List<Integer> postOrder(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		List<Integer> l = new ArrayList<>();

		while (!s.isEmpty() || root != null) {
			if (root != null) {
				l.add(root.val);
				s.push(root);
				root = root.right;
			} else {
				TreeNode temp = s.pop();
				root = temp.left;
			}
		}
		Collections.reverse(l);
		return l;
	}

	// Left Right Root - Recursive
	public static void postOrder2(TreeNode root, List<Integer> l) {
		inOrder2(root.left, l);
		inOrder2(root.right, l);
		l.add(root.val);
	}

	// BFS
	public static List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		List<List<Integer>> l = new ArrayList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> t = new ArrayList<>();
			for (int i = 0; i < size; ++i) {
				TreeNode temp = q.poll();
				t.add(temp.val);
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
			l.add(t);
		}
		return l;
	}

	public static List<List<Integer>> reverseLevelOrder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		List<List<Integer>> l = new ArrayList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> t = new ArrayList<>();
			for (int i = 0; i < size; ++i) {
				TreeNode curr = q.poll();
				t.add(curr.val);
				if (curr.left != null)
					q.add(curr.left);
				if (curr.right != null)
					q.add(curr.right);
			}
			l.add(t);
		}
		Collections.reverse(l);
		return l;
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode A) {
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		List<List<Integer>> ans = new ArrayList<>();
		s1.push(A);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			if (!s1.isEmpty()) {
				int size1 = s1.size();
				ArrayList<Integer> l1 = new ArrayList<>();
				for (int i = 0; i < size1; ++i) {
					TreeNode temp = s1.pop();
					l1.add(temp.val);
					if (temp.left != null)
						s2.push(temp.left);
					if (temp.right != null)
						s2.push(temp.right);
				}
				ans.add(l1);
			} else if (!s2.isEmpty()) {
				int size2 = s2.size();
				ArrayList<Integer> l2 = new ArrayList<>();
				for (int i = 0; i < size2; ++i) {
					TreeNode temp = s2.pop();
					l2.add(temp.val);
					if (temp.right != null)
						s1.push(temp.right);
					if (temp.left != null)
						s1.push(temp.left);
				}
				ans.add(l2);
			}
		}
		return ans;
	}

	public static List<Integer> morrisInorderTraversal(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		
		TreeNode current = root;
		List<Integer> ans = new ArrayList<>();
		while (current != null) {
			if (current.left == null) {
				ans.add(current.val);
				current = current.right;
			} else {
				TreeNode temp = current.left;
				while (temp.right != null && temp.right != current) {
					temp = temp.right;
				}

				if (temp.right == null) {
					temp.right = current;
					current = current.left;
				} else {
					temp.right = null;
					ans.add(current.val);
					current = current.right;
				}
			}
		}
		return ans;
	}

	public static List<Integer> morrisPreorderTraversal(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		;
		TreeNode current = root;
		List<Integer> ans = new ArrayList<>();
		while (current != null) {
			if (current.left == null) {
				ans.add(current.val);
				current = current.right;
			} else {
				TreeNode temp = current.left;
				while (temp.right != null && temp.right != current) {
					temp = temp.right;
				}

				if (temp.right == null) {
					temp.right = current;
					ans.add(current.val);
					current = current.left;
				} else {
					temp.right = null;
					current = current.right;
				}
			}
		}
		return ans;
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
