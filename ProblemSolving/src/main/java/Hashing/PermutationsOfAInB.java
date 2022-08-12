package Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * You are given two strings, A and B, of size N and M, respectively.
 * 
 * You have to find the count of all permutations of A present in B as a
 * substring. You can assume a string will have only lowercase letters.
 * 
 * 
 * Problem Constraints 1 <= N < M <= 105
 * 
 * Input Format Given two arguments, A and B of type String.
 * 
 * Output Format Return a single integer, i.e., number of permutations of A
 * present in B as a substring.
 * 
 * Example Input Input 1:
 * 
 * A = "abc" B = "abcbacabc" Input 2:
 * 
 * A = "aca" B = "acaa"
 * 
 * 
 * Example Output Output 1:
 * 
 * 5 Output 2:
 * 
 * 2
 * 
 * Example Explanation Explanation 1:
 * 
 * Permutations of A that are present in B as substring are: 1. abc 2. cba 3.
 * bac 4. cab 5. abc So ans is 5. Explanation 2:
 * 
 * Permutations of A that are present in B as substring are: 1. aca 2. caa
 *
 */

public class PermutationsOfAInB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abc";
		String b = "abcbacabc";
		System.out.println(solve(a, b));
	}

	public static int solve(String A, String B) {
		Map<Character, Integer> Amap = new HashMap<>();
		Map<Character, Integer> Bmap = new HashMap<>();

		for (int i = 0; i < A.length(); i++)
			Amap.put(A.charAt(i), Amap.getOrDefault(A.charAt(i), 0) + 1);
		int alen = A.length();
		int blen = B.length();

		int i = 0;
		int j = 0;
		int ans = 0;
		while (j < blen) {
			char curr = B.charAt(j);
			if (Amap.containsKey(curr) && (!Bmap.containsKey(curr) || Bmap.get(curr) < Amap.get(curr))) {
				Bmap.put(curr, Bmap.getOrDefault(curr, 0) + 1);
				if (j - i + 1 == alen)
					ans++;
				j++;
			} else if (Amap.containsKey(curr)) {
				Bmap.put(curr, Bmap.getOrDefault(curr, 0) + 1);
				while (i <= j && B.charAt(i) != B.charAt(j)) {
					Bmap.put(B.charAt(i), Bmap.getOrDefault(B.charAt(i), 0) - 1);
					if (Bmap.get(B.charAt(i)) == 0)
						Bmap.remove(B.charAt(i));
					i++;
				}
				Bmap.put(B.charAt(i), Bmap.getOrDefault(B.charAt(i), 0) - 1);
				if (Bmap.get(B.charAt(i)) == 0)
					Bmap.remove(B.charAt(i));
				i++;
				if (j - i + 1 == alen)
					ans++;
				j++;
			} else {
				Bmap.clear();
				j++;
				i = j;
			}
		}
		return ans;
	}

	// --------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public int solve2(String A, String B) {
		int[] Amap = new int[26];
		int[] Bmap = new int[26];
		for (int i = 0; i < A.length(); i++) {
			Amap[A.charAt(i) - 'a']++;
			Bmap[B.charAt(i) - 'a']++;
		}
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (Amap[i] == Bmap[i])
				count++;
		}
		int n = A.length();

		int ans = 0;
		for (int i = 0; i < B.length() - A.length(); i++) {
			int r = B.charAt(i + n) - 'a', l = B.charAt(i) - 'a';
			if (count == 26)
				ans++;
			Bmap[r]++;
			if (Bmap[r] == Amap[r])
				count++;
			else if (Bmap[r] == Amap[r] + 1)
				count--;
			Bmap[l]--;
			if (Bmap[l] == Amap[l])
				count++;
			else if (Bmap[l] == Amap[l] - 1)
				count--;
		}
		if (count == 26)
			ans++;
		return ans;
	}
}
