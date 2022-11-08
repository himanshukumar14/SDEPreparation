package BST;

/*
Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees
 */

public class MaximumSumBSTInBinaryTree {
    int max;

    public int maxSumBST(TreeNode root) {
        max = 0;
        max_min(root);
        return max;
    }

    //use concept of validate bst
    public int[] max_min(TreeNode root) {
        if (root == null)
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 1};

        int[] left = max_min(root.left);
        int[] right = max_min(root.right);
        int sum = left[2] + right[2] + root.val;
        boolean isBst = root.val > left[0] && root.val < right[1] && left[3] == 1 && right[3] == 1;
        if (isBst)
            max = Math.max(max, sum);

        return new int[]{Math.max(root.val, right[0]), Math.min(left[1], root.val), sum, isBst ? 1 : 0};
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
