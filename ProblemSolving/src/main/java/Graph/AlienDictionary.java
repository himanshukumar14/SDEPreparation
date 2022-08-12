package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * There is a new alien language which uses the latin alphabet. However, the
 * order among letters are unknown to you. You receive a list of non-empty words
 * from the dictionary, where words are sorted lexicographically by the rules of
 * this new language. Derive the order of letters in this language.
 * 
 * You may assume all letters are in lowercase. The dictionary is invalid, if
 * string a is prefix of string b and b is appear before a. If the order is
 * invalid, return an empty string. There may be multiple valid order of
 * letters, return the smallest in normal lexicographical order. The letters in
 * one string are of the same rank by default and are sorted in Human dictionary
 * order. Example Example 1:
 * 
 * Input：["wrt","wrf","er","ett","rftt"] Output："wertf" Explanation： from
 * "wrt"and"wrf" ,we can get 't'<'f' from "wrt"and"er" ,we can get 'w'<'e' from
 * "er"and"ett" ,we can get 'r'<'t' from "ett"and"rftt" ,we can get 'e'<'r' So
 * return "wertf"
 *
 */

public class AlienDictionary {

	public static String topologicalSortDFS(Map<Integer, List<Integer>> graph, Set<Character> charSet) {
		Set<Integer> visited = new HashSet<>();
		Stack<Integer> stack = new Stack<>();

		for (char c : charSet) {
			if (!visited.contains(c - 'a')) {
				dfs(c - 'a', visited, graph, stack);
			}
		}
		String ans = "";
		while (!stack.isEmpty()) {
			ans += (char) (stack.pop() + 'a');
		}
		return ans;
	}

	public static void dfs(int curr, Set<Integer> visited, Map<Integer, List<Integer>> graph, Stack<Integer> order) {
		visited.add(curr);

		List<Integer> list = graph.get(curr);
		if (list != null) {
			for (int adj : list) {
				if (!visited.contains(adj))
					dfs(adj, visited, graph, order);
			}
		}
		order.add(curr);
	}

	private static void findOrder(String[] words, int n) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < n - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];
			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					List<Integer> list = graph.getOrDefault(word1.charAt(j) - 'a', new ArrayList<>());
					list.add(word2.charAt(j) - 'a');
					graph.put(word1.charAt(j) - 'a', list);
					set.add(word1.charAt(j));
					set.add(word2.charAt(j));
					break;
				}
			}
		}

		System.out.println(topologicalSortDFS(graph, set));
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		String[] words1 = { "baa", "abcd", "abca", "cab", "cad" };
		String[] words2 = { "wrt", "wrf", "er", "ett", "rftt" };
		findOrder(words1, 5);
		findOrder(words2, 5);
	}
}
