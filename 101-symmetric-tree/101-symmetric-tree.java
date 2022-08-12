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
    public boolean isSymmetric(TreeNode root) {
        // n, n
        // return root == null || isSymmetricUtil(root.left, root.right);
        
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return t1==t2;
            if (t1.val != t2.val) return false;
            
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
    
    public boolean isSymmetricUtil(TreeNode left, TreeNode right) {
        if(left==null || right==null)
            return left==right;
        
        if(left.val != right.val)
            return false;
        
        return isSymmetricUtil(left.left, right.right)
            && isSymmetricUtil(left.right, right.left);
    }
}