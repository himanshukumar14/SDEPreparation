package DP;

/**
 * 
 * Given a string s, return true if it is possible to split the string s into
 * three non-empty palindromic substrings. Otherwise, return false​​​​
 * 
 * A string is said to be palindrome if it the same string when reversed.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcbdd" Output: true Explanation: "abcbdd" = "a" + "bcb" + "dd",
 * and all three substrings are palindromes. Example 2:
 * 
 * Input: s = "bcbddxy" Output: false Explanation: s cannot be split into 3
 * palindromes.
 *
 */

public class PalindromePartioning4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean checkPartitioning(String s) {
		int n = s.length();
		if (n < 3)
			return false;
		boolean[][] isPal = new boolean[n][n];
		isPal = setPalindrome(s, isPal);

		for (int i = 1; i < n - 1; ++i) {
			for (int j = 0; j < i; ++j) {
				if (isPal[0][j] && isPal[j + 1][i] && isPal[i + 1][n - 1]) {
					return true;
				}
			}
		}
		return false;
	}

    public boolean[][] setPalindrome(String s, boolean[][] pal) {
        int n = s.length();
        for(int k = 1; k <= n; ++k) {
            for(int i = 0; i < n - k + 1; ++i) {
                int j = i + k - 1;
                if(s.charAt(i) == s.charAt(j) && (j == i || j == i + 1 || pal[i + 1][j - 1]))
                    pal[i][j] = true;
                else
                    pal[i][j] = false;
            }
        }
        return pal;
    }

}
