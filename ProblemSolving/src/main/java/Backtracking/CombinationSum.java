package Backtracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * Given an array of integers and a sum B, find all unique combinations in the
 * array where the sum is equal to B. The same number may be chosen from the
 * array any number of times to make B.
 * 
 * Note: 1. All numbers will be positive integers. 2. Elements in a combination
 * (a1, a2, …, ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak). 3.
 * The combinations themselves must be sorted in ascending order.
 * 
 * 
 * Example 1:
 * 
 * Input: N = 4 arr[] = {7,2,6,5} B = 16 Output: (2 2 2 2 2 2 2 2) (2 2 2 2 2 6)
 * (2 2 2 5 5) (2 2 5 7) (2 2 6 6) (2 7 7) (5 5 6) Example 2:
 * 
 * Input: N = 11 arr[] = {6,5,7,1,8,2,9,9,7,7,9} B = 6 Output: (1 1 1 1 1 1) (1
 * 1 1 1 2) (1 1 2 2) (1 5) (2 2 2) (6)
 * 
 * Your Task: Your task is to complete the function combinationSum() which takes
 * the array A and a sum B as inputs and returns a list of list denoting the
 * required combinations in the order specified in the problem description. The
 * printing is done by the driver's code. If no set can be formed with the given
 * set, then "Empty" (without quotes) is printed.
 * 
 * 
 * Expected Time Complexity: O(X2 * 2N), where X is average of summation B/arr
 * for every number in the array. Expected Auxiliary Space: O(X * 2N)
 *
 * 
 * 
 */

public class CombinationSum {

	// don't give duplicate results
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(8);
		arr.add(1);
		arr.add(8);
		arr.add(6);
		arr.add(8);
		int sum = 12;
		combinationSum(arr, sum);
	}

	public static void combinationSum(ArrayList<Integer> A, int B) {
		Collections.sort(A);
		int n = A.size();
		recur(A, 0, n, B, new ArrayList<>());
		for(ArrayList<Integer> l : ans) {
			for(int x : l) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

	public static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	public static void recur(ArrayList<Integer> arr, int start, int n, int sum, ArrayList<Integer> res) {
		if(sum < 0)
			return;	
		if(sum == 0) {
			ans.add(new ArrayList<>(res));
			return;
		}
		for(int i = start; i < n; ++i) {
		    if(i > 0) {
		        if(arr.get(i) == arr.get(i - 1))
		            continue;
		    }
			res.add(arr.get(i));
			recur(arr, i, n, sum - arr.get(i), res);
			res.remove(res.size() - 1);
		}
	}

}
