/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        // n, h->n (skewed)
//         if(root==null) return 0;
//         int lh = maxDepth(root.left);
//         int rh = maxDepth(root.right);
        
//         return 1+Math.max(lh,rh);
        
        
        // n, n (full BT)
        if (root == null) return 0;
	    Queue<TreeNode> dq = new LinkedList<>();
        int depth = 0, next = 0;
        TreeNode cur;
        dq.add(root);
        
        while (!dq.isEmpty()) {
            depth++;
            next = dq.size();
            for(int i = 0; i < next; ++i) {
                cur = dq.poll();
                if (cur.left != null) dq.add(cur.left);
                if (cur.right != null) dq.add(cur.right);
            }
        }
        return depth;
    }
}