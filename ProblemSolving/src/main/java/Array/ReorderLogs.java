package Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * You are given an array of logs. Each log is a space-delimited string of
 * words, where the first word is the identifier.
 * 
 * There are two types of logs:
 * 
 * Letter-logs: All words (except the identifier) consist of lowercase English
 * letters. Digit-logs: All words (except the identifier) consist of digits.
 * Reorder these logs so that:
 * 
 * The letter-logs come before all digit-logs. The letter-logs are sorted
 * lexicographically by their contents. If their contents are the same, then
 * sort them lexicographically by their identifiers. The digit-logs maintain
 * their relative ordering. Return the final order of the logs.
 * 
 * Example 1:
 * 
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit
 * dig","let3 art zero"] Output: ["let1 art can","let3 art zero","let2 own kit
 * dig","dig1 8 1 5 1","dig2 3 6"] Explanation: The letter-log contents are all
 * different, so their ordering is "art can", "art zero", "own kit dig". The
 * digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6". Example 2:
 * 
 * Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act
 * zoo"] Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4
 * 4 7"] Constraints:
 * 
 * 1 <= logs.length <= 100 3 <= logs[i].length <= 100 All the tokens of logs[i]
 * are separated by a single space. logs[i] is guaranteed to have an identifier
 * and at least one word after the identifier.
 *
 * 
 */

public class ReorderLogs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public String[] reorder(String[] logs) {
		int n = logs.length;
		int pivot = n - 1;
		for (int i = n - 1; i >= 0; --i) {
			if (isDigitLog(logs[i])) {
				String temp = logs[pivot];
				logs[pivot] = logs[i];
				logs[i] = temp;
				pivot--;
			}
		}

		if (pivot >= 0)
			Arrays.sort(logs, 0, pivot + 1, new Comparator<String>() {
				public int compare(String a, String b) {
					int index1 = a.indexOf(" ");
					int index2 = b.indexOf(" ");
					int comp = a.substring(index1 + 1).compareTo(b.substring(index2 + 1));

					if (comp == 0)
						comp = a.substring(0, index1).compareTo(b.substring(0, index2));

					return comp;
				}
			});
		return logs;
	}

	public boolean isDigitLog(String word) {
		int i = 0;
		while (word.charAt(i) != ' ') {
			i++;
		}
		i++;
		return Character.isDigit(word.charAt(i));
	}
}
