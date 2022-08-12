package Stack;

import java.util.Stack;

/**
 * 
 * Infix expression: The expression of the form a op b. When an operator is
 * in-between every pair of operands. Postfix expression: The expression of the
 * form a b op. When an operator is followed for every pair of operands. Postfix
 * notation, also known as reverse Polish notation, is a syntax for mathematical
 * expressions in which the mathematical operator is always placed after the
 * operands. Though postfix expressions are easily and efficiently evaluated by
 * computers, they can be difficult for humans to read. Complex expressions
 * using standard parenthesized infix notation are often more readable than the
 * corresponding postfix expressions. Consequently, we would sometimes like to
 * allow end users to work with infix notation and then convert it to postfix
 * notation for computer processing. Sometimes, moreover, expressions are stored
 * or generated in postfix, and we would like to convert them to infix for the
 * purpose of reading and editing Examples:
 * 
 * 
 * Input : abc++ Output : (a + (b + c))
 * 
 * Input : ab*c+ Output : ((a*b)+c)
 *
 */

public class PostfixToInfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static boolean isOperand(char x) {
		return (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z');
	}

	static String getInfix(String exp) {
		Stack<String> s = new Stack<String>();

		for (int i = 0; i < exp.length(); i++) {
			// Push operands
			if (isOperand(exp.charAt(i))) {
				s.push(exp.charAt(i) + "");
			} else {
				String op1 = s.peek();
				s.pop();
				String op2 = s.peek();
				s.pop();
				s.push("(" + op2 + exp.charAt(i) + op1 + ")");
			}
		}

		// There must be a single element
		// in stack now which is the required
		// infix.
		return s.peek();
	}

}
