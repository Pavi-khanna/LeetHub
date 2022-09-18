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
    public boolean isValidBST(TreeNode root) {
        // n,n
        // return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
        
        // n, n
        // long[] prev = {Long.MIN_VALUE};
        // return inorder(root, prev);
        
        
        // n, n
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode node = root;
        long prev = Long.MIN_VALUE;
        
        while(node!=null || !st.isEmpty()) {
            while(node!=null) {
                st.push(node);
                node=node.left;
            }                
            node = st.pop();
            if(node.val<=prev) return false;
            prev = node.val;
            node=node.right;
        }
        return true;
    }
    
    public boolean isValidBST(TreeNode root, long min, long max) {
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;  // 2,2,2 if = removed, int max pe prob
        return isValidBST(root.left, min, root.val)
            && isValidBST(root.right, root.val, max);
    }
    
    public boolean inorder(TreeNode root, long[] prev) {
        if(root==null) return true;
        
        if(!inorder(root.left, prev)) return false;
        if(root.val<=prev[0]) return false;
        prev[0] = root.val;
        return inorder(root.right, prev);
    }
}