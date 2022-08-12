package Stack;

import java.util.Stack;

public class LargestRectangleHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int largestRectangleArea(int[] A) {
		int[] nextSmaller = nextSmaller(A);
		int[] prevSmaller = prevSmaller(A);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; ++i) {
			int prev = prevSmaller[i];
			int next = nextSmaller[i];
			max = Math.max(max, Math.abs(((next - 1) - (prev + 1) + 1)) * A[i]);
		}
		return max;
	}

	public int[] nextSmaller(int[] A) {
		Stack<Integer> stack = new Stack<>();
		int[] nextSmall = new int[A.length];
		for (int i = A.length - 1; i >= 0; --i) {
			while (!stack.isEmpty() && A[stack.peek()] >= A[i])
				stack.pop();

			nextSmall[i] = stack.isEmpty() ? A.length : stack.peek();
			stack.push(i);
		}
		return nextSmall;
	}

	public int[] prevSmaller(int[] A) {
		Stack<Integer> stack = new Stack<>();
		int[] prevSmall = new int[A.length];
		for (int i = 0; i < A.length; ++i) {
			while (!stack.isEmpty() && A[stack.peek()] >= A[i])
				stack.pop();

			prevSmall[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}
		return prevSmall;
	}

}
