package Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given two arrays of integers A and B describing a pair of (A[i], B[i])
 * coordinates in a 2D plane. A[i] describe x coordinates of the ith point in
 * the 2D plane, whereas B[i] describes the y-coordinate of the ith point in the
 * 2D plane.
 * 
 * Find and return the maximum number of points that lie on the same line.
 * 
 * 
 * 
 * Problem Constraints 1 <= (length of the array A = length of array B) <= 1000
 * 
 * -105 <= A[i], B[i] <= 105
 * 
 * 
 * 
 * Input Format The first argument is an integer array A. The second argument is
 * an integer array B.
 * 
 * 
 * 
 * Output Format Return the maximum number of points which lie on the same line.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [-1, 0, 1, 2, 3, 3] B = [1, 0, 1, 2, 3, 4] Input 2:
 * 
 * A = [3, 1, 4, 5, 7, -9, -8, 6] B = [4, -8, -3, -2, -1, 5, 7, -4]
 * 
 * 
 * Example Output Output 1:
 * 
 * 4 Output 2:
 * 
 * 2
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * The maximum number of point which lie on same line are 4, those points are
 * {0, 0}, {1, 1}, {2, 2}, {3, 3}. Explanation 2:
 * 
 * Any 2 points lie on a same line.
 *
 * 
 */

public class PointsOnASameLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int[] A, int[] B) {
		int ans = 0;
		Map<String, Integer> m = new HashMap<>();
		for (int i = 0; i < A.length; ++i) {
			int max = 0;
			for (int j = 0; j < A.length; ++j) {
				if (i == j || (A[i] == A[j] && B[i] == B[j]))
					continue;
				String slope = calcSlope(A[i], A[j], B[i], B[j]);
				m.put(slope, m.getOrDefault(slope, 0) + 1);
			}
			max = findMax(m) + 1;
			ans = Math.max(max, ans);
			m.clear();
		}
		return ans;
	}

	public int findMax(Map<String, Integer> m) {
		int max = 0;
		for (int x : m.values()) 
			max = Math.max(max, x);
		return max;
	}

	public int gcd(int a, int b) {
		if (b > a)
			return gcd(b, a);
		if (a == 1 || b == 1)
			return 1;
		if (b == 0)
			return a;
		return gcd(a % b, b);
	}

	public String calcSlope(int x1, int x2, int y1, int y2) {
		int g = gcd(Math.abs(y1 - y2), Math.abs(x1 - x2));
		String res = ((y1 - y2) / g) + "," + ((x1 - x2) / g);
		return res;
	}

}
