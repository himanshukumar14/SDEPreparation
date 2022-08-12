package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * Given a string with repeated characters, the task is to rearrange characters
 * in a string so that no two adjacent characters are same. Note : It may be
 * assumed that the string has only lowercase English alphabets.
 * 
 * Examples:
 * 
 * Input: aaabc Output: abaca
 * 
 * Input: aaabb Output: ababa
 * 
 * Input: aa Output: Not Possible
 * 
 * Input: aaaabc Output: Not Possible
 *
 */

public class RearrangeCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void rearrangeString(String str) {
		int n = str.length();

		int[] count = new int[26];

		for (int i = 0; i < n; i++)
			count[str.charAt(i) - 'a']++;

		PriorityQueue<Key> pq = new PriorityQueue<>(new Comparator<Key>() {
			public int compare(Key a, Key b) {
				return b.count - a.count;
			}
		});

		for (char c = 'a'; c <= 'z'; c++) {
			int val = c - 'a';
			if (count[val] > 0)
				pq.add(new Key(count[val], c));
		}

		str = "";
		Key prev = new Key(-1, '#');

		while (pq.size() != 0) {
			Key k = pq.poll();
			str = str + k.ch;
			if (prev.count > 0)
				pq.add(prev);

			k.count--;
			prev = k;
		}

		if (n != str.length())
			System.out.println(" Not valid String ");
		else
			System.out.println(str);
	}

	static class Key {
		int count;
		char ch;

		Key(int count, char ch) {
			this.ch = ch;
			this.count = count;
		}
	}
}
