package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 
 * You are given two arrays/lists A and B of size N each. You are also
 * given an integer K. You have to find the K maximum and valid sum
 * combinations from all the possible sum combinations of the arrays/lists A
 * and B. Sum combination is made by adding one element from array A and
 * another element from array B. For Example : A : [1, 3] B : [4, 2] K : 2 The
 * possible sum combinations can be 5(3 + 2), 7(3 + 4), 3(1 + 2), 5(1 + 4). The
 * 2 maximum sum combinations are 7 and 5. Input Format : The first line of
 * input contains an integer 'T', denoting the number of test cases.
 * 
 * The first line of every test case contains two integers N and K denoting
 * the length of the array/list and the number of required sum combinations
 * respectively.
 * 
 * The second line of every test case contains N space-separated integers
 * denoting the elements of the array A.
 * 
 * The third line of every test case contains N space-separated integers
 * denoting the elements of the array B. Output Format : For every test case,
 * return the maximum K valid sum combinations in descending order. Note : You
 * dont have to print anything; it has already been taken care of. Just
 * implement the function. Constraints : 1 <= T <= 5 1 <= N <= 100 1 <= K <= N
 * -10^5 <= A[i], B[i] <= 10^5
 * 
 * Where 'A[i]' and 'B[i]' denotes the ith element in the given arrays/lists.
 * 
 * Time limit: 1 sec Sample Input 1 : 2 3 2 1 3 5 6 4 2 1 1 3 4 Sample Output 1
 * : 11 9 7 Explanation Of Sample Output 1 : In test case 1, for the given
 * arrays/lists, all the possible sum combinations are: 7(1 + 6), 5(1 + 4), 3(1
 * + 2), 9(3 + 6), 7(3 + 4), 5(3 + 2), 11(6 + 5), 9(5 + 4), 7(5 + 2).
 * 
 * The two maximum sum combinations from the above combinations are 11 and 9.
 * 
 * In test case 2, only one pair is possible with sum 7(3 + 4) from the given
 * arrays/lists. Sample Input 2 : 2 2 2 1 1 1 1 4 1 1 2 3 4 4 3 2 1 Sample
 * Output 2 : 2 2 8 Explanation Of Sample Input 2 : In test case 1, for the
 * given arrays/lists, two possible sum combinations are : 2(1 + 1), 2(1 + 1).
 * 
 * In test case 2, for the given arrays/lists, one possible sum combination is:
 * 8(4 + 4).
 * 
 */

public class KMaxSumCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k) {
		// Write your code here
		PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> x - y);
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				pq.add(a.get(i) + b.get(j));
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		while (k > 0) {
			ans.add(pq.poll());
			k--;
		}
		return ans;
	}

}
