package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/most-frequent-subtree-sum/
/*
Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.

The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
Example 1:


Input: root = [5,2,-3]
Output: [2,-3,4]
Example 2:


Input: root = [5,2,-5]
Output: [2]


Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
 */

public class MostFrequentSubtreeSum {
    Map<Integer, List<Integer>> freqMap;
    Map<Integer, Integer> sumFreqMap;
    int max;
    public int[] findFrequentTreeSum(TreeNode root) {
        freqMap = new HashMap<>();
        sumFreqMap = new HashMap<>();
        max = 0;
        recur(root);

        List<Integer> l = freqMap.get(max);
        int[] ans = new int[l.size()];
        for(int i = 0; i < l.size(); ++i) {
            ans[i] = l.get(i);
        }
        return ans;
    }

    public int recur(TreeNode root) {
        if(root == null)
            return 0;

        int left = recur(root.left);
        int right = recur(root.right);
        int sum = left + right + root.val;

        //------------handle freq of subtree sum
        int freq = sumFreqMap.getOrDefault(sum, 0);
        List<Integer> l = freqMap.getOrDefault(freq + 1, new ArrayList<>());
        l.add(sum);
        freqMap.put(freq + 1, l);
        sumFreqMap.put(sum, freq + 1);
        max = Math.max(max, freq + 1);
        //-------------------------------------------------------
        return sum;
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.left = null;
            this.right = null;
            this.val = val;
        }
    }
}
