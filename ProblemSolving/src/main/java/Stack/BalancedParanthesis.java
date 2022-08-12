package Stack;

import java.util.Stack;

//Given a string A consisting only of '(' and ')'.
//You need to find whether parantheses in A is balanced or not ,if it is balanced then return 1 else return 0.

public class BalancedParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(String A) {
		Stack<Character> stack = new Stack<>();
		int n = A.length();

		for (int i = 0; i < n; ++i) {
			char current = A.charAt(i);
			if (current == '(') {
				stack.push(current);
			} else if (stack.isEmpty()) {
				return 0;
			} else {
				stack.pop();
			}
		}
		return stack.isEmpty() ? 1 : 0;
	}

}
