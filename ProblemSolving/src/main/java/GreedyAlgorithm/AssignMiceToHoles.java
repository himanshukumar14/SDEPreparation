package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class AssignMiceToHoles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
		if (A == null || B == null)
			return 0;

		Collections.sort(A);
		Collections.sort(B);

		int max = 0;
		int n = A.size();

		for (int i = 0; i < n; i++) {
			max = Math.max(max, Math.abs(A.get(i) - B.get(i)));
		}

		return max;
	}
}
