package BitManipulation;

/**
 * 
 * Given a number N having only one ‘1’ and all other ’0’s in its binary
 * representation, find position of the only set bit. If there are 0 or more
 * than 1 set bit the answer should be -1. Position of set bit '1' should be
 * counted starting with 1 from the LSB side in the binary representation of the
 * number.
 * 
 */

public class FindPositionOfSetBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isPowerOfTwo(int n) {
		return (n > 0 && ((n & (n - 1)) == 0)) ? true : false;
	}

	/**
	 * 
	 * 
	 * The idea is to start from the rightmost bit and one by one check value of
	 * every bit. Following is a detailed algorithm. 1) If number is power of two
	 * then and then only its binary representation contains only one '1'. That's
	 * why check whether the given number is a power of 2 or not. If given number is
	 * not a power of 2, then print error message and exit. 2) Initialize two
	 * variables; i = 1 (for looping) and pos = 1 (to find position of set bit) 3)
	 * Inside loop, do bitwise AND of i and number 'N'. If value of this operation
	 * is true, then "pos" bit is set, so break the loop and return position.
	 * Otherwise, increment "pos" by 1 and left shift i by 1 and repeat the
	 * procedure.
	 * 
	 * 
	 */

	public static int findPosition(int n) {
		if (!isPowerOfTwo(n))
			return -1;
		int count = 0;
		
		while (n > 0) {
			n = n >> 1;
			++count;
		}
		
		return count;
	}

}
