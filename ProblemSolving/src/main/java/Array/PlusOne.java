package Array;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] plusOne(int[] digits) {
		int[] temp = add(digits, digits.length - 1);
		return temp;
	}

	public int[] add(int[] digits, int r) {
		if (digits[r] == 9) {
			if (r == 0) {
				int[] temp = new int[digits.length + 1];
				temp[0] = 1;
				//copy digit to temp
				return temp;
			}
			digits[r] = 0;
			int[] temp = add(digits, r - 1);
			return temp;
		} else {
			digits[r]++;
			return digits;
		}
	}

}
