package Backtracking;

/**
 * 
 * Given a string S. The task is to print all permutations of a given string in
 * lexicographically sorted order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: ABC Output: ABC ACB BAC BCA CAB CBA Explanation: Given string ABC has
 * permutations in 6 forms as ABC, ACB, BAC, BCA, CAB and CBA . Example 2:
 * 
 * Input: ABSG Output: ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG
 * BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA Explanation:
 * Given string ABSG has 24 permutations.
 * 
 * 
 * Your Task: You don't need to read input or print anything. Your task is to
 * complete the function find_permutaion() which takes the string S as input
 * parameter and returns a vector of string in lexicographical order.
 * 
 * 
 * 
 * Expected Time Complexity: O(n! * n)
 * 
 * Expected Space Complexity: O(n)
 *
 * 
 * 
 */

public class AnagramOfString {

	public static void main(String[] args) {
		String str = "ABC";
		int n = str.length();
		permute(str, 0, n - 1);
	}

	private static void permute(String str, int l, int r) {
		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	public static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

}
