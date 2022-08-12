package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * There are a total of A courses you have to take, labeled from 1 to A.
 * 
 * Some courses may have prerequisites, for example to take course 2 you have to
 * first take course 1, which is expressed as a pair: [1,2].
 * 
 * So you are given two integer array B and C of same size where for each i
 * (B[i], C[i]) denotes a pair.
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * Return 1 if it is possible to finish all the courses, or 0 if it is not
 * possible to finish all the courses.
 *
 */

public class CanFinishTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int A, int[] B, int[] C) {
		int[] indegree = new int[A + 1];
		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int i = 0; i < C.length; ++i) {
			indegree[C[i]]++;
			List<Integer> list = graph.getOrDefault(B[i], new ArrayList<>());
			list.add(C[i]);
			graph.put(B[i], list);
		}

		Queue<Integer> pq = new LinkedList<>();

		for (int i = 1; i < A + 1; ++i) {
			if (indegree[i] == 0)
				pq.add(i);
		}
		return bfs(A, pq, graph, indegree);
	}

	public int bfs(int A, Queue<Integer> pq, Map<Integer, List<Integer>> graph, int[] indegree) {
		int count = 0;
		while (!pq.isEmpty()) {
			int node = pq.poll();
			count++;

			List<Integer> temp = graph.get(node);
			if (temp != null) {
				for (int curr : temp) {
					indegree[curr]--;
					if (indegree[curr] == 0)
						pq.add(curr);
				}
			}
		}
		if (count != A)
			return 0;
		return 1;
	}

}
