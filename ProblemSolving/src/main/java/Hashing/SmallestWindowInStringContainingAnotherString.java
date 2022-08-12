package Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string A and a string B, find the window with minimum length in A,
 * which will contain all the characters in B in linear time complexity. Note
 * that when the count of a character c in B is x, then the count of c in the
 * minimum window in A should be at least x.
 * 
 * Note:
 * 
 * If there is no such window in A that covers all characters in B, return the
 * empty string. If there are multiple such windows, return the first occurring
 * minimum window ( with minimum start index and length )
 * 
 * 
 * Problem Constraints 1 <= size(A), size(B) <= 106
 * 
 * 
 * 
 * Input Format The first argument is a string A. The second argument is a
 * string B.
 * 
 * 
 * 
 * Output Format Return a string denoting the minimum window.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = "ADOBECODEBANC" B = "ABC" Input 2:
 * 
 * A = "Aa91b" B = "ab"
 * 
 * 
 * Example Output Output 1:
 * 
 * "BANC" Output 2:
 * 
 * "a91b"
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * "BANC" is a substring of A which contains all characters of B. Explanation 2:
 * 
 * "a91b" is the substring of A which contains all characters of B.
 *
 */

public class SmallestWindowInStringContainingAnotherString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "geeksforgeeks";
		String pattern = "ork";
		System.out.println(check(word, pattern));
	}

	public static String check(String word, String pattern) {
		int plen = pattern.length();
		int wlen = word.length();
		if (wlen < plen)
			return "";

		Map<Character, Integer> patMap = new HashMap<>();
		for (int i = 0; i < plen; ++i)
			patMap.put(pattern.charAt(i), patMap.getOrDefault(pattern.charAt(i), 0) + 1);

		Map<Character, Integer> wordMap = new HashMap<>();
		int i = 0;
		int j = 0;
		int count = 0;
		int minLen = Integer.MAX_VALUE;
		int begin = -1;
		int end = -1;

		while (i < wlen) {
			char curr = word.charAt(i);
			wordMap.put(curr, wordMap.getOrDefault(curr, 0) + 1);
			if (patMap.containsKey(curr) && (!wordMap.containsKey(curr) || wordMap.get(curr) < patMap.get(curr)))
				count++;
			
			while (count == plen) {
				char start = word.charAt(j);
				if (minLen > i - j + 1) {
					minLen = i - j + 1;
					begin = j;
					end = i;
				}

				if (patMap.containsKey(start) && wordMap.get(start) == patMap.get(start))
					count--;

				wordMap.put(start, wordMap.getOrDefault(start, 0) - 1);
				if (wordMap.get(start) == 0)
					wordMap.remove(start);
				j++;
			}
			i++;
		}
		if (begin == -1 || end == -1)
			return "";
		return word.substring(begin, end + 1);
	}

}
