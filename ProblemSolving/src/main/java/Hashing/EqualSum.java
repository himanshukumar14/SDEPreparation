package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array A of N integers, find the index of values that satisfy P + Q =
 * R + S, where P, Q, R & S are integers values in the array
 * 
 * Expected time complexity O(N2)
 * 
 * NOTE:
 * 
 * 1) Return the indices `A1 B1 C1 D1`, so that A[A1] + A[B1] = A[C1] + A[D1] A1
 * < B1, C1 < D1 A1 < C1, B1 != D1, B1 != C1
 * 
 * 2) If there are more than one solutions, then return the tuple of values
 * which are lexicographical smallest.
 * 
 * Assume we have two solutions S1 : A1 B1 C1 D1 ( these are values of indices
 * in the array ) S2 : A2 B2 C2 D2
 * 
 * S1 is lexicographically smaller than S2 if: A1 < A2 OR A1 = A2 AND B1 < B2 OR
 * A1 = A2 AND B1 = B2 AND C1 < C2 OR A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 <
 * D2 If no solution is possible, return an empty list.
 * 
 * Problem Constraints 1 <= N <= 1000
 * 
 * 0 <= A[i] <= 1000
 * 
 * Input Format First and only argument is an integer array A of length N.
 * 
 * Output Format Return an array of size four which contains indices of values
 * P, Q, R, and S.
 * 
 * Example Input Input 1:
 * 
 * A = [3, 4, 7, 1, 2, 9, 8] Input 2:
 * 
 * A = [2, 5, 1, 6]
 * 
 * Example Output Output 1:
 * 
 * [0, 2, 3, 5] Output 2:
 * 
 * [0, 1, 2, 3]
 * 
 * Example Explanation Explanation 1:
 * 
 * A[0] + A[2] = A[3] + A[5] Note: indexes returned should be 0-based.
 * Explanation 2:
 * 
 * A[0] + A[1] = A[2] + A[3]
 *
 */

public class EqualSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] equal(int[] A) {
		int n = A.length;
		int[] a = new int[4];
		ArrayList<Integer> ans = new ArrayList<>();
		Map<Integer, ArrayList<Integer>> m = new HashMap<>();

		for (int i = 0; i < n - 1; ++i) {
			for (int j = i + 1; j < n; ++j) {
				int sum = A[i] + A[j];
				if (m.containsKey(sum)) {
					if (i != m.get(sum).get(0) && i != m.get(sum).get(1) && j != m.get(sum).get(0)
							&& j != m.get(sum).get(1)) {
						if (ans.size() == 0) {
							ans.add(m.get(sum).get(0));
							ans.add(m.get(sum).get(1));
							ans.add(i);
							ans.add(j);
						} else {
							if (m.get(sum).get(0) < ans.get(0)) {
								ans.clear();
								ans.add(m.get(sum).get(0));
								ans.add(m.get(sum).get(1));
								ans.add(i);
								ans.add(j);
							} else if (m.get(sum).get(0) == ans.get(0) && m.get(sum).get(1) < ans.get(1)) {
								ans.clear();
								ans.add(m.get(sum).get(0));
								ans.add(m.get(sum).get(1));
								ans.add(i);
								ans.add(j);
							}
						}
					}
				} else {
					ArrayList<Integer> l = new ArrayList<>();
					l.add(i);
					l.add(j);
					m.put(sum, l);
				}
			}
		}

		if (ans.size() == 0)
			return a;
		else {
			a[0] = ans.get(0);
			a[1] = ans.get(1);
			a[2] = ans.get(2);
			a[3] = ans.get(3);
			return a;
		}
	}

}
