package BitManipulation;

public class PowerOfTwo {

	public static boolean isPowerOfTwo(int n) {
		if (n == 0)
			return false;

		return (int) (Math.ceil((Math.log(n) / Math.log(2)))) == (int) (Math.floor(((Math.log(n) / Math.log(2)))));
	}

	/**
	 * 
	 * If we subtract a power of 2 numbers by 1 then all unset bits after the only
	 * set bit become set; and the set bit becomes unset. For example for 4 ( 100)
	 * and 16(10000), we get the following after subtracting 1 3 --> 011 15 -->
	 * 01111
	 * 
	 * 
	 * 
	 * 
	 * So, if a number n is a power of 2 then bitwise & of n and n-1 will be zero.
	 * We can say n is a power of 2 or not based on the value of n&(n-1). The
	 * expression n&(n-1) will not work when n is 0. To handle this case also, our
	 * expression will become n& (!n&(n-1)) (thanks to
	 * https://www.geeksforgeeks.org/program-to-find-whether-a-no-is-power-of-two/Mohammad
	 * for adding this case).
	 * 
	 */

	public static boolean isPowerOfTwo1(int x) {
		return x != 0 && ((x & (x - 1)) == 0);

	}

}
