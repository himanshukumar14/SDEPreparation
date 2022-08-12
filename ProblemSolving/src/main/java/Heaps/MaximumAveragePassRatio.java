package Heaps;

import java.util.PriorityQueue;

/**
 * 
 * There is a school that has classes of students and each class will be having
 * a final exam. You are given a 2D integer array classes, where classes[i] =
 * [passi, totali]. You know beforehand that in the ith class, there are totali
 * total students, but only passi number of students will pass the exam.
 * 
 * You are also given an integer extraStudents. There are another extraStudents
 * brilliant students that are guaranteed to pass the exam of any class they are
 * assigned to. You want to assign each of the extraStudents students to a class
 * in a way that maximizes the average pass ratio across all the classes.
 * 
 * The pass ratio of a class is equal to the number of students of the class
 * that will pass the exam divided by the total number of students of the class.
 * The average pass ratio is the sum of pass ratios of all the classes divided
 * by the number of the classes.
 * 
 * Return the maximum possible average pass ratio after assigning the
 * extraStudents students. Answers within 10-5 of the actual answer will be
 * accepted.
 * 
 * Example 1:
 * 
 * Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2 Output: 0.78333
 * Explanation: You can assign the two extra students to the first class. The
 * average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333. Example
 * 2:
 * 
 * Input: classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4 Output:
 * 0.53485
 *
 */

public class MaximumAveragePassRatio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 *
	 * There are few incorrect approaches:
	 * 
	 * Choosing the smallest class size Choosing the smallest pass size Choosing the
	 * least pass ratio Instead, the correct approach is: Find the difference,
	 * namely the delta.
	 * 
	 * For example, even though 1/2 and 10/20 has the same ratio. However, 1/2‘s
	 * delta is equal to (1+1)/(2+1)-1/2, which is much greater than
	 * (10+1)/(20+1)-10/20.
	 * 
	 * Therefore, we always greedily select the one with the greatest delta.
	 * 
	 */

	public double getMaximumAverage(int[][] classes, int extraStudents) {
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (int) (b.delta - a.delta));
		int n = classes.length;
		for (int i = 0; i < n; ++i) {
			if (classes[i][0] == classes[i][1])
				continue;
			double delta = ((double) classes[i][0] + 1) / ((double) classes[i][1] + 1)
					- ((double) classes[i][0]) / ((double) classes[i][1]);
			pq.add(new Pair(delta, i));
		}

		while (!pq.isEmpty() && extraStudents > 0) {
			int i = pq.poll().index;
			classes[i][0]++;
			classes[i][1]++;
			double delta = ((double) classes[i][0] + 1) / ((double) classes[i][1] + 1)
					- ((double) classes[i][0]) / ((double) classes[i][1]);
			pq.add(new Pair(delta, i));
		}

		double ans = 0;
		for (int i = 0; i < n; ++i) {
			ans += (double) classes[i][0] / (double) classes[i][1];
		}

		return ans / (double) n;
	}

	class Pair {
		double delta;
		int index;

		Pair(double delta, int index) {
			this.delta = delta;
			this.index = index;
		}
	}
}
