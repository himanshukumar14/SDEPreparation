package BST;

import java.util.Stack;

public class BSTFromPreorder {

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 5, 1, 7, 40, 50 };
		TreeNode tree = constructTree(arr);
		
		System.out.println(tree.val);
		System.out.println(tree.left.val);
		System.out.println(tree.right.val);
		System.out.println(tree.left.left.val);
		System.out.println(tree.left.right.val);
		System.out.println(tree.right.right.val);
		System.out.println(tree.right.left);
	}

	public static int[] nextGreater;

	public static TreeNode constructTree(int preOrder[]) {
		int n = preOrder.length;
		nextGreater = setNextGreater(preOrder);
		return constructTreeUtil(preOrder, 0, n - 1);
	}

	public static TreeNode constructTreeUtil(int preOrder[], int start, int end) {
		if (start > end)
			return null;
		TreeNode root = new TreeNode(preOrder[start]);
		int mid = getNextGreater(preOrder, start);
		root.left = constructTreeUtil(preOrder, start + 1, mid - 1);
		root.right = constructTreeUtil(preOrder, mid, end);
		return root;
	}

	public static int getNextGreater(int[] arr, int index) {
		return nextGreater[index];
	}

	public static int[] setNextGreater(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int n = arr.length;
		int[] ans = new int[n];
		for (int i = n - 1; i >= 0; --i) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				stack.pop();
			}
			ans[i] = stack.isEmpty() ? n : stack.peek();
			stack.add(i);
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
