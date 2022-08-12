package BST;

import java.util.Stack;

public class PreOrderToPostOrderBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preOrder = new int[] { 40,30,32,35,80,90,100,120 };
		convertPreOrder(preOrder);
		for (int x : postOrder) {
			System.out.println(x);
		}
	}

	public static int[] postOrder;
	public static int index;
	public static int[] nextGreater;

	public static void convertPreOrder(int[] preOrder) {
		int n = preOrder.length;
		postOrder = new int[n];
		index = n - 1;
		nextGreater = setNextGreater(preOrder);
		treeUtil(preOrder, 0, n - 1);

	}

	public static void treeUtil(int[] arr, int start, int end) {
		if (start > end)
			return;
		int mid = getNextGreater(arr, start);
		postOrder[index--] = arr[start];
		treeUtil(arr, mid, end);
		treeUtil(arr, start + 1, mid - 1);
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
}
