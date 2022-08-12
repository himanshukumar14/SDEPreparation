package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given an array of strings words representing an English Dictionary, return
 * the longest word in words that can be built one character at a time by other
 * words in words.
 * 
 * If there is more than one possible answer, return the longest word with the
 * smallest lexicographical order. If there is no answer, return the empty
 * string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["w","wo","wor","worl","world"] Output: "world" Explanation:
 * The word "world" can be built one character at a time by "w", "wo", "wor",
 * and "worl". Example 2:
 * 
 * Input: words = ["a","banana","app","appl","ap","apply","apple"] Output:
 * "apple" Explanation: Both "apply" and "apple" can be built from other words
 * in the dictionary. However, "apple" is lexicographically smaller than
 * "apply".
 *
 */

public class LongestWordInDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String longestWord(String[] words) {
		Set<String> dict = new HashSet<>();

		for (String word : words)
			dict.add(word);

		Arrays.sort(words, (a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());

		for (String word : words) {
			boolean good = true;
			for (int k = 1; k < word.length(); ++k) {
				if (!dict.contains(word.substring(0, k))) {
					good = false;
					break;
				}
			}
			if (good)
				return word;
		}
		return "";
	}

}
