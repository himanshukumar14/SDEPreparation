package Trees;

import java.util.ArrayList;
import java.util.List;

public class LCAOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int lca(TreeNode A, int B, int C) {
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		if (findLCA(A, B, l1) && findLCA(A, C, l2)) {
			int i = 0;
			for (i = 0; i < l1.size() && i < l2.size(); i++) {
				if (!l1.get(i).equals(l2.get(i)))
					break;
			}
			return l1.get(i - 1);
		}
		return -1;
	}

	public boolean findLCA(TreeNode root, int target, List<Integer> l) {
		if (root == null)
			return false;
		l.add(root.val);
		if (root.val == target)
			return true;
		if (root.left != null && findLCA(root.left, target, l))
			return true;
		if (root.right != null && findLCA(root.right, target, l))
			return true;
		l.remove(l.size() - 1);
		return false;
	}

	//----------------------------------------------------------------------------------
	public TreeNode lca2(TreeNode root, int a, int b) {
		if (root == null)
			return null;
		if (root.val == a || root.val == b) {
			return root;
		}
		TreeNode left = lca2(root.left, a, b);
		TreeNode right = lca2(root.right, a, b);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}

}
