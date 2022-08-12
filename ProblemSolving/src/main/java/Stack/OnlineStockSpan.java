package Stack;

import java.util.Stack;

public class OnlineStockSpan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Stack<int[]> stack;

	public OnlineStockSpan() {
		stack = new Stack<>();
	}

	public int next(int price) {
		int res = 1;
		while (!stack.isEmpty() && price >= stack.peek()[0]) {
			res += stack.pop()[1];
		}
		stack.push(new int[] { price, res });
		return res;
	}

}
