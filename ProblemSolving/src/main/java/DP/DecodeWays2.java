package DP;

/**
 * 
 * A message containing letters from A-Z can be encoded into numbers using the
 * following mapping:
 * 
 * 'A' -> "1" 'B' -> "2" ... 'Z' -> "26" To decode an encoded message, all the
 * digits must be grouped then mapped back into letters using the reverse of the
 * mapping above (there may be multiple ways). For example, "11106" can be
 * mapped into:
 * 
 * "AAJF" with the grouping (1 1 10 6) "KJF" with the grouping (11 10 6) Note
 * that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F'
 * since "6" is different from "06".
 * 
 * In addition to the mapping above, an encoded message may contain the '*'
 * character, which can represent any digit from '1' to '9' ('0' is excluded).
 * For example, the encoded message "1*" may represent any of the encoded
 * messages "11", "12", "13", "14", "15", "16", "17", "18", or "19". Decoding
 * "1*" is equivalent to decoding any of the encoded messages it can represent.
 * 
 * Given a string s consisting of digits and '*' characters, return the number
 * of ways to decode it.
 *
 */

public class DecodeWays2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numDecodings(String s) {
		int n = s.length();
		long[] dp = new long[n + 1];
		dp[0] = 1;

		if (s.charAt(0) != '0' && s.charAt(0) != '*') {
			dp[1] = 1;
		} else if (s.charAt(0) == '*') {
			dp[1] = 9;
		}

		for (int i = 2; i < n + 1; ++i) {
			char prev = s.charAt(i - 2);
			char curr = s.charAt(i - 1);

			// alone
			if (curr != '0' && curr != '*') {
				dp[i] += dp[i - 1];
			} else if (curr == '*') {
				dp[i] += (dp[i - 1] * 9);
			}

			// with previous
			if (prev != '0' && prev != '*' && curr != '*' && (prev - '0') * 10 + (curr - '0') <= 26) {
				dp[i] += dp[i - 2];
			} else if (prev == '*') {
				if (curr != '*' && curr - '0' <= 6) {
					dp[i] += (dp[i - 2] * 2);
				} else if (curr != '*' && curr - '0' > 6) {
					dp[i] += dp[i - 2];
				} else if (curr == '*') {
					dp[i] += (dp[i - 2] * 15);
				}
			} else if (curr == '*' && prev != '0' && (prev - '0') <= 2) {
				if (prev == '1') {
					dp[i] += (dp[i - 2] * 9);
				} else if (prev == '2') {
					dp[i] += (dp[i - 2] * 6);
				}
			}
		}
		return (int) dp[n];
	}

}
