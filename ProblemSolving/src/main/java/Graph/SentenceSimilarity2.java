package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Given two sentences words1, words2 (each represented as an array of strings),
 * and a list of similar word pairs pairs, determine if two sentences are
 * similar.
 * 
 * For example, words1 = ["great", "acting", "skills"] and words2 = ["fine",
 * "drama", "talent"] are similar, if the similar word pairs are pairs =
 * [["great", "good"], ["fine", "good"], ["acting","drama"],
 * ["skills","talent"]].
 * 
 * Note that the similarity relation is transitive. For example, if “great” and
 * “good” are similar, and “fine” and “good” are similar, then “great” and
 * “fine” are similar.
 * 
 * Similarity is also symmetric. For example, “great” and “fine” being similar
 * is the same as “fine” and “great” being similar.
 * 
 * Also, a word is always similar with itself. For example, the sentences words1
 * = ["great"], words2 = ["great"], pairs = [] are similar, even though there
 * are no specified similar word pairs.
 * 
 * Finally, sentences can only be similar if they have the same number of words.
 * So a sentence like words1 = ["great"] can never be similar to words2 =
 * ["doubleplus","good"].
 *
 */

public class SentenceSimilarity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words1 = new String[] { "A", "B", "C" };
		String[] words2 = new String[] { "D", "E", "F" };
		String[][] pairs = new String[][] { { "A", "G" }, { "D", "G" }, { "B", "E" }, { "C", "F" } };
		System.out.println(areSentencesSimilarTwo2(words1, words2, pairs));
	}

	// Using DFS
	public static boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length)
			return false;

		Map<String, Set<String>> edges = new HashMap<>();
		for (String[] pair : pairs) {
			Set<String> l = edges.getOrDefault(pair[0], new HashSet<String>());
			l.add(pair[1]);
			l.add(pair[0]);
			edges.put(pair[0], l);

			l = edges.getOrDefault(pair[1], new HashSet<String>());
			l.add(pair[0]);
			l.add(pair[1]);
			edges.put(pair[1], l);
		}

		for (int i = 0; i < words1.length; i++) {
			if (words1[i].equals(words2[i]))
				continue;

			if (!edges.containsKey(words1[i]) || !edges.containsKey(words2[i]))
				return false;

			if (!dfs(words1[i], words2[i], edges, new HashSet<>()))
				return false;
		}
		return true;
	}

	public static boolean dfs(String source, String target, Map<String, Set<String>> pairMap, Set<String> visited) {
		if (pairMap.get(source).contains(target))
			return true;

		visited.add(source);
		for (String next : pairMap.get(source)) {
			if (!visited.contains(next))
				return dfs(next, target, pairMap, visited);
		}
		return false;
	}
	
	//-------------------------------------------------------------------------------------------------------------

	// DSU
	public static boolean areSentencesSimilarTwo2(String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length)
			return false;
		Map<String, Integer> mapping = new HashMap<>();
		int n = 0;
		for (String[] pair : pairs) {
			if (!mapping.containsKey(pair[0]))
				mapping.put(pair[0], n++);
			if (!mapping.containsKey(pair[1]))
				mapping.put(pair[1], n++);
		}
		DisjointSetUnion[] set = new DisjointSetUnion[n];
		for (int i = 0; i < n; ++i) {
			set[i] = new DisjointSetUnion(i, 0);
		}

		for (String[] pair : pairs) {
			int x = mapping.get(pair[0]);
			int y = mapping.get(pair[1]);

			int xf = DisjointSetUnion.find(set, x);
			int yf = DisjointSetUnion.find(set, y);
			if (xf != yf)
				DisjointSetUnion.union(set, xf, yf);
		}

		for (int i = 0; i < words1.length; i++) {
			if (words1[i].equals(words2[i]))
				continue;
			int x = mapping.get(words1[i]);
			int y = mapping.get(words2[i]);

			int xf = DisjointSetUnion.find(set, x);
			int yf = DisjointSetUnion.find(set, y);
			if (xf != yf)
				return false;
		}
		return true;
	}

	public static void union(DisjointSetUnion[] set, int x, int y) {
		int xparent = find(set, x);
		int yparent = find(set, y);
		if (xparent == yparent)
			return;
		if (set[xparent].rank > set[yparent].rank) {
			set[yparent].parent = xparent;
			set[xparent].rank += set[yparent].rank;
		} else {
			set[xparent].parent = yparent;
			set[yparent].rank += set[xparent].rank;
		}
	}

	public static int find(DisjointSetUnion[] set, int x) {
		if (set[x].parent == x)
			return x;
		return set[x].parent = find(set, set[x].parent);
	}

}
