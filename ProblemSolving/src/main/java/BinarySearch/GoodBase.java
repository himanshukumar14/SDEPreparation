package BinarySearch;

import java.math.BigInteger;

/**
 * 
 * Given an integer A, we call k >= 2 a good base of A, if all digits of A base
 * k are 1. Now given a string representing A, you should return the smallest
 * good base of A in string format.
 * 
 * 
 * Input Format
 * 
 * The only argument given is the string representing A. Output Format
 * 
 * Return the smallest good base of A in string format. Constraints
 * 
 * 3 <= A <= 10^18 For Example
 * 
 * Input 1: A = "13" Output 1: "3" (13 in base 3 is 111)
 * 
 * Input 2: A = "4681" Output 2: "8" (4681 in base 8 is 11111).
 *
 * 
 * 
 */

public class GoodBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solve(String A) {
		int c = 0;
		long n = Long.valueOf(A);
		long num = Long.valueOf(A);
		while (n != 0) {
			n = n >> 1;
			c++;
		}

		for (int i = c; i >= 2; --i) {
			long min = 2;
			long max = num - 1;

			while (min <= max) {
				long mid = min + ((max - min) / 2);
				BigInteger left = BigInteger.valueOf(mid);
				left = left.pow(i).subtract(BigInteger.ONE);
				BigInteger right = BigInteger.valueOf(num).multiply(BigInteger.valueOf(mid).subtract(BigInteger.ONE));
				int cmr = left.compareTo(right);
				if (cmr == 0) {
					return "" + mid;
				} else if (cmr < 0) {
					min = mid + 1;
				} else {
					max = mid - 1;
				}
			}
		}
		return "0";
	}

}
