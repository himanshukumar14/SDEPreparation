package Trees;

import java.util.HashMap;
import java.util.Map;

public class BTFromInorderAndPreOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode buildTree(int[] inorder, int[] preorder) {
		Map<Integer, Integer> map = new HashMap<>();
		int n = inorder.length;

		for (int i = 0; i < n; ++i) {
			map.put(inorder[i], i);
		}

		return build(inorder, preorder, 0, n - 1, 0, map);
	}

	public TreeNode build(int[] inorder, int[] preorder, int start, int end, int position, Map<Integer, Integer> map) {
		if (start > end)
			return null;

		int mid = map.get(preorder[position]);
		TreeNode root = new TreeNode(preorder[position]);
		root.left = build(inorder, preorder, start, mid - 1, position + 1, map);
		root.right = build(inorder, preorder, mid + 1, end, position + (mid - start + 1), map);
		return root;
	}

}
