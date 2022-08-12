package Array;

/**
 * 
 * As part of a Day 1 Challenge, your new team at Amazon has created a basic
 * alphabet-based encryption and has asked members to test the cipher. A simple
 * cipher is built on the alphabet wheel which has uppercase english
 * letters[‘A’-‘Z’] written on it:
 * 
 * Given an encrypted string consisting of english letters[‘A’-‘Z’] only,
 * decrypt the string by replacing each character with the kth character away on
 * the wheel in counter clockwise direction. Counter-clockwise is the opposite
 * direction is which the hands on a clock usually move.
 * 
 * Input encryped: a string k: an integer Output the decrypted string
 * 
 * Examples Example 1: Input:
 * 
 * 1encryped = VTAOG 2k = 2
 * 
 * Output: TRYME
 * 
 * Explanation:
 * 
 * Looking back 2 from ‘V’ returns ‘T’, from ‘T’ returns ‘R’ and so on. The
 * decrypted string is ‘TRYME’.
 *
 * 
 * 
 */

public class SimpleCypher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(decypher("VTAOG", 2));
	}

	public static String decypher(String cypher, int k) {
		int n = cypher.length();
		char[] chArr = cypher.toCharArray();

		for (int i = 0; i < n; ++i) {
			int x = chArr[i] - 'A';
			System.out.println(x);
			if (x - k < 0) {
				x = x + (25 - k + 1);
			} else {
				x = x - k;
			}

			chArr[i] = (char) ('A' + x);
		}
		return String.valueOf(chArr);
	}

}
