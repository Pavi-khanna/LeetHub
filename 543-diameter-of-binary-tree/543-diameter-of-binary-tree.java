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
    public int diameterOfBinaryTree(TreeNode root) {
        int max = 0;
        if(root == null) return 0;
        
        int lh = heightBrute(root.left);
        int rh = heightBrute(root.right);
        
        max = Math.max(max, lh+rh);
        // tc of both the subtrees as well
        int l = diameterOfBinaryTree(root.left);
        int r = diameterOfBinaryTree(root.right);
        
        return Math.max(max, Math.max(l,r));
        
        
        // int[] diameter = new int[1];
        // height(root,diameter);
        // return diameter[0];
    }
    
    public int height(TreeNode node, int[] diameter) {
        if(node==null) return 0;
        
        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);
        
        diameter[0] = Math.max(diameter[0],lh+rh);

        return 1+Math.max(lh,rh);
    }
    
    public int heightBrute(TreeNode node) {
        if(node == null) return 0;
        
        int left = heightBrute(node.left);
        int right = heightBrute(node.right);
        
        return 1 + Math.max(left, right);
    }
}