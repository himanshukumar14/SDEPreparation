package Trees;

import java.util.HashMap;
import java.util.Map;

public class KthSmallestElementInTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Map<TreeNode, Integer> m = new HashMap<>();
    public int kthsmallest(TreeNode A, int B) {
        getsize(A);
        return traverse(A, B);
    }
    
    public int traverse(TreeNode root, int k) {
        int trav = root.left == null ? 0 : m.get(root.left);
        if(trav >= k) {
            return traverse(root.left , k);
        }
        if(trav < k - 1) {
            return traverse(root.right, k - 1 - trav);
        }
        return root.val;  // trav == k - 1
    }
    
    public int getsize(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = getsize(root.left);
        int right = getsize(root.right);

        m.put(root, left + right + 1);        
        return left + right + 1;
    }

}
