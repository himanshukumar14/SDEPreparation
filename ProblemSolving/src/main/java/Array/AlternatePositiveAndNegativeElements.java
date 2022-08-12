package Array;

/**
 * 
 * Problem Description Given an array of integers A, arrange them in an
 * alternate fashion such that every non-negative number is followed by negative
 * and vice-versa, starting from a negative number, maintaining the order of
 * appearance. The number of non-negative and negative numbers need not be
 * equal.
 * 
 * If there are more non-negative numbers, they appear at the end of the array.
 * If there are more negative numbers, they also appear at the array's end.
 * 
 * Note: Try solving with O(1) extra space.
 * 
 * 
 * 
 * Problem Constraints 1 <= length of the array <= 7000 -109 <= A[i] <= 109
 * 
 * 
 * 
 * Input Format The first argument given is the integer array A.
 * 
 * 
 * 
 * Output Format Return the modified array.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [-1, -2, -3, 4, 5] Input 2:
 * 
 * A = [5, -17, -100, -11]
 * 
 * 
 * Example Output Output 1:
 * 
 * [-1, 4, -2, 5, -3] Output 2:
 * 
 * [-17, 5, -100, -11]
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * A = [-1, -2, -3, 4, 5] Move 4 in between -1 and -2, A => [-1, 4, -2, -3, 5]
 * Move 5 in between -2 and -3, A => [-1, 4, -2, 5, -3]
 *
 * 
 */

public class AlternatePositiveAndNegativeElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solve(int[] A) {
		int index = -1;
		for (int i = 0; i < A.length; ++i) {
			if (index >= 0) {
				if ((A[index] > 0 && A[i] < 0) || (A[index] < 0 && A[i] > 0)) {
					rightRotate(A, index, i); // don't use swap because it changes arrangement
					if (i > index + 2)
						index = index + 2; // we are doing this since we know if we didn't get the correct number from here then this was wrong
					else
						index = -1;
				}
			}
			if (index == -1) {
				if ((A[i] > 0 && i % 2 == 0) || (A[i] < 0 && i % 2 == 1))
					index = i;
			}
		}
		return A;
	}

	public void rightRotate(int[] A, int i, int j) {
		int temp = A[j];
		for (int x = j; x > i; --x) {
			A[x] = A[x - 1];
		}
		A[i] = temp;
	}

}
