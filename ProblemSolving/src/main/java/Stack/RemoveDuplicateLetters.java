package Stack;

import java.util.Stack;

/**
 *
 * Given a string A consisting of lowercase English alphabets. Find and return
 * lexicographically smallest string B after removing duplicate letters from A
 * so that every letter appears once and only once.
 * 
 * Input Format
 * 
 * The only argument given is string A. Output Format
 * 
 * Return lexicographically smallest string B after removing duplicate letters
 * from A. Constraints
 * 
 * 1 <= length of the string <= 200000 A consists of lowercase English alphabets
 * only. For Example
 * 
 * Input 1: A = "cbacdcbc" Output 1: B = "acdb"
 * 
 * Input 2: A = "bcabc" Output 2: B = "abc"
 **/
public class RemoveDuplicateLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "zizizljrsh";
		System.out.println(solve(a));
	}

	public static String solve(String A) {
		int[] count = new int[26];
		int[] visited = new int[26];
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < A.length(); ++i) {
			count[A.charAt(i) - 'a']++;
		}

		for (int i = 0; i < A.length(); ++i) {
			char curr = A.charAt(i);
			
			//System.out.println("count = " + " " + i + " " +visited[curr - 'a']);
			if (visited[curr - 'a']++ > 0 && s.peek() >= curr) {
				System.out.println(curr + " " + i);
				continue;
			}
			while (!s.isEmpty() && s.peek() <= curr && count[s.peek() - 'a'] > 0) {
				System.out.println(curr + " " + i);
				visited[s.peek() - 'a'] = 0;
				s.pop();
			}
			// count[A.charAt(i) - 'a']--;
			// if (visited[A.charAt(i) - 'a']++ > 0)
			// continue;
			// while (!s.isEmpty() && s.peek() > A.charAt(i) && count[s.peek() - 'a'] > 0) {
			// visited[s.peek() - 'a'] = 0;
			// s.pop();
			// }
			s.push(curr);
			count[curr - 'a']--;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.size(); ++i) {
			sb.append(s.get(i));
		}
		return sb.toString();
	}

}
