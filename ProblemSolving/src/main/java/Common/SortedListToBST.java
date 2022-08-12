import java.util.ArrayList;
import java.util.List;

public class SortedListToBST {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		arrange(list);
	}

	public static void arrange(List<Integer> list) {
		int l = 0;
		int r = list.size() - 1;
		TreeNode ans = buildTree(list, l, r);
		printInOrder(ans);
	}

	public static TreeNode buildTree(List<Integer> list, int l, int r) {
		if (l > r)
			return null;
		int mid = (l + r) / 2;
		TreeNode node = new TreeNode(list.get(mid));
		node.left = buildTree(list, l, mid - 1);
		node.right = buildTree(list, mid + 1, r);
		return node;
	}

	public static void printInOrder(TreeNode tree) {
		if (tree == null)
			return;
		printInOrder(tree.left);
		System.out.println(tree.val);
		printInOrder(tree.right);

	}
}

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;

	TreeNode(int val) {
		this.val = val;
	}
}