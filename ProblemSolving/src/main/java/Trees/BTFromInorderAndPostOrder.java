package Trees;

import java.util.HashMap;
import java.util.Map;

public class BTFromInorderAndPostOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int n = inorder.length;
		int m = postorder.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			map.put(inorder[i], i);
		}
		return build(inorder, postorder, 0, n - 1, m - 1, map);
	}

	public TreeNode build(int[] inorder, int[] postorder, int start, int end, int position, Map<Integer, Integer> map) {
		if (start > end)
			return null;

		int mid = map.get(postorder[position]);
		TreeNode root = new TreeNode(postorder[position]);
		root.left = build(inorder, postorder, start, mid - 1, position - (end - mid + 1), map);
		root.right = build(inorder, postorder, mid + 1, end, position - 1, map);
		return root;
	}

}
