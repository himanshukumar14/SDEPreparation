package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Given a string s and a dictionary of strings wordDict, add spaces in s to
 * construct a sentence where each word is a valid dictionary word. Return all
 * such possible sentences in any order.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the
 * segmentation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"] Output:
 * ["cats and dog","cat sand dog"] Example 2:
 * 
 * Input: s = "pineapplepenapple", wordDict =
 * ["apple","pen","applepen","pine","pineapple"] Output: ["pine apple pen
 * apple","pineapple pen apple","pine applepen apple"] Explanation: Note that
 * you are allowed to reuse a dictionary word. Example 3:
 * 
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"] Output:
 * []
 *
 */

public class WordBreak2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> dict = new ArrayList<>();
		dict.add("apple");
		dict.add("pen");
		dict.add("applepen");
		dict.add("pine");
		dict.add("pineapple");
		List<String> l = wordBreak("pineapplepenapple", dict);
		for(String x : l) {
			System.out.println(x);
		}
	}

	public static List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>(wordDict);
		return recur(0, s.length() - 1, s, dict);
	}

	static Map<String, List<String>> mem = new HashMap<>();

	public static List<String> recur(int l, int r, String word, Set<String> dict) {
		List<String> res = new ArrayList<>();
		if (mem.containsKey(word.substring(l, r + 1)))
			return mem.get(word.substring(l, r + 1));
		if (dict.contains(word.substring(l, r + 1))) {
			res.add(word.substring(l, r + 1));
		}

		for(int k = l; k < r; ++k) {
            if(dict.contains(word.substring(l, k + 1))) {
                List<String> b = recur(k + 1, r, word, dict);
                if(b.size() != 0) {
                    for(int j = 0 ; j < b.size() ; j++) {
                        res.add(word.substring(l, k + 1) + " " + b.get(j));
                    }
                }
            }
        }
		mem.put(word.substring(l, r + 1), res);
		return res;
	}

}
