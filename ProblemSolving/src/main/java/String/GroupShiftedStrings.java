package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * We can shift a string by shifting each of its letters to its successive
 * letter.
 * 
 * For example, "abc" can be shifted to be "bcd". We can keep shifting the
 * string to form a sequence.
 * 
 * For example, we can keep shifting "abc" to form the sequence: "abc" -> "bcd"
 * -> ... -> "xyz". Given an array of strings strings, group all strings[i] that
 * belong to the same shifting sequence. You may return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: strings = ["abc","bcd","acef","xyz","az","ba","a","z"] Output:
 * [["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]] Example 2:
 * 
 * Input: strings = ["a"] Output: [["a"]]
 *
 */

public class GroupShiftedStrings {

	// TC = Time complexity: O(N * K)O(N∗K)
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	char shiftLetter(char letter, int shift) {
		return (char) ((letter - shift + 26) % 26 + 'a');
	}

	// Create a hash value
	String getHash(String s) {
		char[] chars = s.toCharArray();

		// Calculate the number of shifts to make the first character to be 'a'
		int shift = chars[0];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = shiftLetter(chars[i], shift);
		}

		String hashKey = String.valueOf(chars);
		return hashKey;
	}

	public List<List<String>> groupStrings(String[] strings) {
		Map<String, List<String>> mapHashToList = new HashMap<>();

		for (String str : strings) {
			String hashKey = getHash(str);
			if (mapHashToList.get(hashKey) == null) {
				mapHashToList.put(hashKey, new ArrayList<>());
			}
			mapHashToList.get(hashKey).add(str);
		}

		// Iterate over the map, and add the values to groups
		List<List<String>> groups = new ArrayList<>();
		for (List<String> group : mapHashToList.values()) {
			groups.add(group);
		}

		return groups;
	}

}
