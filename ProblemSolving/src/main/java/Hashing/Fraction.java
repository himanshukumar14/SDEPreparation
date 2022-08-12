package Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * Example :
 * 
 * Given numerator = 1, denominator = 2, return "0.5" Given numerator = 2,
 * denominator = 1, return "2" Given numerator = 2, denominator = 3, return
 * "0.(6)"
 *
 */

public class Fraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fractionToDecimal(0, -1));
	}

	public static String fractionToDecimal(int A, int B) {
		StringBuilder sb = new StringBuilder();
		Map<Long, Integer> set = new HashMap<>();

		String sign = (A < 0 && B < 0) || (A > 0 && B > 0) ? "" : "-";
		long div = A > 0 ? A : -1L * A;
		long dis = B > 0 ? B : -1L * B;
		String init = String.valueOf(div / dis);

		div = div % dis;
		boolean repeating = false;
		int index = -1;
		while (div != 0) {
			div = div * 10;
			if (set.containsKey(div)) {
				repeating = true;
				index = set.get(div);
				break;
			}
			set.put(div, sb.length());
			sb.append(div / dis);
			div = div % dis;
		}

		if (repeating) {
			return (sb.length() > 0 ? sign + init : init)
					+ (sb.length() > 0 ? ("." + sb.substring(0, index) + "(" + sb.substring(index, sb.length()) + ")")
							: "");
		} else {
			return (sb.length() > 0 ? sign + init : init) + (sb.length() > 0 ? ("." + sb.toString()) : "");
		}
	}

}
