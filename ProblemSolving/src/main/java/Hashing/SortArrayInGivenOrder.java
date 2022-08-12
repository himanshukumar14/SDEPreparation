package Hashing;

import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * Given two arrays of integers A and B, Sort A in such a way that the relative
 * order among the elements will be the same as those are in B. For the elements
 * not present in B, append them at last in sorted order.
 * 
 * Return the array A after sorting from the above method.
 * 
 * NOTE: Elements of B are unique.
 * 
 * Problem Constraints 1 <= length of the array A <= 100000
 * 
 * 1 <= length of the array B <= 100000
 * 
 * -10^9 <= A[i] <= 10^9
 * 
 * Input Format The first argument given is the integer array A.
 * 
 * The second argument given is the integer array B.
 * 
 * Output Format Return the array A after sorting as described.
 * 
 * Example Input Input 1:
 * 
 * A = [1, 2, 3, 4, 5] B = [5, 4, 2] Input 2:
 * 
 * A = [5, 17, 100, 11] B = [1, 100]
 * 
 * Example Output Output 1:
 * 
 * [5, 4, 2, 1, 3] Output 2:
 * 
 * [100, 5, 11, 17]
 * 
 * Example Explanation Explanation 1:
 * 
 * Simply sort as described. Explanation 2:
 * 
 * Simply sort as described.
 *
 */

public class SortArrayInGivenOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solve(int[] A, int[] B) {
		int n1 = A.length;
		int n2 = B.length;
		int[] ans = new int[n1];

		Map<Integer, Integer> m1 = new TreeMap<>();
		for (int i = 0; i < n1; ++i) {
			m1.put(A[i], m1.getOrDefault(A[i], 0) + 1);
		}

		int j = 0;
		for (int i = 0; i < n2; ++i) {
			if (m1.containsKey(B[i])) {
				int count = m1.get(B[i]);
				while (count > 0) {
					ans[j++] = B[i];
					count--;
				}
				m1.remove(B[i]);
			}
		}

		for (int x : m1.keySet()) {
			int count = m1.get(x);
			while (count > 0) {
				ans[j++] = x;
				count--;
			}
		}

		return ans;
	}

}
