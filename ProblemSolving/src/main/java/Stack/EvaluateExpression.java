package Stack;

import java.util.Stack;

public class EvaluateExpression {

	// An arithmetic expression is given by a character array A of size N. Evaluate
	// the value of an arithmetic expression
	// in Reverse Polish Notation.
	// Valid operators are +, -, *, /. Each character may be an integer or an
	// operator.

	public static void main(String[] args) {

	}

	public static int evalRPN(String[] A) {
		Stack<String> s = new Stack<>();
		for (int i = 0; i < A.length; ++i) {
			if (!A[i].equals("+") && !A[i].equals("-") && !A[i].equals("*") && !A[i].equals("/")) {
				s.push(A[i]);
			} else {
				int y = Integer.valueOf(s.pop());
				int x = Integer.valueOf(s.pop());
				int val = 0;
				switch (A[i]) {
				case "*":
					val = x * y;
					break;

				case "/":
					val = x / y;
					break;

				case "+":
					val = x + y;
					break;

				case "-":
					val = x - y;
					break;
				}
				s.push(String.valueOf(val));
			}
		}
		return Integer.valueOf(s.pop());
	}

}
