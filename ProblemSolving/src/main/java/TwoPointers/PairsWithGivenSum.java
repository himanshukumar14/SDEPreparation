package TwoPointers;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a sorted array of integers (not necessarily distinct) A and an integer
 * B, find and return how many pair of integers ( A[i], A[j] ) such that i != j
 * have sum equal to B.
 * 
 * Since the number of such pairs can be very large, return number of such pairs
 * modulo (109 + 7).
 * 
 * 
 * 
 * Problem Constraints 1 <= |A| <= 100000
 * 
 * 1 <= A[i] <= 10^9
 * 
 * 1 <= B <= 10^9
 * 
 * 
 * 
 * Input Format The first argument given is the integer array A.
 * 
 * The second argument given is integer B.
 * 
 * 
 * 
 * Output Format Return the number of pairs for which sum is equal to B modulo
 * (10^9+7).
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [1, 1, 1] B = 2 Input 2:
 * 
 * 
 * A = [1, 1] B = 2
 * 
 * 
 * Example Output Output 1:
 * 
 * 3 Output 2:
 * 
 * 1
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * Any two pairs sum up to 2. Explanation 2:
 * 
 * only pair (1, 2) sums up to 2.
 *
 */

public class PairsWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int[] A, int B) {
		int n = A.length;
		Map<Integer, Integer> m = new HashMap<>();
		long count = 0;

		for (int i = 0; i < n; ++i) {
			if (m.containsKey(B - A[i])) {
				count = (count + (m.get(B - A[i])) % 1000000007) % 1000000007;
			}
			m.put(A[i], m.getOrDefault(A[i], 0) + 1);
		}
		return (int) count;
	}

}
