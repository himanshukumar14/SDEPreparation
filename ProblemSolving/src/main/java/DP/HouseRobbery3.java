package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * The thief has found himself a new place for his thievery again. There is only
 * one entrance to this area, called root.
 * 
 * Besides the root, each house has one and only one parent house. After a tour,
 * the smart thief realized that all houses in this place form a binary tree. It
 * will automatically contact the police if two directly-linked houses were
 * broken into on the same night.
 * 
 * Given the root of the binary tree, return the maximum amount of money the
 * thief can rob without alerting the police.
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,2,3,null,3,null,1] Output: 7 Explanation: Maximum amount of
 * money the thief can rob = 3 + 3 + 1 = 7. Example 2:
 * 
 * 
 * Input: root = [3,4,5,1,3,null,1] Output: 9 Explanation: Maximum amount of
 * money the thief can rob = 4 + 5 = 9.
 *
 */

public class HouseRobbery3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<TreeNode, Integer> dp = new HashMap<>();

	public int rob(TreeNode root) {
		if (root == null)
			return 0;
		if (dp.containsKey(root))
			return dp.get(root);

		if (root.left == null && root.right == null)
			return root.val;

		int excludeSelf = rob(root.left) + rob(root.right);

		int includeSelf = root.val;
		if (root.left != null)
			includeSelf += rob(root.left.left) + rob(root.left.right);
		if (root.right != null)
			includeSelf += rob(root.right.left) + rob(root.right.right);
		dp.put(root, Math.max(excludeSelf, includeSelf));
		return dp.get(root);
	}

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
	}
}
