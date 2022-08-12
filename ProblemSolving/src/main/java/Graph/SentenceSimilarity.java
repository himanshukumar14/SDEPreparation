package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Given two sentences words1, words2 (each represented as an array of strings),
 * and a list of similar word pairs pairs, determine if two sentences are
 * similar.
 * 
 * For example, words1 = great acting skills and words2 = fine drama talent are
 * similar, if the similar word pairs are pairs = [["great", "fine"],
 * ["acting","drama"], ["skills","talent"]].
 * 
 * Note that the similarity relation is not transitive. For example, if "great"
 * and "fine" are similar, and "fine" and "good" are similar, "great" and "good"
 * are not necessarily similar.
 * 
 * However, similarity is symmetric. For example, "great" and "fine" being
 * similar is the same as "fine" and "great" being similar.
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

public class SentenceSimilarity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words1 = new String[] { "fine", "skills", "acting" };
		String[] words2 = new String[] { "fine", "drama", "talent" };
		List<List<String>> pairs = new ArrayList<>();
		List<String> l1 = new ArrayList<>();
		l1.add("great");
		l1.add("fine");
		pairs.add(l1);
		l1 = new ArrayList<>();
		l1.add("drama");
		l1.add("acting");
		pairs.add(l1);
		l1 = new ArrayList<>();
		l1.add("skills");
		l1.add("talent");
		pairs.add(l1);
		System.out.println(isSentenceSimilarity(words1, words2, pairs));
	}

	public static boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
		// write your code here
		int n = words1.length;
		int m = words2.length;
		if (n != m)
			return false;
		Map<String, Set<String>> edge = new HashMap<>();
		for (List<String> pair : pairs) {
			Set<String> l = edge.getOrDefault(pair.get(0), new HashSet<>());
			l.add(pair.get(1));
			l.add(pair.get(0));
			edge.put(pair.get(0), l);
			l = edge.getOrDefault(pair.get(1), new HashSet<>());
			l.add(pair.get(0));
			l.add(pair.get(1));
			edge.put(pair.get(1), l);
		}
		int count = 0;
		for (int i = 0; i < n; ++i) {
			String first = words1[i];
			String second = words2[i];
			if (edge.containsKey(first) && edge.get(first).contains(second)) {
				count++;
			}
		}
		return count == n;
	}
}
