package GreedyAlgorithm;

/**
 * 
 * Given two numbers 'N' and 'S' , find the largest number that can be formed
 * with 'N' digits and whose sum of digits should be equals to 'S'.
 * 
 * Example 1:
 * 
 * Input: N = 2, S = 9 Output: 90 Explaination: It is the biggest number with
 * sum of digits equals to 9. Example 2:
 * 
 * Input: N = 3, S = 20 Output: 992 Explaination: It is the biggest number with
 * sum of digits equals to 20. Your Task: You do not need to read input or print
 * anything. Your task is to complete the function findLargest() which takes N
 * and S as input parameters and returns the largest possible number. Return -1
 * if no such number is possible.
 * 
 * Expected Time Complexity: O(N) Exepcted Auxiliary Space: O(1)
 *
 */

public class LargestNumberPossible {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static String findLargest(int m, int s) {
		if (s == 0)
			return m == 1 ? "0" : "-1";

		if (s > 9 * m)
			return "-1";

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			if (s >= 9) {
				sb.append("9");
				s -= 9;
			} else {
				sb.append(s);
				s = 0;
			}
		}
		return sb.toString();
	}
}
