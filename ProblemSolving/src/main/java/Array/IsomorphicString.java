package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Two strings str1 and str2 are called isomorphic if there is a one-to-one
 * mapping possible for every character of str1 to every character of str2. And
 * all occurrences of every character in ‘str1’ map to the same character in
 * ‘str2’.
 * 
 * Examples:
 * 
 * Input: str1 = "aab", str2 = "xxy" Output: True 'a' is mapped to 'x' and 'b'
 * is mapped to 'y'.
 * 
 * Input: str1 = "aab", str2 = "xyz" Output: False One occurrence of 'a' in str1
 * has 'x' in str2 and other occurrence of 'a' has 'y'.
 *
 */

public class IsomorphicString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isIsomorphic(String s, String t) {
		if (s == null || s.length() <= 1)
			return true;
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			char b = t.charAt(i);
			if (map.containsKey(a)) {
				if (map.get(a).equals(b))
					continue;
				else
					return false;
			} else {
				if (!map.containsValue(b))
					map.put(a, b);
				else
					return false;
			}
		}
		return true;
	}

}
