package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<Integer> leftView(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		List<Integer> l = new ArrayList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; ++i) {
				TreeNode temp = q.poll();
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
				if (i == 0)
					l.add(temp.val);
			}
		}
		return l;
	}

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
	}

}
