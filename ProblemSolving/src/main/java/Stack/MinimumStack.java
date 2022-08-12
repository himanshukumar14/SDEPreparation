package Stack;

import java.util.Stack;

public class MinimumStack {

	public static void main(String[] args) {

	}

	class MinStack {
		private Stack<Integer> stack = null;
		private int min = Integer.MAX_VALUE;

		public MinStack() {
			stack = new Stack<>();
		}

		public void push(int val) {
			if (val < min) {
				stack.add(2 * val - min); // instead of adding x add 2x - currmin when val < currmin
				min = val;
			} else {
				stack.add(val);
			}
		}

		public void pop() {
			int top = stack.pop();
			if (top < min) {
				int curr = min;
				min = 2 * curr - top;
			}
		}

		public int top() {
			int top = stack.peek();
			if (top < min)
				return min;
			else
				return top;
		}

		public int getMin() {
			return min;
		}
	}

}
