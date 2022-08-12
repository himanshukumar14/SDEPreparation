package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Time Complexity :- BigO(M^2 * N), where M is size of dequeued word & N is
 * size of our word list
 * 
 * Space Complexity :- BigO(M * N) where M is no. of character that we had in
 * our string & N is the size of our wordList.
 *
 */

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int wordLadder(String start, String end, List<String> dict) {
		Set<String> set = new HashSet<>(dict);
		if (!set.contains(end))
			return 0;
		return bfs(start, end, set);
	}

	//TC = O(M^2 * N)
	public int bfs(String start, String end, Set<String> dict) {
		Queue<String> queue = new LinkedList<>();
		// instead of maintaining a visited set , just remove it from your word list
		// presence set
		int count = 1;
		queue.add(start);

		while (!queue.isEmpty()) {  // O(N)  N = elements in list
			int size = queue.size();
			for (int k = 0; k < size; ++k) {
				String curr = queue.poll();
				dict.remove(curr); //will help to mark as visited
				if (curr.equals(end))
					return count;
				char[] currArr = curr.toCharArray();
				for (int i = 0; i < curr.length(); ++i) { // O(M) M = length of string
					String str = null;
					char temp = currArr[i];
					for (char ch = 'a'; ch <= 'z'; ++ch) { // O(26)
						currArr[i] = ch;
						str = String.valueOf(currArr);  // O(M)
						if (dict.contains(str)) {
							queue.add(str);
						}
						currArr[i] = temp;
					}
				}
			}
			count++;
		}
		return 0;
	}

}
