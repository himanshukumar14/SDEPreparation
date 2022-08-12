package String;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isStrobogrammatic("09"));
	}

	public static boolean isStrobogrammatic(String num) {
		Map<Character, Character> map = new HashMap<>();
		map.put('6', '9');
		map.put('9', '6');
		map.put('8', '8');
		map.put('1', '1');
		map.put('0', '0');
		int n = num.length();
		int l = 0;
		int r = n - 1;

		while (l <= r) {
			char curr = num.charAt(l);
			if (!map.containsKey(curr))
				return false;

			if (map.get(curr) == num.charAt(r)) {
				l++;
				r--;
			} else {
				return false;
			}
		}
		return true;
	}
}
