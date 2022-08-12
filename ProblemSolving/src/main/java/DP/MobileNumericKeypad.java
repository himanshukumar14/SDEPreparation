package DP;

import java.util.HashMap;
import java.util.Map;

public class MobileNumericKeypad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getCount(25));
	}

	public static long getCount(int n) {
		map = new HashMap<>();
		map.put(0, new int[] { 0, 8 });
		map.put(1, new int[] { 1, 2, 4 });
		map.put(2, new int[] { 2, 1, 3, 5 });
		map.put(3, new int[] { 3, 2, 6 });
		map.put(4, new int[] { 4, 1, 7, 5 });
		map.put(5, new int[] { 5, 2, 4, 6, 8 });
		map.put(6, new int[] { 6, 3, 5, 9 });
		map.put(7, new int[] { 7, 4, 8 });
		map.put(8, new int[] { 8, 5, 7, 9, 0 });
		map.put(9, new int[] { 9, 6, 8 });
		mem = new long[10][n + 1];
		if (n == 1)
			return 10;
		long ans = 0;
		for (int i = 0; i < 10; ++i) {
			ans += recur(n - 1, i);
		}
		return ans;
	}

	public static Map<Integer, int[]> map = null;
	public static long[][] mem;

	public static long recur(int n, int last) {
		if (n == 0)
			return 1;
		if (mem[last][n] > 0)
			return mem[last][n];
		long count = 0;
		int[] possible = map.get(last);
		for (int i = 0; i < possible.length; ++i) {
			count += recur(n - 1, possible[i]);
		}
		mem[last][n] = count;
		return count;
	}

}
