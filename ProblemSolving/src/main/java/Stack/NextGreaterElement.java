package Stack;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] nextGreater(int[] A) {
		Stack<Integer> stack = new Stack<>();
		int n = A.length;
		int[] ans = new int[n];
		for(int i = n - 1; i >= 0; --i) {
			while(!stack.isEmpty() && stack.peek() <= A[i]) {
				stack.pop();
			}
			ans[i] = stack.isEmpty() ? n : stack.peek(); 
			stack.push(A[i]);
		}
		return ans;
	}

}
