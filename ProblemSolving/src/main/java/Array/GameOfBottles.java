package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of integers, A of length N denotes N cylindrical empty
 * bottles. The radius of the ith bottle is A[i]. You can put the ith bottle
 * into the jth bottle if the following conditions are met:
 * 
 * The ith bottle is not put into another bottle. The jth bottle doesn't contain
 * any other bottle. The radius of bottle i is smaller than bottle j (A[i] <
 * A[j]). You can put bottles into each other any number of times. You want to
 * MINIMIZE the number of visible bottles. A bottle is visible if it is not put
 * into any other bottle.
 * 
 * Find and return the minimum number of visible bottles.
 * 
 * Problem Constraints 1 <= N <= 100000
 * 
 * 1<= A[i] <= 100000000
 * 
 * Input Format The first argument is an integer array A denoting the radius of
 * the cylindrical bottles.
 * 
 * Output Format Return a single integer corresponding to the minimum number of
 * visible bottles.
 * 
 * Example Input Input 1:
 * 
 * A = [1, 2, 3] Input 2:
 * 
 * A = [1, 1]
 * 
 * Example Output Output 1:
 * 
 * 1 Output 2:
 * 
 * 2
 * 
 * Example Explanation Explanation 1:
 * 
 * In example 1 it is possible to put bottle 1 into bottle 2, and 2 into 3.
 * Explanation 2:
 * 
 * Both bottles will be visible.
 *
 */

public class GameOfBottles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// at any time bottles of same size can't fit in together, so max count of same size will be ans
	public int solve(int[] A) {
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < A.length; ++i) {
			m.put(A[i], m.getOrDefault(A[i], 0) + 1);
		}
		int max = Integer.MIN_VALUE;
		for (int k : m.keySet()) {
			max = Math.max(max, m.get(k));
		}
		return max;
	}

	public int solve2(ArrayList<Integer> A) {
		Collections.sort(A);
		int c = 1;
		int res = -1;
		for (int i = 1; i < A.size(); i++) {
			if (A.get(i).intValue() == A.get(i - 1).intValue())
				c++;
			else {
				res = Math.max(res, c);
				c = 1;
			}
		}
		res = Math.max(res, c);
		return res;
	}
}
