package Stack;

import java.util.Stack;

public class MaxRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int[][] A) {
		int r = A.length;
		int c = A[0].length;
		int maxRect = Integer.MIN_VALUE;

		for (int i = 0; i < r; ++i) {
			int area = 0;
			if (i > 0) {
				for (int j = 0; j < c; ++j)
					A[i][j] = A[i][j] == 0 ? A[i][j] : A[i - 1][j] + A[i][j];
			}
			area = largestRectangleArea(A[i]);
			maxRect = Math.max(area, maxRect);
		}
		return maxRect;
	}

	public int largestRectangleArea(int[] A) {
		int n = A.length;
		int[] nextsmallest = new int[n];
		int[] prevsmallest = new int[n];
		findNextSmallest(A, nextsmallest);
		findPrevSmallest(A, prevsmallest);
		int maxArea = Integer.MIN_VALUE;

		for (int i = 0; i < n; ++i) {
			int area = (Math.abs((nextsmallest[i] - 1) - (prevsmallest[i] + 1)) + 1) * A[i];
			maxArea = Math.max(area, maxArea);
		}
		return maxArea;
	}

	public void findNextSmallest(int[] A, int[] smallest) {
		Stack<Integer[]> s = new Stack<>();
		int n = A.length;

		for (int i = n - 1; i >= 0; --i) {
			while (!s.isEmpty() && s.peek()[0] >= A[i]) {
				s.pop();
			}
			smallest[i] = s.isEmpty() ? n : s.peek()[1];
			s.push(new Integer[] { A[i], i });
		}
	}

	public void findPrevSmallest(int[] A, int[] smallest) {
		Stack<Integer[]> s = new Stack<>();
		int n = A.length;

		for (int i = 0; i < n; ++i) {
			while (!s.isEmpty() && s.peek()[0] >= A[i]) {
				s.pop();
			}
			smallest[i] = s.isEmpty() ? -1 : s.peek()[1];
			s.push(new Integer[] { A[i], i });
		}
	}
}
