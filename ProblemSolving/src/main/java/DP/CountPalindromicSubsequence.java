package DP;

/**
 * 
 * Find how many palindromic subsequences (need not necessarily be distinct) can
 * be formed in a given string. Note that the empty string is not considered as
 * a palindrome. Examples:
 * 
 * Input : str = "abcd" Output : 4 Explanation :- palindromic subsequence are :
 * "a" ,"b", "c" ,"d"
 * 
 * Input : str = "aab" Output : 4 Explanation :- palindromic subsequence are
 * :"a", "a", "b", "aa"
 * 
 * Input : str = "aaaa" Output : 15
 *
 */

/**
 * 
 * The above problem can be recursively defined.
 * 
 * Initial Values : i= 0, j= n-1;
 * 
 * CountPS(i,j) // Every single character of a string is a palindrome //
 * subsequence if i == j return 1 // palindrome of length 1
 * 
 * // If first and last characters are same, then we // consider it as
 * palindrome subsequence and check // for the rest subsequence (i+1, j), (i,
 * j-1) Else if (str[i] == str[j)] return countPS(i+1, j) + countPS(i, j-1) + 1;
 * 
 * else // check for rest sub-sequence and remove common // palindromic
 * subsequences as they are counted // twice when we do countPS(i+1, j) +
 * countPS(i,j-1) return countPS(i+1, j) + countPS(i, j-1) - countPS(i+1, j-1)
 *
 */

public class CountPalindromicSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int countPS(String str) {
		int N = str.length();
		int[][] cps = new int[N][N];

		for (int i = 0; i < N; i++)
			cps[i][i] = 1;

		for (int L = 2; L <= N; L++) {
			for (int i = 0; i < N - L + 1; i++) {
				int j = i + L - 1;
				if (str.charAt(i) == str.charAt(j)) {
					//if we consider both i && j element then, 1 +  cps[i + 1][j - 1]
					//and if we don't consider then cps[i-1][j] + cps[i][j-1] - cps[i + 1][j - 1], so total leads to below
					cps[i][j] = cps[i][j - 1] + cps[i + 1][j] + 1;
				} else {
					cps[i][j] = cps[i][j - 1] + cps[i + 1][j] - cps[i + 1][j - 1];
				}
			}
		}

		// return total palindromic subsequence
		return cps[0][N - 1];
	}

}
