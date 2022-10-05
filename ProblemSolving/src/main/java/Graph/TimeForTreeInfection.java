package Graph;

import java.util.*;

/**
 * You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.
 *
 * Each minute, a node becomes infected if:
 *
 * The node is currently uninfected.
 * The node is adjacent to an infected node.
 * Return the number of minutes needed for the entire tree to be infected.
 *
 * Example 1:
 * Input: root = [1,5,3,null,4,10,6,9,2], start = 3
 * Output: 4
 * Explanation: The following nodes are infected during:
 * - Minute 0: Node 3
 * - Minute 1: Nodes 1, 10 and 6
 * - Minute 2: Node 5
 * - Minute 3: Node 4
 * - Minute 4: Nodes 9 and 2
 * It takes 4 minutes for the whole tree to be infected so we return 4.
 *
 * Example 2:
 * Input: root = [1], start = 1
 * Output: 0
 * Explanation: At minute 0, the only node in the tree is infected so we return 0.
 */

public class TimeForTreeInfection {

    public static void main(String[] args) {

    }

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        traverseTree(-1, root, graph);
        return bfs(start, graph);
    }

    public void traverseTree(int parent, TreeNode root, Map<Integer, List<Integer>> graph) {
        if (root == null)
            return;
        traverseTree(root.val, root.left, graph);
        if (parent != -1) {
            List<Integer> l = graph.getOrDefault(parent, new ArrayList<>());
            l.add(root.val);
            graph.put(parent, l);
            l = graph.getOrDefault(root.val, new ArrayList<>());
            l.add(parent);
            graph.put(root.val, l);
        }
        traverseTree(root.val, root.right, graph);
    }

    public int bfs(int start, Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        int count = -1;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int curr = q.poll();
                visited.add(curr);

                List<Integer> l = graph.get(curr);
                if (l != null) {
                    for (int neigh : l) {
                        if (!visited.contains(neigh))
                            q.add(neigh);
                    }
                }
            }
            count++;
        }
        return count;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
