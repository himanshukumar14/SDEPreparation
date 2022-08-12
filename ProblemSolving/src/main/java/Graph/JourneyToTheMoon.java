package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * The member states of the UN are planning to send people to the moon. They
 * want them to be from different countries. You will be given a list of pairs
 * of astronaut ID's. Each pair is made of astronauts from the same country.
 * Determine how many pairs of astronauts from different countries they can
 * choose from.
 * 
 * Example
 * 
 * 
 * 
 * There are astronauts numbered through . Astronauts grouped by country are and
 * . There are pairs to choose from: and .
 * 
 * Function Description
 * 
 * Complete the journeyToMoon function in the editor below.
 * 
 * journeyToMoon has the following parameter(s):
 * 
 * int n: the number of astronauts int astronaut[p][2]: each element is a
 * element array that represents the ID's of two astronauts from the same
 * country Returns - int: the number of valid pairs
 * 
 * Input Format
 * 
 * The first line contains two integers and , the number of astronauts and the
 * number of pairs. Each of the next lines contains space-separated integers
 * denoting astronaut ID's of two who share the same nationality.
 *
 */

public class JourneyToTheMoon {

	public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
		// Write your code here
		Map<Integer, List<Integer>> graph = new HashMap<>();
		Set<Integer> visited = new HashSet<>();
		List<Integer> countrySizes = new ArrayList<>();

		for (int i = 0; i < astronaut.size(); ++i) {
			List<Integer> l = graph.getOrDefault(astronaut.get(i).get(0), new ArrayList<>());
			l.add(astronaut.get(i).get(1));
			graph.put(astronaut.get(i).get(0), l);

			l = graph.getOrDefault(astronaut.get(i).get(1), new ArrayList<>());
			l.add(astronaut.get(i).get(0));
			graph.put(astronaut.get(i).get(1), l);
		}

		for (int i = 0; i < n; ++i) {
			if (!visited.contains(i)) {
				int size = dfs(i, graph, visited);
				countrySizes.add(size);
			}
		}

		return calculateWays(countrySizes);
	}

	public static int dfs(int source, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
		Stack<Integer> stack = new Stack<>();
		stack.add(source);
		int count = 0;
		while (!stack.isEmpty()) {
			int curr = stack.pop();
			visited.add(curr);
			count++;
			List<Integer> list = graph.get(curr);
			if (list != null) {
				for (int adj : list) {
					if (!visited.contains(adj)) {
						stack.add(adj);
					}
				}
			}
		}
		return count;
	}

	public static int calculateWays(List<Integer> countrySizes) {
		int sum = 0;
		int result = 0;
		for (int size : countrySizes) {
			result += sum * size;
			sum += size;
		}
		return result;
	}

}
