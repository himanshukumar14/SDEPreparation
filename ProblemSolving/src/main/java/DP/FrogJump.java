package DP;

import java.util.HashSet;
import java.util.Set;

public class FrogJump {

	/**
	 * 
	 * A frog is crossing a river. The river is divided into some number of units,
	 * and at each unit, there may or may not exist a stone. The frog can jump on a
	 * stone, but it must not jump into the water.
	 * 
	 * Given a list of stones' positions (in units) in sorted ascending order,
	 * determine if the frog can cross the river by landing on the last stone.
	 * Initially, the frog is on the first stone and assumes the first jump must be
	 * 1 unit.
	 * 
	 * If the frog's last jump was k units, its next jump must be either k - 1, k,
	 * or k + 1 units. The frog can only jump in the forward direction.
	 * 
	 * Example 1:
	 * 
	 * Input: stones = [0,1,3,5,6,8,12,17] Output: true Explanation: The frog can
	 * jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to
	 * the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone,
	 * 4 units to the 7th stone, and 5 units to the 8th stone. Example 2:
	 * 
	 * Input: stones = [0,1,2,3,4,8,9,11] Output: false Explanation: There is no way
	 * to jump to the last stone as the gap between the 5th and 6th stone is too
	 * large.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canCross(int[] stones) {
		if (stones.length == 1)
			return true;
		if (stones[1] != stones[0] + 1)
			return false;
		int[] increment = { 1, 0, -1 };
		Set<Integer> set = new HashSet<>();
		int n = stones.length;

		for (int i = 0; i < n; i++)
			set.add(stones[i]);

		return dfs(stones[0], stones[n - 1], set, 1, new HashSet<String>(), increment);
	}

	public boolean dfs(int pos, int dest, Set<Integer> set, int jump, Set<String> visited, int[] increment) {
		String identifier = pos + "," + jump;
		if (visited.contains(identifier))
			return false;

		visited.add(identifier);

		if (pos + jump == dest)
			return true;

		if (set.contains(pos + jump)) {
			for (int inc : increment) {
				int newjump = jump + inc;
				if (newjump > 0) {
					if (dfs(pos + jump, dest, set, newjump, visited, increment))
						return true;
				}
			}
		}
		return false;
	}

}
