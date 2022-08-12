package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * A transformation sequence from word beginWord to word endWord using a
 * dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk
 * such that:
 * 
 * Every adjacent pair of words differs by a single letter. Every si for 1 <= i
 * <= k is in wordList. Note that beginWord does not need to be in wordList. sk
 * == endWord Given two words, beginWord and endWord, and a dictionary wordList,
 * return all the shortest transformation sequences from beginWord to endWord,
 * or an empty list if no such sequence exists. Each sequence should be returned
 * as a list of the words [beginWord, s1, s2, ..., sk].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"] Output:
 * [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * Explanation: There are 2 shortest transformation sequences: "hit" -> "hot" ->
 * "dot" -> "dog" -> "cog" "hit" -> "hot" -> "lot" -> "log" -> "cog" Example 2:
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log"] Output: [] Explanation: The endWord "cog" is
 * not in wordList, therefore there is no valid transformation sequence.
 *
 */

public class WordLadder2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> dictionary = new HashSet<>(wordList);
		if (!dictionary.contains(endWord))
			return new ArrayList<>();
		return bfs(beginWord, endWord, dictionary);
	}

	public List<List<String>> bfs(String start, String end, Set<String> dictionary) {
		Queue<SequenceList> queue = new LinkedList<>();
		List<List<String>> ans = new ArrayList<>();
		boolean endFound = false;

		queue.add(new SequenceList(start, new ArrayList<>()));
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (endFound)
				return ans;

			for (int k = 0; k < size; ++k) {
				SequenceList curr = queue.poll();
				dictionary.remove(curr.word);
				curr.path.add(curr.word);

				if (curr.word.equals(end)) {
					endFound = true;
					ans.add(new ArrayList<>(curr.path));
				}

				char[] currArr = curr.word.toCharArray();
				for (int i = 0; i < currArr.length; ++i) {
					char old = currArr[i];
					for (char next = 'a'; next <= 'z'; ++next) {
						currArr[i] = next;
						String nextSeq = String.valueOf(currArr);
						if (dictionary.contains(nextSeq)) {
							queue.add(new SequenceList(nextSeq, curr.path));
						}
						currArr[i] = old;
					}
				}
			}
		}
		return ans;
	}

	public class SequenceList {
		String word;
		List<String> path;

		public SequenceList(String word, List<String> oldList) {
			this.word = word;
			if (oldList.size() == 0)
				this.path = new ArrayList<>();
			else
				this.path = new ArrayList<>(oldList);
		}
	}
}
