package DP;

import java.util.Arrays;

public class PalindromePartioning2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//slow solution O(n3)
	public int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        boolean[][] isPal = new boolean[n][n];
        isPal = setPalindrome(s, isPal);
        
        for(int i = 0; i < n; ++i) {
            dp[i][i] = 0;
        }
        
        for(int i = 0; i < n -1; ++i) {
            if(s.charAt(i) == s.charAt(i + 1))
                dp[i][i + 1] = 0;
            else 
                dp[i][i + 1] = 1;
        }
        
        for(int k = 3; k <= n; ++k) {
            for(int i = 0; i < n - k + 1; ++i) {
                int j = i + k - 1;
                if(isPalindrome(i, j, isPal)) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = getPartitions(i, j, dp);
                }
            }
        }
        return dp[0][n - 1];
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
    
    public boolean isPalindrome(int i, int j, boolean[][] isPal) {
        return isPal[i][j];
    }
    
    public int getPartitions(int i, int j, int[][] dp) {
        int minVal = Integer.MAX_VALUE;
        for(int k = i; k < j; ++k) {
            int val;
            val = dp[i][k] + dp[k + 1][j];
            if(val == 0)
                return 1 + val;
            minVal = Math.min(minVal, val);
        }
        return minVal + 1;
    }
    
    //////////////////////////////////////fast solution O(n2)
	
	public int minCut2(String str) {
		int n = str.length();
		if (n == 0)
			return 0;

		int[] cut = new int[n];
		Arrays.fill(cut, Integer.MAX_VALUE);
		
		boolean isPal[][] = new boolean[n][n];
		isPal = setPalindrome(str, isPal);
		for(int i = 0; i < n; i++) {
			if(isPal[0][i]) {
				cut[i] = 0;
			} else {
				for(int j = 0; j < i; ++j) {
					if(isPal[j + 1][i])
						cut[i] = Math.min(cut[j] + 1, cut[i]);
				}
			}
		}
		return cut[n - 1];
	}

}
