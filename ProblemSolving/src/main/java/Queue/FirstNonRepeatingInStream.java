package Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingInStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] ans = firstNonRepeating("geeksforgeeksfor");
		for(int i = 0; i < ans.length; ++i) {
			System.out.println(ans[i]);
		}
	}

	public static char[] firstNonRepeating(String stream) {
		Queue<Character> queue = new LinkedList<>();
		Map<Character, Integer> map = new HashMap<>();
		char[] ans = new char[stream.length()];

		for (int i = 0; i < stream.length(); ++i) {
			char ch = stream.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			
			if (map.get(ch) > 1) {
				while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
					queue.poll();
				}
			} else {
				queue.add(ch);
			}
			ans[i] = queue.isEmpty() ? '-' : queue.peek();
			
		}
		return ans;
	}

}
