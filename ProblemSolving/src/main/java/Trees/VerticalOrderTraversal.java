package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerticalOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> verticalOrderTraversal(TreeNode A) {
		List<List<Integer>> ans = new ArrayList<>();
		if (A == null) {
			return ans;
		}
		List<Location> loc = new ArrayList<>();
		preorder(A, 0, 0, loc);
		Collections.sort(loc);

		ans.add(new ArrayList<Integer>());
		int prev = loc.get(0).x;

		for (Location l : loc) {
			if (l.x != prev)
				ans.add(new ArrayList<Integer>());
			prev = l.x;
			ans.get(ans.size() - 1).add(l.val);
		}
		return ans;
	}

	public void preorder(TreeNode root, int b, int h, List<Location> map) {
		if (root != null) {
			map.add(new Location(h, b, root.val));
			preorder(root.left, b - 1, h + 1, map);
			preorder(root.right, b + 1, h + 1, map);
		}
	}
	
	class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
	}
}

class Location implements Comparable<Location> {
	public int val;
	public int y;
	public int x;

	public Location(int h, int b, int v) {
		y = h;
		x = b;
		val = v;
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
