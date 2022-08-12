package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CourseSchedule2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		Map<Integer, List<Integer>> graph = new HashMap<>();		

		for (int i = 0; i < prerequisites.length; ++i) {
			indegree[prerequisites[i][0]]++;
			List<Integer> list = graph.getOrDefault(prerequisites[i][1], new ArrayList<>());
			list.add(prerequisites[i][0]);
			graph.put(prerequisites[i][1], list);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a.compareTo(b);
			}
		});

		for (int i = 0; i < numCourses; ++i) {
			if (indegree[i] == 0)
				pq.add(i);
		}

		return bfs(numCourses, indegree, graph, pq);
	}

	public int[] bfs(int numCourses, int[] indegree, Map<Integer, List<Integer>> graph, PriorityQueue<Integer> pq) {
		int[] ans = new int[numCourses];
		int count = 0;
		while (!pq.isEmpty()) {
			int node = pq.poll();
			ans[count++] = node;

			List<Integer> temp = graph.get(node);
			if (temp != null) {
				for (int curr : temp) {
					indegree[curr]--;
					if (indegree[curr] == 0)
						pq.add(curr);
				}
			}
		}
		if (count != numCourses)
			return new int[] {};
		return ans;
	}

}
