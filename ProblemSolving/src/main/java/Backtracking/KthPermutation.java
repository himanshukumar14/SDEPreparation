package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getPermutation(int A, int B) {
		StringBuilder ans = new StringBuilder();
		List<Integer> l = new ArrayList<>();
		for (int i = 1; i <= A; ++i) {
			l.add(i);
		}
		
		while (A > 0) {
			int f = fact(A - 1);
			int rem = B % f;
			int quot = B / f;
			int y = rem == 0 ? quot : quot + 1;
			ans.append(l.get(y - 1));
			B = rem == 0 ? f : rem;
			l.remove(y - 1);
			A--;
		}
		return ans.toString();
	}

	public int fact(int num) {
		if (num > 12)
			return Integer.MAX_VALUE;
		
		int out = 1;
		while (num > 0) {
			out = out * num;
			num--;
		}
		return out;
	}
}
