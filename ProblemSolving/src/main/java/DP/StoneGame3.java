package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Alice and Bob continue their games with piles of stones. There are several
 * stones arranged in a row, and each stone has an associated value which is an
 * integer given in the array stoneValue.
 * 
 * Alice and Bob take turns, with Alice starting first. On each player's turn,
 * that player can take 1, 2, or 3 stones from the first remaining stones in the
 * row.
 * 
 * The score of each player is the sum of the values of the stones taken. The
 * score of each player is 0 initially.
 * 
 * The objective of the game is to end with the highest score, and the winner is
 * the player with the highest score and there could be a tie. The game
 * continues until all the stones have been taken.
 * 
 * Assume Alice and Bob play optimally.
 * 
 * Return "Alice" if Alice will win, "Bob" if Bob will win, or "Tie" if they
 * will end the game with the same score.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: values = [1,2,3,7] Output: "Bob" Explanation: Alice will always lose.
 * Her best move will be to take three piles and the score become 6. Now the
 * score of Bob is 7 and Bob wins. Example 2:
 * 
 * Input: values = [1,2,3,-9] Output: "Alice" Explanation: Alice must choose all
 * the three piles at the first move to win and leave Bob with negative score.
 * If Alice chooses one pile her score will be 1 and the next move Bob's score
 * becomes 5. In the next move, Alice will take the pile with value = -9 and
 * lose. If Alice chooses two piles her score will be 3 and the next move Bob's
 * score becomes 3. In the next move, Alice will take the pile with value = -9
 * and also lose. Remember that both play optimally so here Alice will choose
 * the scenario that makes her win. Example 3:
 * 
 * Input: values = [1,2,3,6] Output: "Tie" Explanation: Alice cannot win this
 * game. She can end the game in a draw if she decided to choose all the first
 * three piles, otherwise she will lose.
 *
 * 
 */

public class StoneGame3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String stoneGameIII(int[] stoneValue) {
		int n = stoneValue.length;
		int[] prefix = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			prefix[i] = prefix[i - 1] + stoneValue[i - 1];
		}
		Map<Integer, Integer> dp = new HashMap<>();
		int sum = dfs(0, n, prefix, dp);
		if (sum * 2 > prefix[n]) {
			return "Alice";
		}
		if (sum * 2 == prefix[n]) {
			return "Tie";
		}
		return "Bob";
	}

	public int dfs(int start, int end, int[] prefix, Map<Integer, Integer> dp) {
		if (start > end)
			return 0;

		if (dp.containsKey(start))
			return dp.get(start);
		int a = dfs(start + 1, end, prefix, dp);
		int b = dfs(start + 2, end, prefix, dp);
		int c = dfs(start + 3, end, prefix, dp);
		dp.put(start, prefix[end] - prefix[start] - Math.min(a, Math.min(b, c)));
		return prefix[end] - prefix[start] - Math.min(a, Math.min(b, c));
	}
	
	//Iterative version
//    string stoneGameIII(vector<int>& stoneValue) {
//        int n = stoneValue.size();
//        vector<int> prefix(n + 1);
//        for(int i = 0; i < n; i++){
//            prefix[i+1] = prefix[i] + stoneValue[i];
//        }
//        vector<int> dp(n + 4);
//        for(int i = n; i > 0; i--){
//            dp[i] = prefix[n] - prefix[i-1] - min(dp[i+1], min(dp[i+2], dp[i+3]));
//        }
//        if(dp[1]*2 > prefix[n]){
//            return "Alice";
//        }
//        if(dp[1]*2 == prefix[n]){
//            return "Tie";
//        }
//        return "Bob";
//    }

}
