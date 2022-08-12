package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
 * [ai, bi] indicates that you must take course ai first if you want to take
 * course bi.
 * 
 * For example, the pair [0, 1] indicates that you have to take course 0 before
 * you can take course 1. Prerequisites can also be indirect. If course a is a
 * prerequisite of course b, and course b is a prerequisite of course c, then
 * course a is a prerequisite of course c.
 * 
 * You are also given an array queries where queries[j] = [uj, vj]. For the jth
 * query, you should answer whether course uj is a prerequisite of course vj or
 * not.
 * 
 * Return a boolean array answer, where answer[j] is the answer to the jth
 * query.
 *
 */

public class CourseSchedule4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
		int n = prerequisites.length;
		int[] indegree = new int[numCourses];
		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int i = 0; i < n; ++i) {
			indegree[prerequisites[i][1]]++;
			List<Integer> l = graph.getOrDefault(prerequisites[i][0], new ArrayList<>());
			l.add(prerequisites[i][1]);
			graph.put(prerequisites[i][0], l);
		}
		Map<Integer, Set<Integer>> parent = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; ++i) {
			if (indegree[i] == 0) {
				queue.add(i);
				Set<Integer> temp = parent.getOrDefault(i, new HashSet<>());
				temp.add(-1);
				parent.put(i, temp);
			}
		}

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			List<Integer> l = graph.get(curr);

			if (l != null) {
				for (int i = 0; i < l.size(); i++) {
					indegree[l.get(i)]--;
					Set<Integer> temp = parent.getOrDefault(l.get(i), new HashSet<>());
					temp.add(curr);
					temp.addAll(parent.get(curr));
					parent.put(l.get(i), temp);

					if (indegree[l.get(i)] == 0)
						queue.add(l.get(i));
				}
			}
		}
		List<Boolean> ans = new ArrayList<>();
		int m = queries.length;
		for (int i = 0; i < m; ++i) {
			int before = queries[i][0];
			int after = queries[i][1];
			if (parent.containsKey(after) && parent.get(after).contains(before))
				ans.add(true);
			else
				ans.add(false);
		}
		return ans;
	}

}
