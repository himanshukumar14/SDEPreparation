package Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array A of length N. You have to answer Q queries.
 * 
 * Each query will contain four integers l1, r1, l2, and r2. If sorted segment
 * from [l1, r1] is the same as the sorted segment from [l2 r2], then the answer
 * is 1 else 0.
 * 
 * NOTE The queries are 0-indexed.
 * 
 * 
 * 
 * Problem Constraints 0 <= A[i] <= 100000 1 <= N <= 100000 1 <= Q <= 100000
 * 
 * 
 * 
 * Input Format The first argument is an array A. The second is a 2D array B
 * denoting queries with dimension Q * 4. Consider ith query as l1 = B[i][0], r1
 * = B[i][1], l2 = A[i][2], r2 = B[i][3].
 * 
 * 
 * 
 * Output Format Return an array of length Q with answers to the queries in the
 * same order as the input.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [1, 7, 11, 8, 11, 7, 1] B = [ [0, 2, 4, 6] ] Input 2:
 * 
 * A = [1, 3, 2] B = [ [0, 1, 1, 2] ]
 * 
 * 
 * Example Output Output 1:
 * 
 * [1] Output 2:
 * 
 * [0]
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * (0, 2) -> [1, 7, 11] (4, 6) -> [11, 7, 1] Both are same when sorted hence 1.
 * Explanation 2:
 * 
 * (0, 1) -> [1, 3] (1, 2) -> [3, 2] Both are different when sorted hence 0.
 *
 */

public class CompareSortedSubarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] solve(int[] A, int[][] B) {
		int n = B.length;
		int[] ans = new int[n];
		int[] prefix = new int[A.length];

		prefix[0] = A[0];
		for (int i = 1; i < A.length; ++i) {
			prefix[i] = prefix[i - 1] + A[i];
		}

		for (int i = 0; i < B.length; ++i) {
			int l1 = B[i][0];
			int r1 = B[i][1];
			int l2 = B[i][2];
			int r2 = B[i][3];
			if ((r1 - l1) != (r2 - l2)) {
				ans[i] = 0;
				continue;
			}
			int sum1 = 0;
			int sum2 = 0;
			sum1 = l1 > 0 ? prefix[r1] - prefix[l1 - 1] : prefix[r1];
			sum2 = l2 > 0 ? prefix[r2] - prefix[l2 - 1] : prefix[r2];
			ans[i] = sum1 == sum2 ? 1 : 0;
			if (sum1 == sum2) {
				if (check(A, B[i]))
					ans[i] = 1;
				else
					ans[i] = 0;
			} else {
				ans[i] = 0;
			}
		}
		return ans;
	}

	public static boolean check(int[] A, int[] q) {
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = q[0]; i <= q[1]; ++i) {
			m.put(A[i], m.getOrDefault(A[i], 0) + 1);
		}

		for (int i = q[2]; i <= q[3]; ++i) {
			if (m.containsKey(A[i])) {
				int v = m.get(A[i]) - 1;
				if (v == 0)
					m.remove(A[i]);
				else
					m.put(A[i], v);
			} else {
				return false;
			}
		}
		return m.size() == 0;
	}

}
