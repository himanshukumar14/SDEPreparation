package Stack;

import java.util.Stack;

/**
 * 
 * Given a string consisting of opening and closing parenthesis, find the length
 * of the longest valid parenthesis substring.
 * 
 * Examples:
 * 
 * Input : ((() Output : 2 Explanation : ()
 * 
 * Input: )()()) Output : 4 Explanation: ()()
 * 
 * Input: ()(())))) Output: 6 Explanation: ()(())
 *
 */

public class LengthOfLongestValidSubstring {

	public static int solve(String s, int n) {
		int left = 0, right = 0;
		int maxlength = 0;

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(')
				left++;
			else
				right++;

			if (left == right)
				maxlength = Math.max(maxlength, 2 * right);
			else if (right > left)
				left = right = 0;
		}

		left = right = 0;

		// Iterating the string from right to left
		for (int i = n - 1; i >= 0; i--) {
			if (s.charAt(i) == '(')
				left++;
			else
				right++;

			if (left == right)
				maxlength = Math.max(maxlength, 2 * left);
			else if (left > right)
				left = right = 0;
		}
		return maxlength;
	}

	// Driver code
	public static void main(String args[]) {
		// Function call
		System.out.print(solve("((()()()()(((())", 16));
	}

	// Stack method
	static int findMaxLen(String str) {
		int n = str.length();

		Stack<Integer> stk = new Stack<>();
		stk.push(-1);

		int result = 0;
		for (int i = 0; i < n; i++) {
			if (str.charAt(i) == '(')
				stk.push(i);
			else {
				if (!stk.empty())
					stk.pop();

				if (!stk.empty())
					result = Math.max(result, i - stk.peek());
				else
					stk.push(i);
			}
		}

		return result;
	}

}
