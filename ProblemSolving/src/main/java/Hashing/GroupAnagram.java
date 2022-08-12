package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]] 
 */

public class GroupAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> ans = new ArrayList<>();
		Map<String, List<String>> m = new HashMap<>();
		int n = strs.length;

		for (int i = 0; i < n; ++i) {
			String hash = getHash(strs[i]);
			List<String> temp = m.getOrDefault(hash, new ArrayList<String>());
			temp.add(strs[i]);
			m.put(hash, temp);
		}

		for (List<String> val : m.values()) {
			ans.add(val);
		}
		return ans;
	}

	public String getHash(String input) {
		int[] mem = new int[26];
		for (int i = 0; i < input.length(); ++i)
			mem[input.charAt(i) - 'a']++;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; ++i) {
			if (mem[i] > 0) {
				sb.append("#");
				sb.append(i + "," + mem[i]);
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

}
