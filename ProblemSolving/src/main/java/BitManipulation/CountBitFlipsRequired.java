package BitManipulation;

public class CountBitFlipsRequired {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * 1. Calculate XOR of A and B.
	 * 
	 * a_xor_b = A ^ B
	 * 
	 * 2. Count the set bits in the above
	 * 
	 * calculated XOR result.
	 * 
	 * countSetBits(a_xor_b)
	 * 
	 */

	public int countSetBits(int n) {
		int count = 0;
		while (n > 0) {
			count++;
			n &= (n - 1);
		}
		return count;
	}

	public int FlippedCount(int a, int b) {
		return countSetBits(a ^ b);
	}

}
