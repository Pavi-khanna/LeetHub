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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1) return false;
        
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        if(!left || !right) return false;
        
        return true;
        
        
        // return dfsHeight(root) != -1;
    }
    
    public int height(TreeNode node) {
        if(node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        
        return 1 + Math.max(left, right);
    }
    
    int dfsHeight(TreeNode root) {
        if(root==null) return 0;
        int leftHeight = dfsHeight(root.left);
        int rightHeight = dfsHeight(root.right);
        
        if(leftHeight == -1 || rightHeight == -1) return -1;
        if(Math.abs(leftHeight-rightHeight)>1) return -1;
        
        return 1+Math.max(leftHeight,rightHeight);
    }
}