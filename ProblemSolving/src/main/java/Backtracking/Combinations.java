package Backtracking;

import java.util.ArrayList;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> combine(int A, int B) {
		ArrayList<Integer> l = new ArrayList<>();
		recur(A, B, l, 1);
		return ans;
	}

	public void recur(int A, int B, ArrayList<Integer> l, int start) {
		if (l.size() == B) {
			ans.add(new ArrayList<Integer>(l));
		}
		for (int i = start; i <= A; ++i) {
			if (l.size() < B) {
				l.add(i);
				recur(A, B, l, i + 1);
				l.remove(l.size() - 1);
			}
		}
	}
}
