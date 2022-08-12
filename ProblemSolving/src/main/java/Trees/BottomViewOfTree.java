package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BottomViewOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree1 = new TreeNode(20);
		tree1.left = new TreeNode(8);
		tree1.right = new TreeNode(22);
		tree1.left.left = new TreeNode(5);
		tree1.right.right = new TreeNode(25);
		tree1.left.right = new TreeNode(3);
		tree1.left.right.left = new TreeNode(10);
		tree1.left.right.right = new TreeNode(14);

		List<Integer> ans = bottomView(tree1);
		for (int x : ans) {
			System.out.println(x);
		}
	}

	public static List<Integer> bottomView(TreeNode A) {
		List<Integer> ans = new ArrayList<>();
		if (A == null)
			return ans;

		List<Location> loc = new ArrayList<>();
		preorder(A, 0, 0, loc);
		Collections.sort(loc);

		Location prev = loc.get(0);
		for (Location l : loc) {
			if (l.x != prev.x)
				ans.add(prev.val);
			prev = l;
		}
		ans.add(prev.val);
		return ans;
	}

	public static void preorder(TreeNode root, int b, int h, List<Location> map) {
		if (root != null) {
			map.add(new Location(h, b, root.val));
			preorder(root.left, b - 1, h + 1, map);
			preorder(root.right, b + 1, h + 1, map);
		}
	}

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	static class Location implements Comparable<Location> {
		int val;
		int x;
		int y;

		Location(int y, int x, int val) {
			this.val = val;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Location loc) {
			if (this.x != loc.x) {
				return Integer.compare(this.x, loc.x);
			} else {
				return Integer.compare(this.y, loc.y);
			}
		}
	}

}
