package DP;

import java.util.Arrays;

/**
 * 
 * Given a boolean expression with following symbols.
 * 
 * Symbols 'T' ---> true 'F' ---> false And following operators filled between
 * symbols
 * 
 * Operators & ---> boolean AND | ---> boolean OR ^ ---> boolean XOR Count the
 * number of ways we can parenthesize the expression so that the value of
 * expression evaluates to true. Let the input be in form of two arrays one
 * contains the symbols (T and F) in order and the other contains operators (&,
 * | and ^}
 * 
 * Examples:
 * 
 * Input: symbol[] = {T, F, T} operator[] = {^, &} Output: 2 The given
 * expression is "T ^ F & T", it evaluates true in two ways "((T ^ F) & T)" and
 * "(T ^ (F & T))"
 * 
 * Input: symbol[] = {T, F, F} operator[] = {^, |} Output: 2 The given
 * expression is "T ^ F | F", it evaluates true in two ways "( (T ^ F) | F )"
 * and "( T ^ (F | F) )".
 * 
 * Input: symbol[] = {T, T, F, T} operator[] = {|, &, ^} Output: 4 The given
 * expression is "T | T & F ^ T", it evaluates true in 4 ways ((T|T)&(F^T)),
 * (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
 *
 */

// it's like matrix chain multiplication

public class BooleanParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int countWays(int N, String S) {
		int dp[][][] = new int[N + 1][N + 1][2];

		for (int row[][] : dp)
			for (int col[] : row)
				Arrays.fill(col, -1);
		return parenthesis_count(S, 0, N - 1, 1, dp);
	}

	public static int parenthesis_count(String str, int i, int j, int isTrue, int[][][] dp) {
		if (i > j)
			return 0;

		if (i == j) {
			if (isTrue == 1)
				return (str.charAt(i) == 'T') ? 1 : 0;
			else
				return (str.charAt(i) == 'F') ? 1 : 0;
		}

		if (dp[i][j][isTrue] != -1)
			return dp[i][j][isTrue];

		int temp_ans = 0;

		int leftTrue, rightTrue, leftFalse, rightFalse;
		for (int k = i + 1; k < j; k += 2) {
			if (dp[i][k - 1][1] != -1)
				leftTrue = dp[i][k - 1][1];
			else
				leftTrue = parenthesis_count(str, i, k - 1, 1, dp); // Count number of True in left Partition

			if (dp[i][k - 1][0] != -1)
				leftFalse = dp[i][k - 1][0];
			else
				leftFalse = parenthesis_count(str, i, k - 1, 0, dp); // Count number of False in left Partition

			if (dp[k + 1][j][1] != -1)
				rightTrue = dp[k + 1][j][1];
			else
				rightTrue = parenthesis_count(str, k + 1, j, 1, dp); // Count number of True in right Partition

			if (dp[k + 1][j][0] != -1)
				rightFalse = dp[k + 1][j][0];
			else
				rightFalse = parenthesis_count(str, k + 1, j, 0, dp); // Count number of False in right Partition

			// Evaluate AND operation
			if (str.charAt(k) == '&') {
				if (isTrue == 1)
					temp_ans += leftTrue * rightTrue; // no. of ways for true
				else
					temp_ans += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
			}
			// Evaluate OR operation
			else if (str.charAt(k) == '|') {
				if (isTrue == 1)
					temp_ans += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
				else
					temp_ans += leftFalse * rightFalse;
			}
			// Evaluate XOR operation
			else if (str.charAt(k) == '^') {
				if (isTrue == 1)
					temp_ans += leftTrue * rightFalse + leftFalse * rightTrue;
				else
					temp_ans += leftTrue * rightTrue + leftFalse * rightFalse;
			}
			dp[i][j][isTrue] = temp_ans;
		}
		return temp_ans;
	}

}
