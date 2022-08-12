package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Alice and Bob take turns playing a game, with Alice starting first.
 * 
 * Initially, there are n stones in a pile. On each player's turn, that player
 * makes a move consisting of removing any non-zero square number of stones in
 * the pile.
 * 
 * Also, if a player cannot make a move, he/she loses the game.
 * 
 * Given a positive integer n, return true if and only if Alice wins the game
 * otherwise return false, assuming both players play optimally.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 1 Output: true Explanation: Alice can remove 1 stone winning the
 * game because Bob doesn't have any moves. Example 2:
 * 
 * Input: n = 2 Output: false Explanation: Alice can only remove 1 stone, after
 * that Bob removes the last one winning the game (2 -> 1 -> 0). Example 3:
 * 
 * Input: n = 4 Output: true Explanation: n is already a perfect square, Alice
 * can win with one move, removing 4 stones (4 -> 0).
 *
 */

public class StoneGame4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// DFS with memo -- O(N root N) TC and O(N) space
	public boolean winnerSquareGame(int n) {
		Map<Integer, Boolean> mem = new HashMap<>();
		mem.put(0, false);
		return dfs(mem, n);
	}

	public boolean dfs(Map<Integer, Boolean> mem, int n) {
		if (n == 0)
			return false;
		if (mem.containsKey(n))
			return mem.get(n);

		int sqRoot = (int) Math.sqrt(n);
		for (int i = 1; i <= sqRoot; ++i) {
			if (!dfs(mem, n - (i * i))) { //next chance will be for next player so they need to loose for me to win, 
											//if false that means next loose and i win 
				mem.put(n, true);
				return true;
			}
		}
		mem.put(n, false);
		return false;
	}

	// -------------------------------------------------------------------------
	// DP
	public boolean winnerSquareGame2(int n) {
		boolean[] dp = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int k = 1; k * k <= i; k++) {
				if (dp[i - k * k] == false) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
	}

}
